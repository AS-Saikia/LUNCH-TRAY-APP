package com.example.lunchtray.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lunchtray.databinding.ListItemAccompenimentBinding
import com.example.lunchtray.model.OrderViewModel
import com.example.lunchtray.model.item

import com.example.lunchtray.model.item_accomp

class AccompItemAdapter (
    private val sharedViewModel: OrderViewModel,
    private val context: Context,
    private val dataset: List<item_accomp>

) : RecyclerView.Adapter<AccompItemAdapter.ItemViewHolder>() {
    class ItemViewHolder(
        private val binding: ListItemAccompenimentBinding,
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(sharedViewModel: OrderViewModel,context: Context, item: item_accomp) {
            binding?.apply {
                lifecycleOwner = lifecycleOwner
                viewModel = sharedViewModel
                name = context.resources.getString(item.nameResourceID)

                price = context.resources.getString(item.priceResourceID)
                food.setImageResource(item.imageResourceViewID)
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AccompItemAdapter.ItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListItemAccompenimentBinding.inflate(inflater)
        return AccompItemAdapter.ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AccompItemAdapter.ItemViewHolder, position: Int) {
        val item = dataset.get(position)
        holder.bind(sharedViewModel,context,item)
    }

    override fun getItemCount(): Int {
        return dataset.size
    }
}