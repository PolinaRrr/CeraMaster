package com.example.ceramaster.probe

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.ceramaster.KEY_BUNDLE_CLAY
import com.example.ceramaster.databinding.FragmentGlazeCardBinding
import com.example.ceramaster.databinding.FragmentProbeCardBinding
import com.example.ceramaster.glaze.GlazeCardFragment
import com.example.ceramaster.glaze.GlazeInfo

class ProbeCardFragment: Fragment(), View.OnClickListener {
    private var _binding: FragmentProbeCardBinding? = null
    private val binding: FragmentProbeCardBinding
        get() = _binding!!
    override fun onClick(p0: View?) {
        TODO("Not yet implemented")
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProbeCardBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val probe = arguments?.getSerializable(KEY_BUNDLE_CLAY) as ProbeInfo
        Log.d("@@@@@","clayInfo ${probe.nameClays} ${probe.firingTemperature} ${probe.nameGlazes} ${probe.comment}")
        renderClayInfo(probe)
    }

    private fun renderClayInfo(probe: ProbeInfo){
        binding.textNameProbeVal.setText(probe.nameClays)
        binding.textTempProbeVal.setText(probe.firingTemperature.toString())
        binding.textGlazeListVal.setText(probe.nameGlazes)
        binding.textCommentProbeVal.setText(probe.comment)
    }


    companion object {
        @JvmStatic
        fun newInstance(bundle: Bundle) = ProbeCardFragment().apply {
            arguments = bundle
        }
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}