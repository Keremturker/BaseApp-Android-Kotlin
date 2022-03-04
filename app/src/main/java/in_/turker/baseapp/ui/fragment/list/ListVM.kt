package in_.turker.baseapp.ui.fragment.list

import android.app.Application
import android.os.Bundle
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import in_.turker.baseapp.R
import in_.turker.baseapp.base.BaseViewModel
import in_.turker.baseapp.model.CarItem
import in_.turker.baseapp.repository.CarsRepository
import in_.turker.baseapp.utils.ApiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by Kerem TÜRKER on 4.03.2022.
 */

@HiltViewModel
class ListVM @Inject constructor(
    myApp: Application,
    private val carsRepository: CarsRepository
) : BaseViewModel(app = myApp) {

    private val _onCarList = MutableStateFlow<ApiState<List<CarItem>?>>(ApiState.Empty)
    val onCarList: StateFlow<ApiState<List<CarItem>?>> = _onCarList

    init {
        getCars()
    }

    private fun getCars() = viewModelScope.launch {
        _onCarList.value = ApiState.Loading
        carsRepository.getCars(
            scope = viewModelScope,
            onSuccess = {
                loadingDetection.postValue(false)
                _onCarList.value = ApiState.Success(it)
            }, onErrorAction = {
                loadingDetection.postValue(false)
                _onCarList.value = ApiState.Failure(it)
            })
    }

    fun goToDetail(car: CarItem) {
        Bundle().apply {
            putSerializable("car", car)
            navigateFragment(R.id.action_global_fragmentDetail, this)
        }
    }
}