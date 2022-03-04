package in_.turker.baseapp.ui.fragment.list

import android.app.Application
import dagger.hilt.android.lifecycle.HiltViewModel
import in_.turker.baseapp.R
import in_.turker.baseapp.base.BaseViewModel
import javax.inject.Inject

/**
 * Created by Kerem TÜRKER on 4.03.2022.
 */

@HiltViewModel
class ListVM @Inject constructor(
    myApp: Application
) : BaseViewModel(app = myApp) {

    init {
        goToPageTwo()
    }

    private fun goToPageTwo() {
        navigateFragment(R.id.action_global_fragmentDetail)
    }
}