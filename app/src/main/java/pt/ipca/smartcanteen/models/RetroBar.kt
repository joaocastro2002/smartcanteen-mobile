package pt.ipca.smartcanteen.models

import com.google.gson.annotations.SerializedName

class RetroBar (
    @SerializedName("barid") var barid:String,
    @SerializedName("name") var name:String)