package in_.turker.baseapp.model


import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * Created by Kerem TÜRKER on 4.03.2022.
 */

data class CarItem(
    @SerializedName("BrandName")
    val brandName: String,
    @SerializedName("MediumImageUrl")
    val mediumImageUrl: String,
    @SerializedName("ModelName")
    val modelName: String,
    @SerializedName("ModelYear")
    val modelYear: String,
    @SerializedName("Plate")
    val plate: String,
    @SerializedName("Price")
    val price: String
) : Serializable