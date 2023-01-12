package pt.ipca.smartcanteen.models.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import pt.ipca.smartcanteen.models.adapters.viewHolders.UndeliveredOrdersAdapterRecViewHolder
import pt.ipca.smartcanteen.models.RetroTicket
import pt.ipca.smartcanteen.models.RetroTrade

class UndeliveredOrdersAdaterRec(private val undeliveredOrdersList: List<RetroTrade>) :
    RecyclerView.Adapter<UndeliveredOrdersAdapterRecViewHolder>() {

    var onItemClick : ((RetroTicket) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UndeliveredOrdersAdapterRecViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return UndeliveredOrdersAdapterRecViewHolder(inflater,parent)
    }

    override fun onBindViewHolder(holder: UndeliveredOrdersAdapterRecViewHolder, position: Int) {
        val nencomenda = undeliveredOrdersList.get(position).norder
        val name = undeliveredOrdersList.get(position).ownername
        val statename = undeliveredOrdersList.get(position).statename
        holder.bindData(nencomenda,name,statename)

        //holder.itemView.setOnClickListener{
        //    onItemClick?.invoke(undeliveredOrder)
        //}
        //holder.itemView.setOnClickListener {
        //    onItemClick?.invoke(undeliveredOrdersList[position])
        //}
    }

    override fun getItemCount(): Int {
        return undeliveredOrdersList.size
    }
}