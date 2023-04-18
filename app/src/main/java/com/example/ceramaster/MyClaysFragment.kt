package com.example.ceramaster

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ceramaster.databinding.FragmentMyClaysBinding

class MyClaysFragment: Fragment(), OnItemListClickListener {
    private var _binding: FragmentMyClaysBinding? = null
    private val binding: FragmentMyClaysBinding
        get() = _binding!!

    private val clayListAdapter: MyClaysListAdapter by lazy {
        MyClaysListAdapter(this, baseClays)
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMyClaysBinding.inflate(inflater, container, false)
        //какая-то залупа с адаптером
        binding.recyclerView2.adapter = clayListAdapter
        clayListAdapter.setData(baseClays)
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() = MyClaysFragment()
    }
    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }

    override fun onItemClickListener(clay: ClayInfo) {
        TODO("Not yet implemented")
    }
}