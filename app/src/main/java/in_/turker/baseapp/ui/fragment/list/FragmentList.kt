package in_.turker.baseapp.ui.fragment.list

import android.util.Log
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import dagger.hilt.android.AndroidEntryPoint
import in_.turker.baseapp.base.BaseFragment
import in_.turker.baseapp.databinding.FragmentListBinding
import in_.turker.baseapp.utils.ApiState
import kotlinx.coroutines.flow.collect

/**
 * Created by Kerem TÜRKER on 4.03.2022.
 */

@AndroidEntryPoint
class FragmentList : BaseFragment<FragmentListBinding, ListVM>() {
    override val viewModel: ListVM by viewModels()

    override fun getViewBinding() = FragmentListBinding.inflate(layoutInflater)


    override fun onFragmentCreated() {}


    override fun observe() {

        lifecycleScope.launchWhenCreated {

            viewModel.onCarList.collect {
                when (it) {
                    ApiState.Empty -> {}

                    ApiState.Loading -> {
                        viewModel.loadingDetection.postValue(true)
                    }

                    is ApiState.Failure -> {}
                    is ApiState.Success -> {
                        Log.d("test123", "Success")
                        Log.d("test123", "size: " + it.data?.size)
                    }
                }
            }
        }
    }
}