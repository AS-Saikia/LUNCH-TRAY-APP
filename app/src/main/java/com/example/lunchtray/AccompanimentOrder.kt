package com.example.lunchtray

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
import com.example.lunchtray.adapter.AccompItemAdapter

import com.example.lunchtray.databinding.FragmentAccompanimentOrderBinding

import com.example.lunchtray.model.OrderViewModel


class AccompanimentOrder : Fragment() {


    private val sharedViewModel: OrderViewModel by activityViewModels()
    private var binding: FragmentAccompanimentOrderBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = FragmentAccompanimentOrderBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mydataset = datasource().loadInfoAccompaniment()
        binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            viewModel = sharedViewModel
            accompanimentOrder = this@AccompanimentOrder
            recyclerView?.adapter = AccompItemAdapter(
                sharedViewModel,
                this@AccompanimentOrder.requireContext(),
                mydataset
            )
            recyclerView.layoutManager =
                LinearLayoutManager(
                    this@AccompanimentOrder.requireContext(),
                    LinearLayoutManager.VERTICAL,
                    false
                )
        }
    }

    fun gotoNextScreen() {
        findNavController().navigate(R.id.action_accompanimentOrder_to_orderSummary)
    }

    fun cancel() {
        findNavController().navigate(R.id.action_accompanimentOrder_to_startFragment)
        sharedViewModel.resetOrder()
        Toast.makeText(activity, "Order Cancelled", Toast.LENGTH_SHORT).show()

    }


    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}