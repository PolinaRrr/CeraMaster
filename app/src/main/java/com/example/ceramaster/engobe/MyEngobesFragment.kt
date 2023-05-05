package com.example.ceramaster.engobe

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.ceramaster.KEY_BUNDLE_CLAY
import com.example.ceramaster.R
import com.example.ceramaster.clay.ClayCardFragment
import com.example.ceramaster.clay.ClayInfo
import com.example.ceramaster.databinding.FragmentMyEngobesBinding

class MyEngobesFragment : Fragment(), OnItemListClickListener {
    private var _binding: FragmentMyEngobesBinding? = null
    private val binding: FragmentMyEngobesBinding
        get() = _binding!!

    private val engobeListAdapter: MyEngobesListAdapter by lazy {
        MyEngobesListAdapter(this, baseEngobes)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMyEngobesBinding.inflate(inflater, container, false)
        getListEngobes(baseEngobes)
        return binding.root
    }
    private fun getListEngobes(baseEngobes: List<EngobeInfo>) {
        binding.engobeRecyclerView.adapter = engobeListAdapter
        engobeListAdapter.setData(com.example.ceramaster.engobe.baseEngobes)
    }

    companion object {
        @JvmStatic
        fun newInstance() = MyEngobesFragment()
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }

    override fun onItemClickListener(engobe: EngobeInfo) {
        activity?.supportFragmentManager?.beginTransaction()?.replace(
            R.id.fragment_container,
            EngobeCardFragment.newInstance(Bundle().apply
            { putParcelable(KEY_BUNDLE_CLAY, engobe) })
        )?.addToBackStack("")?.commit()
    }
}