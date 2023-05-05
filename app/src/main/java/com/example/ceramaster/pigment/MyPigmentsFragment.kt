package com.example.ceramaster.pigment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.ceramaster.KEY_BUNDLE_CLAY
import com.example.ceramaster.R
import com.example.ceramaster.databinding.FragmentMyPigmentsBinding
import com.example.ceramaster.glaze.GlazeCardFragment

class MyPigmentsFragment: Fragment(), OnItemListClickListener {
    private var _binding: FragmentMyPigmentsBinding? = null
    private val binding: FragmentMyPigmentsBinding
        get() = _binding!!

    private val pigmentListAdapter: MyPigmentsListAdapter by lazy {
        MyPigmentsListAdapter(this, basePigments)
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMyPigmentsBinding.inflate(inflater, container, false)
        binding.pigmentRecyclerView.adapter = pigmentListAdapter
        pigmentListAdapter.setData(basePigments)
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() = MyPigmentsFragment()
    }
    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }

    override fun onItemClickListener(pigment: PigmentInfo) {
        activity?.supportFragmentManager?.beginTransaction()?.replace(
            R.id.fragment_container,
            PigmentCardFragment.newInstance(Bundle().apply
            { putParcelable(KEY_BUNDLE_CLAY, pigment) })
        )?.addToBackStack("")?.commit()    }
}