package in_.turker.baseapp.ui.fragment.list

import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import dagger.hilt.android.AndroidEntryPoint
import in_.turker.baseapp.base.BaseFragment
import in_.turker.baseapp.databinding.FragmentListBinding
import in_.turker.baseapp.model.CarItem
import in_.turker.baseapp.utils.ApiState
import in_.turker.baseapp.utils.visibleIf
import kotlinx.coroutines.flow.collect

/**
 * Created by Kerem TÜRKER on 4.03.2022.
 */

@AndroidEntryPoint
class FragmentList : BaseFragment<FragmentListBinding, ListVM>() {
    override val viewModel: ListVM by viewModels()

    override fun getViewBinding() = FragmentListBinding.inflate(layoutInflater)

    private val carListAdapter = CarListAdapter(::onClickAction)

    override fun onFragmentCreated() {
        binding.rvCar.adapter = carListAdapter
    }

    override fun observe() {

        lifecycleScope.launchWhenResumed {

            viewModel.onCarList.collect {
                when (it) {
                    ApiState.Empty -> {}

                    ApiState.Loading -> {
                        viewModel.loadingDetection.postValue(true)
                    }

                    is ApiState.Failure -> {
                        binding.apply {
                            rvCar.visibleIf(false)
                            txtNoRecord.visibleIf(true)
                        }
                    }

                    is ApiState.Success -> {
                        binding.apply {
                            txtNoRecord.visibleIf(false)
                            rvCar.visibleIf(true)
                        }
                        carListAdapter.replaceData(it.data)
                    }
                }
            }
        }
    }

    private fun onClickAction(car: CarItem) {
        viewModel.goToDetail(car)
    }
}