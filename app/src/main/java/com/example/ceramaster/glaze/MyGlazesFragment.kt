package com.example.ceramaster.glaze

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.ceramaster.KEY_BUNDLE_CLAY
import com.example.ceramaster.R
import com.example.ceramaster.clay.ClayCardFragment
import com.example.ceramaster.clay.ClayInfo
import com.example.ceramaster.clay.MyClaysFragment
import com.example.ceramaster.clay.MyClaysListViewModel
import com.example.ceramaster.databinding.FragmentMyGlazesBinding

class MyGlazesFragment: Fragment(), OnItemListClickListener, View.OnClickListener {
    interface Callbacks {
        fun onClaySelected(glaze: GlazeInfo)
    }
    private var _binding: FragmentMyGlazesBinding? = null
    private val binding: FragmentMyGlazesBinding
        get() = _binding!!

    private val glazeListAdapter: MyGlazesListAdapter by lazy {
        MyGlazesListAdapter(this)
    }

    private val myGlazesListViewModel: MyGlazesListViewModel by lazy {
        ViewModelProvider(this)[MyGlazesListViewModel::class.java]
    }

    private var callbacks: Callbacks? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMyGlazesBinding.inflate(inflater, container, false)
        binding.fabGlaze.setOnClickListener(this)
        getListGazes()
//        glazeListAdapter.setData(baseGlazes)
        return binding.root
    }

    private fun getListGazes() {
        binding.glazeRecyclerView.adapter = glazeListAdapter
    }

    companion object {
        @JvmStatic
        fun newInstance() = MyGlazesFragment()
    }
    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        callbacks = context as Callbacks?
    }

    override fun onItemClickListener(glaze: GlazeInfo) {
        callbacks?.onClaySelected(glaze)

    }

    override fun onClick(p0: View?) {
        activity?.supportFragmentManager?.beginTransaction()?.replace(
            R.id.fragment_container,
            GlazeCardFragment.newInstance()
        )?.addToBackStack("")?.commit()
    }
}