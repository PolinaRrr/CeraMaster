package com.example.ceramaster.clay

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.ceramaster.databinding.FragmentClayCardBinding
import com.example.ceramaster.KEY_BUNDLE_CLAY


class ClayCardFragment : Fragment(), View.OnClickListener {
    private var _binding: FragmentClayCardBinding? = null
    private val binding: FragmentClayCardBinding
        get() = _binding!!

    //    private val clayCardViewModel: ClayCardViewModel by lazy {
//        ViewModelProvider(this)[ClayCardViewModel::class.java]
//    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentClayCardBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val clay = arguments?.getSerializable(KEY_BUNDLE_CLAY) as ClayInfo
        Log.d("@@@@@","clayInfo ${clay.nameClay} ${clay.CTE} ${clay.colorClay} ${clay.maxTemperature}")
        renderClayInfo(clay)
    }

     private fun renderClayInfo(clay:ClayInfo){
         binding.textName.setText(clay.nameClay)
         binding.textKtrVal.setText(clay.CTE.toString())
         binding.textTempVal.setText(clay.maxTemperature.toString())
         binding.textColorVal.setText(clay.colorClay)
         binding.textTotalKgVal.setText(clay.massStock.toString())
     }

    override fun onClick(p0: View?) {
        TODO("Not yet implemented")
    }

    companion object {
        @JvmStatic
        fun newInstance(bundle: Bundle) = ClayCardFragment().apply {
            arguments = bundle
        }
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}