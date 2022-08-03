package com.example.lunchtray.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lunchtray.databinding.ListItemMainBinding
import com.example.lunchtray.model.OrderViewModel
import com.example.lunchtray.model.item

class MainItemAdapter
    (
    private val sharedViewModel: OrderViewModel,
    private val context: Context,
    private val dataset: List<item>

) : RecyclerView.Adapter<MainItemAdapter.ItemViewHolder>() {


    class ItemViewHolder(
        private val binding: ListItemMainBinding,

        ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(sharedViewModel: OrderViewModel,context: Context, item: item) {
            binding?.apply {
                lifecycleOwner = lifecycleOwner
                viewModel= sharedViewModel
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
    ): MainItemAdapter.ItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListItemMainBinding.inflate(inflater)
        return MainItemAdapter.ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MainItemAdapter.ItemViewHolder, position: Int) {
        val item = dataset.get(position)
        holder.bind(sharedViewModel,context, item)

    }

    override fun getItemCount(): Int {
        return dataset.size
    }
}

