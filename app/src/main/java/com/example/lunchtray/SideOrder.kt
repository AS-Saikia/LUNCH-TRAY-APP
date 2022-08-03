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
import com.example.lunchtray.adapter.SideItemAdapter
import com.example.lunchtray.databinding.FragmentSideOrderBinding
import com.example.lunchtray.model.OrderViewModel


class SideOrder : Fragment() {


    private val sharedViewModel: OrderViewModel by activityViewModels()
    private var binding: FragmentSideOrderBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = FragmentSideOrderBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mydataset = datasource().loadInfoSide()
        binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            viewModel = sharedViewModel
            sideOrder = this@SideOrder
            recyclerView?.adapter = SideItemAdapter(
                sharedViewModel,
                this@SideOrder.requireContext(),
                mydataset
            )
            recyclerView.layoutManager =
                LinearLayoutManager(
                    this@SideOrder.requireContext(),
                    LinearLayoutManager.VERTICAL,
                    false
                )

        }
    }

    fun gotoNextScreen() {
        findNavController().navigate(R.id.action_sideOrder_to_accompanimentOrder)
    }

    fun cancel() {
        findNavController().navigate(R.id.action_sideOrder_to_startFragment)
        sharedViewModel.resetOrder()
        Toast.makeText(activity, "Order Cancelled", Toast.LENGTH_SHORT).show()

    }


    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}