package in_.turker.baseapp.ui.fragment.detail

import android.app.Application
import dagger.hilt.android.lifecycle.HiltViewModel
import in_.turker.baseapp.base.BaseViewModel
import javax.inject.Inject

/**
 * Created by Kerem TÜRKER on 4.03.2022.
 */

@HiltViewModel
class DetailVM @Inject constructor(
    myApp: Application
) : BaseViewModel(app = myApp)