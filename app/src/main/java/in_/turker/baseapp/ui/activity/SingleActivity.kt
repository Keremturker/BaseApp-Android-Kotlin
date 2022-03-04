package in_.turker.baseapp.ui.activity


import android.content.Intent
import androidx.activity.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import dagger.hilt.android.AndroidEntryPoint
import in_.turker.baseapp.R
import in_.turker.baseapp.base.BaseActivity
import in_.turker.baseapp.databinding.ActivitySingleBinding
import in_.turker.baseapp.utils.NavigateFragmentParams

@AndroidEntryPoint
class SingleActivity : BaseActivity<ActivitySingleBinding, SingleVM>(){

    override val viewModel: SingleVM by viewModels()
    override fun getViewBinding() = ActivitySingleBinding.inflate(layoutInflater)

    private var currentNavController: NavController? = null


    override fun onActivityCreated() {
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.sectionMain)
        currentNavController = (navHostFragment as NavHostFragment).navController
    }

    override fun supportNavigateUpTo(upIntent: Intent) {
        currentNavController?.navigateUp()
    }

    override fun observe() {}

    override fun navigateFragment(params: NavigateFragmentParams) {
        currentNavController?.navigate(
            params.navAction,
            params.bundle,
            params.navOptions,
            params.extras
        )
    }

}