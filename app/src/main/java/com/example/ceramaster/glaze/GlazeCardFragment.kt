package com.example.ceramaster.glaze

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
import com.example.ceramaster.databinding.FragmentGlazeCardBinding

class GlazeCardFragment: Fragment(), View.OnClickListener {
    private var _binding: FragmentGlazeCardBinding? = null
    private val binding: FragmentGlazeCardBinding
        get() = _binding!!

    override fun onClick(p0: View?) {
        TODO("Not yet implemented")
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGlazeCardBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val glaze = arguments?.getSerializable(KEY_BUNDLE_CLAY) as  GlazeInfo
        Log.d("@@@@@","clayInfo ${glaze.nameGlaze} ${glaze.CTE} ${glaze.effectGlaze} ${glaze.maxTemperature}")
        renderClayInfo(glaze)
    }

    private fun renderClayInfo(glaze: GlazeInfo){
        binding.textNameVal.setText(glaze.nameGlaze)
        binding.textKtrVal.setText(glaze.CTE.toString())
        binding.textTempVal.setText(glaze.maxTemperature.toString())
        binding.textEffectVal.setText(glaze.effectGlaze)
        binding.textTotalKgVal.setText(glaze.massStock.toString())
    }


    companion object {
        @JvmStatic
        fun newInstance(bundle: Bundle) = GlazeCardFragment().apply {
            arguments = bundle
        }
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}