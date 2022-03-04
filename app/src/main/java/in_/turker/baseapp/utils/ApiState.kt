package in_.turker.baseapp.utils

/**
 * Created by Kerem TÜRKER on 4.03.2022.
 */

sealed class ApiState<out T> {
    object Loading : ApiState<Nothing>()

    object Empty : ApiState<Nothing>()

    data class Success<out T>(val data: T) : ApiState<T>()

    data class Failure(
        val errorMessage: String?
    ) : ApiState<Nothing>()
}
