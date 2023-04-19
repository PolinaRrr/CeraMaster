package com.example.ceramaster.supplement

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.ceramaster.databinding.FragmentMySupplementsBinding

class MySupplementsFragment: Fragment(), OnItemListClickListener {
    private var _binding: FragmentMySupplementsBinding? = null
    private val binding: FragmentMySupplementsBinding
        get() = _binding!!

    private val supplementListAdapter: MySupplementsListAdapter by lazy {
        MySupplementsListAdapter(this, baseSupplements)
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMySupplementsBinding.inflate(inflater, container, false)
        binding.supplementRecyclerView.adapter = supplementListAdapter
        supplementListAdapter.setData(baseSupplements)
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() = MySupplementsFragment()
    }
    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }

    override fun onItemClickListener(supplements: SupplementInfo) {
        TODO("Not yet implemented")
    }
}