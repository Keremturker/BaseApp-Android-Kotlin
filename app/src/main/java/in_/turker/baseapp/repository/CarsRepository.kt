package in_.turker.baseapp.repository

import in_.turker.baseapp.base.BaseRepository
import in_.turker.baseapp.model.CarItem
import in_.turker.baseapp.network.APIClientImpl
import kotlinx.coroutines.CoroutineScope
import javax.inject.Inject

/**
 * Created by Kerem TÜRKER on 4.03.2022.
 */
class CarsRepository @Inject
constructor(private val apiServiceImpl: APIClientImpl) : BaseRepository() {

    suspend fun getCars(
        scope: CoroutineScope,
        onSuccess: ((List<CarItem>?) -> Unit),
        onErrorAction: ((String?) -> Unit)
    ) =
        sendRequest(
            scope = scope,
            client = { apiServiceImpl.apiCollect.getCars() },
            onSuccess = {
                onSuccess(it)
            },
            onErrorAction = {
                onErrorAction(it)
            }
        )
}