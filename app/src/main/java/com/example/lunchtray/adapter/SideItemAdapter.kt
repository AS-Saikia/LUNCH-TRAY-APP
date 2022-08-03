package com.example.lunchtray.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

import com.example.lunchtray.databinding.ListItemSideBinding
import com.example.lunchtray.model.OrderViewModel
import com.example.lunchtray.model.item

class SideItemAdapter (
    private val sharedViewModel: OrderViewModel,
    private val context: Context,
    private val dataset: List<item>

) : RecyclerView.Adapter<SideItemAdapter.ItemViewHolder>() {
    class ItemViewHolder(
        private val binding: ListItemSideBinding,
        ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(sharedViewModel: OrderViewModel,context: Context, item: item) {
            binding?.apply {
                lifecycleOwner = lifecycleOwner
                viewModel = sharedViewModel
                name = context.resources.getString(item.nameResourceID)
                description = context.resources.getString(item.descriptionResourceID)
                price = context.resources.getString(item.priceResourceID)
                food.setImageResource(item.imageResourceViewID)
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SideItemAdapter.ItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListItemSideBinding.inflate(inflater)
        return SideItemAdapter.ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SideItemAdapter.ItemViewHolder, position: Int) {
        val item = dataset.get(position)
        holder.bind(sharedViewModel,context,item)
    }

    override fun getItemCount(): Int {
        return dataset.size
    }
}