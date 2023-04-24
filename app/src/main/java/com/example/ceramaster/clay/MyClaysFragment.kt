package com.example.ceramaster.clay

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.ceramaster.R
import com.example.ceramaster.databinding.FragmentMyClaysBinding
import com.example.ceramaster.KEY_BUNDLE_CLAY

class MyClaysFragment : Fragment(), OnItemListClickListener {
    private var _binding: FragmentMyClaysBinding? = null
    private val binding: FragmentMyClaysBinding
        get() = _binding!!

    private val clayListAdapter: MyClaysListAdapter by lazy {
        MyClaysListAdapter(this, baseClays)
    }

    private val myClaysListViewModel: MyClaysListViewModel by lazy {
        ViewModelProvider(this)[MyClaysListViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMyClaysBinding.inflate(inflater, container, false)
        getListClay(baseClays)
        return binding.root
    }

    private fun getListClay(baseClays: List<ClayInfo>) {
        clayListAdapter.setData(baseClays)
        binding.recyclerView2.adapter = clayListAdapter
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
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
        Log.d("@@@@", clay.nameClay)

        activity?.supportFragmentManager?.beginTransaction()?.replace(
            R.id.fragment_container,
            ClayCardFragment.newInstance(Bundle().apply
            { putParcelable(KEY_BUNDLE_CLAY, clay) })
        )?.addToBackStack("")?.commit()

    }
}