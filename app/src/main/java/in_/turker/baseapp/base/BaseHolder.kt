package in_.turker.baseapp.base

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

/**
 * Created by Kerem TÜRKER on 4.03.2022.
 */

/**
 * Base Holder class for [RecyclerView.ViewHolder]
 */
abstract class BaseHolder<DataType, BindingType : ViewBinding> constructor(internal val viewDataBinding: BindingType) :
    RecyclerView.ViewHolder(viewDataBinding.root) {

    /**
     * Getter for [DataType] class
     */
    var item: DataType? = null

    /**
     * Binds holder data
     */
    abstract fun bind(binding: BindingType, item: DataType?)
}