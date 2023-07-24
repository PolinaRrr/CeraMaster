package com.example.ceramaster.glaze

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.ceramaster.KEY_BUNDLE_GLAZE
import com.example.ceramaster.clay.ClayCardFragment
import com.example.ceramaster.clay.ClayInfo
import com.example.ceramaster.databinding.FragmentGlazeCardBinding

class GlazeCardFragment : Fragment(), View.OnClickListener {
    private var _binding: FragmentGlazeCardBinding? = null
    private val binding: FragmentGlazeCardBinding
        get() = _binding!!

    private var glaze: GlazeInfo? = null


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGlazeCardBinding.inflate(inflater, container, false)
        binding.buttonSave.setOnClickListener(this)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (arguments?.getSerializable(KEY_BUNDLE_GLAZE) !== null) {
            glaze = arguments?.getSerializable(KEY_BUNDLE_GLAZE) as GlazeInfo
        }

        renderGlazeInfo(glaze)
    }

    private fun renderGlazeInfo(glaze: GlazeInfo?) {
        binding.textNameVal.setText(glaze?.nameGlaze)
        binding.textKtrVal.setText(glaze?.CTE.toString())
        binding.textTempVal.setText(glaze?.maxTemperature.toString())
        binding.textEffectVal.setText(glaze?.effectGlaze)
        binding.textTotalKgVal.setText(glaze?.massStock.toString())
    }

    override fun onClick(p0: View?) {
        TODO("Not yet implemented")
    }

    companion object {
        @JvmStatic
        fun newInstance(glaze: GlazeInfo): GlazeCardFragment {
            val args = Bundle().apply {
                putSerializable(KEY_BUNDLE_GLAZE, glaze)
            }
            return GlazeCardFragment().apply {
                arguments = args
            }
        }

        fun newInstance() = GlazeCardFragment()
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}