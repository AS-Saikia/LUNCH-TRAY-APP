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
import com.example.lunchtray.adapter.MainItemAdapter
import com.example.lunchtray.databinding.FragmentMainOrderBinding
import com.example.lunchtray.model.OrderViewModel


class MainOrder : Fragment() {
    private val sharedViewModel: OrderViewModel by activityViewModels()
    private var binding: FragmentMainOrderBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = FragmentMainOrderBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mydataset = datasource().loadInfoMain()
        binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            viewModel = sharedViewModel
            mainOrder = this@MainOrder
            recyclerView?.adapter = MainItemAdapter(
                sharedViewModel,
                this@MainOrder.requireContext(),
                mydataset
            )
            recyclerView.layoutManager =
                LinearLayoutManager(
                    this@MainOrder.requireContext(),
                    LinearLayoutManager.VERTICAL,
                    false
                )

        }
    }

    fun gotoNextScreen() {
        findNavController().navigate(R.id.action_mainOrder_to_sideOrder)
    }

    fun cancel() {
        findNavController().navigate(R.id.action_mainOrder_to_startFragment)
        sharedViewModel.resetOrder()
        Toast.makeText(activity, "Order Cancelled", Toast.LENGTH_SHORT).show()
    }


    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}