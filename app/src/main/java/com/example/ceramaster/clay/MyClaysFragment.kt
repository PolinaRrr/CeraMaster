package com.example.ceramaster.clay

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.example.ceramaster.room.ClayTypeConverters
import com.example.ceramaster.room.ClayDto
import androidx.lifecycle.ViewModelProvider
import com.example.ceramaster.R
import com.example.ceramaster.databinding.FragmentMyClaysBinding
import com.example.ceramaster.KEY_BUNDLE_CLAY
import java.util.*



class MyClaysFragment : Fragment(), OnItemListClickListener, View.OnClickListener {
    interface Callbacks {
        fun onClaySelected(clay: ClayInfo)
    }

    private var _binding: FragmentMyClaysBinding? = null
    private val binding: FragmentMyClaysBinding
        get() = _binding!!

    private val clayListAdapter: MyClaysListAdapter by lazy {
        MyClaysListAdapter(this)
    }

    private val myClaysListViewModel: MyClaysListViewModel by lazy {
        ViewModelProvider(this)[MyClaysListViewModel::class.java]
    }

    private var callbacks: Callbacks? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMyClaysBinding.inflate(inflater, container, false)
        binding.fabClays.setOnClickListener(this)
        getListClay()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val clayObserver = Observer<List<ClayDto>>{data ->
            clayListAdapter.setData(ClayTypeConverters().listClayDtoToClayInfo(data))
        }
        myClaysListViewModel.claysLiveData.observe(
            viewLifecycleOwner, clayObserver
        )
    }

    private fun getListClay() {
        binding.recyclerClays.adapter = clayListAdapter
    }

    companion object {
        @JvmStatic
        fun newInstance() = MyClaysFragment()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        callbacks = context as Callbacks?
    }

    override fun onDetach() {
        super.onDetach()
        callbacks = null
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }

    override fun onItemClickListener(clay: ClayInfo) {
        Log.d("@@@@", clay.nameClay)
        callbacks?.onClaySelected(clay)

    }

    override fun onClick(p0: View?) {
        activity?.supportFragmentManager?.beginTransaction()?.replace(
            R.id.fragment_container,
            ClayCardFragment.newInstance()
        )?.addToBackStack("")?.commit()
    }


}


