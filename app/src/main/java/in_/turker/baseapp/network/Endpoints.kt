package in_.turker.baseapp.network

import in_.turker.baseapp.model.CarItem
import retrofit2.http.POST

/**
 * Created by Kerem TÜRKER on 4.03.2022.
 */

interface Endpoints {

    @POST("cars.php")
    suspend fun getCars(): List<CarItem>

}