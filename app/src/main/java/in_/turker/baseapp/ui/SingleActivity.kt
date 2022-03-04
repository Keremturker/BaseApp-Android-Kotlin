package in_.turker.baseapp.ui


import androidx.activity.viewModels
import dagger.hilt.android.AndroidEntryPoint
import in_.turker.baseapp.base.BaseActivity
import in_.turker.baseapp.databinding.ActivitySingleBinding

@AndroidEntryPoint
class SingleActivity : BaseActivity<ActivitySingleBinding, SingleVM>(){

    override val viewModel: SingleVM by viewModels()

    override fun getViewBinding() = ActivitySingleBinding.inflate(layoutInflater)

    override fun onActivityCreated() {}

    override fun observe() {}

}