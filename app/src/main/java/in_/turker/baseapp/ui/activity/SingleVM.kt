package in_.turker.baseapp.ui.activity

import android.app.Application
import dagger.hilt.android.lifecycle.HiltViewModel
import in_.turker.baseapp.base.BaseViewModel
import javax.inject.Inject

/**
 * Created by Kerem TÜRKER on 4.03.2022.
 */

@HiltViewModel
class SingleVM
@Inject constructor(myApp: Application) : BaseViewModel(app = myApp)