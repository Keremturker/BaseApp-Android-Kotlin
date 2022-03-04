package in_.turker.baseapp.utils

import android.view.View
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData

/**
 * Created by Kerem TÜRKER on 4.03.2022.
 */

fun <T> LiveData<T>.observeThis(owner: LifecycleOwner, function: (T) -> Unit) {
    observe(owner) {
        it?.let {
            function(it)
        }
    }
}

fun View.visibleIf(visible: Boolean) {
    visibility = if (visible) View.VISIBLE else View.GONE
}
