package in_.turker.baseapp.ui.fragment.list

import android.view.LayoutInflater
import android.view.ViewGroup
import in_.turker.baseapp.base.BaseAdapter
import in_.turker.baseapp.base.BaseHolder
import in_.turker.baseapp.databinding.ItemCarBinding
import in_.turker.baseapp.model.CarItem

/**
 * Created by Kerem TÜRKER on 4.03.2022.
 */

class CarListAdapter(private val onClickAction: ((CarItem) -> Unit)) :
    BaseAdapter<CarItem, ItemCarBinding, CarListHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CarListHolder {
        return CarListHolder(
            ItemCarBinding.inflate(LayoutInflater.from(parent.context), parent, false),
            onClickAction
        )
    }

}

class CarListHolder(
    viewBinding: ItemCarBinding,
    private val onClickAction: ((CarItem) -> Unit)
) :
    BaseHolder<CarItem, ItemCarBinding>(viewBinding) {
    override fun bind(binding: ItemCarBinding, item: CarItem?) {
        item?.let { car ->
            binding.apply {

                txtCarBrand.text = car.brandName
                txtCarModel.text = car.modelName

                cvParent.setOnClickListener {
                    onClickAction.invoke(car)
                }
            }
        } ?: return
    }
}