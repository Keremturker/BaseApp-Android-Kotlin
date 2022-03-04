package in_.turker.baseapp.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import in_.turker.baseapp.utils.observeThis

/**
 * Created by Kerem TÜRKER on 4.03.2022.
 */

abstract class BaseFragment<BindingType : ViewBinding, ViewModelType : BaseViewModel> :
    Fragment() {

    private val baseActivity by lazy { activity as BaseActivity<*, *>? }

    lateinit var binding: BindingType
    protected abstract val viewModel: ViewModelType
    abstract fun getViewBinding(): BindingType
    abstract fun onFragmentCreated()
    open fun observe() {}

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = getViewBinding()
        onFragmentCreated()
        observe()
        observeActions()
        return binding.root
    }

    private fun observeActions() {
        viewModel.navigateFragmentDetection.observeThis(viewLifecycleOwner) {
            baseActivity?.navigateFragment(it)
        }
        viewModel.loadingDetection.observeThis(viewLifecycleOwner) {
            baseActivity?.showHideProgress(it)
        }
    }

}