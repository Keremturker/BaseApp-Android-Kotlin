package in_.turker.baseapp.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import in_.turker.baseapp.utils.NavigateFragmentParams

/**
 * Created by Kerem TÜRKER on 4.03.2022.
 */

abstract class BaseActivity<BindingType : ViewBinding, ViewModelType : BaseViewModel> :
    AppCompatActivity() {

    lateinit var binding: BindingType
    abstract fun onActivityCreated()
    abstract fun observe()
    abstract fun navigateFragment(params: NavigateFragmentParams)
    abstract fun showHideProgress(isShow: Boolean)
    abstract fun getViewBinding(): BindingType
    protected abstract val viewModel: ViewModelType

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = getViewBinding()
        setContentView(binding.root)
        onActivityCreated()
        observe()
    }

}