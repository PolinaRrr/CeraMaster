package com.example.ceramaster.supplement

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.ceramaster.KEY_BUNDLE_CLAY
import com.example.ceramaster.databinding.FragmentGlazeCardBinding
import com.example.ceramaster.databinding.FragmentSupplementCardBinding
import com.example.ceramaster.glaze.GlazeCardFragment
import com.example.ceramaster.glaze.GlazeInfo

class SupplementCardFragment: Fragment(), View.OnClickListener {
    private var _binding: FragmentSupplementCardBinding? = null
    private val binding: FragmentSupplementCardBinding
        get() = _binding!!
    override fun onClick(p0: View?) {
        TODO("Not yet implemented")
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSupplementCardBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val supplement = arguments?.getSerializable(KEY_BUNDLE_CLAY) as SupplementInfo
        Log.d("@@@@@","clayInfo ${supplement.nameSupplement} ${supplement.effectSupplement} ${supplement.massStock} ")
        renderClayInfo(supplement)
    }

    private fun renderClayInfo(supplement: SupplementInfo){
        binding.textNameSupplementVal.setText(supplement.nameSupplement)
        binding.textPurposeSupplementVal.setText(supplement.effectSupplement)
        binding.textTotalGSupplementVal.setText(supplement.massStock.toString())
    }


    companion object {
        @JvmStatic
        fun newInstance(bundle: Bundle) = SupplementCardFragment().apply {
            arguments = bundle
        }
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}