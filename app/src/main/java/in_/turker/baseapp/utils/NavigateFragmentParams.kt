package in_.turker.baseapp.utils

import android.os.Bundle
import androidx.navigation.NavOptions
import androidx.navigation.fragment.FragmentNavigator

/**
 * Created by Kerem TÜRKER on 4.03.2022.
 */

data class NavigateFragmentParams(
    val navAction: Int,
    val bundle: Bundle? = null,
    val navOptions: NavOptions? = null,
    val extras: FragmentNavigator.Extras? = null
)
