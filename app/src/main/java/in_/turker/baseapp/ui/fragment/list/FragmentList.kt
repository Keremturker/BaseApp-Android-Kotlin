package in_.turker.baseapp.ui.fragment.list

import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import in_.turker.baseapp.base.BaseFragment
import in_.turker.baseapp.databinding.FragmentListBinding

/**
 * Created by Kerem TÜRKER on 4.03.2022.
 */

@AndroidEntryPoint
class FragmentList : BaseFragment<FragmentListBinding, ListVM>() {
    override val viewModel: ListVM by viewModels()

    override fun getViewBinding() = FragmentListBinding.inflate(layoutInflater)


    override fun onFragmentCreated() {}
}