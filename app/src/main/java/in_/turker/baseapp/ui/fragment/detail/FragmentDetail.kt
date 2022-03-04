package in_.turker.baseapp.ui.fragment.detail

import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import in_.turker.baseapp.R
import in_.turker.baseapp.base.BaseFragment
import in_.turker.baseapp.databinding.FragmentDetailBinding
import in_.turker.baseapp.model.CarItem
import in_.turker.baseapp.utils.CAR_ITEM
import in_.turker.baseapp.utils.loadImagesWithGlide

/**
 * Created by Kerem TÜRKER on 4.03.2022.
 */

@AndroidEntryPoint
class FragmentDetail : BaseFragment<FragmentDetailBinding, DetailVM>() {
    override val viewModel: DetailVM by viewModels()

    override fun getViewBinding() = FragmentDetailBinding.inflate(layoutInflater)

    override fun onFragmentCreated() {
        val car = arguments?.getSerializable(CAR_ITEM) as CarItem?

        binding.apply {
            car?.let {
                imgCar.loadImagesWithGlide(it.mediumImageUrl)
                txtBrandContent.text = it.brandName
                txtModelContent.text = it.modelName
                txtPlateContent.text = it.plate
                txtYearContent.text = it.modelYear
                txtPriceContent.text = getString(R.string.price_value, it.price)
            }
        }
    }
}