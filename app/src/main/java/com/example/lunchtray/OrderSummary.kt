package com.example.lunchtray

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lunchtray.DATA.datasource
import com.example.lunchtray.adapter.SideItemAdapter
import com.example.lunchtray.databinding.FragmentOrderSummaryBinding
import com.example.lunchtray.databinding.FragmentSideOrderBinding
import com.example.lunchtray.model.OrderViewModel


class OrderSummary : Fragment() {



    private val sharedViewModel: OrderViewModel by activityViewModels()
    private var binding: FragmentOrderSummaryBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = FragmentOrderSummaryBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mydataset = datasource().loadInfoSide()
        binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            viewModel = sharedViewModel
            summaryFragment = this@OrderSummary
        }
    }



    fun cancel() {
        findNavController().navigate(R.id.action_orderSummary_to_startFragment)
        sharedViewModel.resetOrder()
        Toast.makeText(activity, "Order Cancelled", Toast.LENGTH_SHORT).show()

    }
    fun sendOrder() {
        val orderSummary = getString(
            R.string.order_details,
            sharedViewModel.entree.value.toString(),
            sharedViewModel.side.value.toString(),
            sharedViewModel.accompaniment.value.toString(),
            sharedViewModel.subtotal.value.toString()
        )
        val intent = Intent(Intent.ACTION_SEND)
            .setType("text/plain")
            .putExtra(Intent.EXTRA_SUBJECT, getString(R.string.new_order))
            .putExtra(Intent.EXTRA_TEXT, orderSummary)
        if (activity?.packageManager?.resolveActivity(intent, 0) != null) {
            startActivity(intent)
        }
        findNavController().navigate(R.id.action_orderSummary_to_startFragment)
        sharedViewModel.resetOrder()
    }


    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}