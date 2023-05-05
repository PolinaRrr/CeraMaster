package com.example.ceramaster.engobe

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.ceramaster.KEY_BUNDLE_CLAY
import com.example.ceramaster.clay.ClayCardFragment
import com.example.ceramaster.clay.ClayInfo
import com.example.ceramaster.databinding.FragmentClayCardBinding
import com.example.ceramaster.databinding.FragmentEngobeCardBinding

class EngobeCardFragment: Fragment(), View.OnClickListener {
    private var _binding: FragmentEngobeCardBinding? = null
    private val binding: FragmentEngobeCardBinding
        get() = _binding!!
    override fun onClick(p0: View?) {
        TODO("Not yet implemented")
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEngobeCardBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val engobe = arguments?.getSerializable(KEY_BUNDLE_CLAY) as EngobeInfo
        renderEngobeInfo(engobe)
    }
    private fun renderEngobeInfo(engobe:EngobeInfo){
        binding.engobeNameVal.setText(engobe.nameEngobe)
        binding.engobeTempVal.setText(engobe.maxTemperature.toString())
        binding.engobeColorVal.setText(engobe.colorEngobe)
        binding.engobeTotalKgVal.setText(engobe.massStock.toString())

    }
    companion object {
        @JvmStatic
        fun newInstance(bundle: Bundle) = EngobeCardFragment().apply {
            arguments = bundle
        }
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}