package com.example.ceramaster.supplement

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.ceramaster.KEY_BUNDLE_CLAY
import com.example.ceramaster.R
import com.example.ceramaster.databinding.FragmentMySupplementsBinding
import com.example.ceramaster.glaze.GlazeCardFragment

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

    override fun onItemClickListener(supplement: SupplementInfo) {
        activity?.supportFragmentManager?.beginTransaction()?.replace(
            R.id.fragment_container,
            SupplementCardFragment.newInstance(Bundle().apply
            { putParcelable(KEY_BUNDLE_CLAY, supplement) })
        )?.addToBackStack("")?.commit()
    }
}