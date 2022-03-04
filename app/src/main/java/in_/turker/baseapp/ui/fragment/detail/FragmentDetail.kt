package in_.turker.baseapp.ui.fragment.detail

import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import in_.turker.baseapp.base.BaseFragment
import in_.turker.baseapp.databinding.FragmentDetailBinding

/**
 * Created by Kerem TÜRKER on 4.03.2022.
 */

@AndroidEntryPoint
class FragmentDetail : BaseFragment<FragmentDetailBinding, DetailVM>() {
    override val viewModel: DetailVM by viewModels()

    override fun getViewBinding() = FragmentDetailBinding.inflate(layoutInflater)

    override fun onFragmentCreated() {}
}