package in_.turker.baseapp.base

import android.annotation.SuppressLint
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

/**
 * Created by Kerem TÜRKER on 4.03.2022.
 */

/**
 * Base Class for [RecyclerView.Adapter]
 */
abstract class BaseAdapter<ItemType, BindingType : ViewBinding, ViewHolderType : BaseHolder<ItemType, BindingType>> :
    RecyclerView.Adapter<ViewHolderType>() {

    private val itemList: MutableList<ItemType> = ArrayList()
    private var itemPosition = -1

    override fun onBindViewHolder(@NonNull holder: ViewHolderType, @SuppressLint("RecyclerView") position: Int) {
        val itemData = itemList[position] ?: return
        itemPosition = position
        holder.item = itemData
        holder.bind(holder.viewDataBinding, itemData)
    }

    @SuppressLint("NotifyDataSetChanged")
    open fun replaceData(newList: List<ItemType>?) {
        itemList.clear()
        itemList.addAll(newList ?: emptyList())
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = itemList.size

    fun getData(): MutableList<ItemType> {
        return itemList
    }
}