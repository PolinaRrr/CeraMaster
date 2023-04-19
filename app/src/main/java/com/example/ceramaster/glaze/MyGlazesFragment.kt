package com.example.ceramaster.glaze

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.ceramaster.databinding.FragmentMyGlazesBinding

class MyGlazesFragment: Fragment(), OnItemListClickListener {
    private var _binding: FragmentMyGlazesBinding? = null
    private val binding: FragmentMyGlazesBinding
        get() = _binding!!

    private val glazeListAdapter: MyGlazesListAdapter by lazy {
        MyGlazesListAdapter(this, baseGlazes)
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMyGlazesBinding.inflate(inflater, container, false)
        binding.glazeRecyclerView.adapter = glazeListAdapter
        glazeListAdapter.setData(baseGlazes)
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() = MyGlazesFragment()
    }
    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }

    override fun onItemClickListener(glaze: GlazeInfo) {
        TODO("Not yet implemented")
    }
}