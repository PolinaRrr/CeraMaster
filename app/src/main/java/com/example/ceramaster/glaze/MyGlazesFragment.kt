package com.example.ceramaster.glaze

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.ceramaster.KEY_BUNDLE_CLAY
import com.example.ceramaster.R
import com.example.ceramaster.clay.ClayCardFragment
import com.example.ceramaster.databinding.FragmentMyGlazesBinding

class MyGlazesFragment: Fragment(), OnItemListClickListener {
    private var _binding: FragmentMyGlazesBinding? = null
    private val binding: FragmentMyGlazesBinding
        get() = _binding!!

    private val glazeListAdapter: MyGlazesListAdapter by lazy {
        MyGlazesListAdapter(this)
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
        activity?.supportFragmentManager?.beginTransaction()?.replace(
            R.id.fragment_container,
            GlazeCardFragment.newInstance(Bundle().apply
            { putParcelable(KEY_BUNDLE_CLAY, glaze) })
        )?.addToBackStack("")?.commit()

    }
}