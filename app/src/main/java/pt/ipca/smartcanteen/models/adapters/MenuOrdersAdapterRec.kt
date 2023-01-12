package pt.ipca.smartcanteen.models.adapters

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import pt.ipca.smartcanteen.models.RetroTrade
import pt.ipca.smartcanteen.models.adapters.viewHolders.MenuOrdersAdapterRecViewHolder
import pt.ipca.smartcanteen.views.activities.OrderDetailsActivity

class MenuOrdersAdapterRec(private val activity: Activity, private val qtyString:String,private val orderString:String,private var ordersList: List<RetroTrade>) :
    RecyclerView.Adapter<MenuOrdersAdapterRecViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuOrdersAdapterRecViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return MenuOrdersAdapterRecViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: MenuOrdersAdapterRecViewHolder, position: Int) {
        val norder = "${orderString}: ${ordersList[position].norder}"
        val amount = "${qtyString}: ${ordersList[position].ticketamount}"
        val total = "${ordersList[position].total}€"
        val statename = ordersList[position].statename

        holder.itemView.setOnClickListener{
            var intent = Intent(activity, OrderDetailsActivity::class.java).apply {
                putExtra("ticketid",ordersList[position].ticketid)
            }
            activity.startActivity(intent)
        }

        holder.bindData(amount, total, statename, norder)
    }


    override fun getItemCount(): Int {
        return ordersList.size
    }
}