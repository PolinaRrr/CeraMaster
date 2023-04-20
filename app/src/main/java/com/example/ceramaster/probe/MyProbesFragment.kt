package com.example.ceramaster.probe

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.ceramaster.databinding.FragmentMyProbesBinding

class MyProbesFragment: Fragment(), OnItemListClickListener {
    private var _binding: FragmentMyProbesBinding? = null
    private val binding: FragmentMyProbesBinding
        get() = _binding!!

    private val probeListAdapter: MyProbesListAdapter by lazy {
        MyProbesListAdapter(this, baseProbes)
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMyProbesBinding.inflate(inflater, container, false)
        binding.probesRecyclerView.adapter = probeListAdapter
        probeListAdapter.setData(baseProbes)
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() = MyProbesFragment()
    }
    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }

    override fun onItemClickListener(probe: ProbeInfo) {
        TODO("Not yet implemented")
    }
}