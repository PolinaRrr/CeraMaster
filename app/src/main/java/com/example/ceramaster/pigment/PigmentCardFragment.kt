package com.example.ceramaster.pigment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.ceramaster.KEY_BUNDLE_CLAY
import com.example.ceramaster.databinding.FragmentGlazeCardBinding
import com.example.ceramaster.databinding.FragmentPigmentCardBinding
import com.example.ceramaster.glaze.GlazeCardFragment
import com.example.ceramaster.glaze.GlazeInfo

class PigmentCardFragment: Fragment(), View.OnClickListener {
    private var _binding: FragmentPigmentCardBinding? = null
    private val binding: FragmentPigmentCardBinding
        get() = _binding!!
    override fun onClick(p0: View?) {
        TODO("Not yet implemented")
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPigmentCardBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val pigment = arguments?.getSerializable(KEY_BUNDLE_CLAY) as PigmentInfo
        Log.d("@@@@@","clayInfo ${pigment.namePigment} ${pigment.maxTemperature} " +
                pigment.colorPigment
        )
        renderClayInfo(pigment)
    }

    private fun renderClayInfo(pigment: PigmentInfo){
        binding.textNameVal.setText(pigment.namePigment)
        binding.textTempVal.setText(pigment.maxTemperature.toString())
        binding.textColorVal.setText(pigment.colorPigment)
        binding.textTotalGVal.setText(pigment.massStock.toString())
    }

    companion object {
        @JvmStatic
        fun newInstance(bundle: Bundle) = PigmentCardFragment().apply {
            arguments = bundle
        }
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}