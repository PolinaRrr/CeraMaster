package com.example.ceramaster.clay

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.ceramaster.databinding.FragmentClayCardBinding
import com.example.ceramaster.KEY_BUNDLE_CLAY
import com.example.ceramaster.room.ClayTypeConverters
import com.example.ceramaster.room.ClayDto


class ClayCardFragment : Fragment(), View.OnClickListener {
    private var _binding: FragmentClayCardBinding? = null
    private val binding: FragmentClayCardBinding
        get() = _binding!!

    private val clayCardViewModel: ClayCardViewModel by lazy {
        ViewModelProvider(this)[ClayCardViewModel::class.java]
    }
    private lateinit var clay: ClayInfo

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentClayCardBinding.inflate(inflater, container, false)
        binding.buttonSave.setOnClickListener(this)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        clayCardViewModel.clayLiveData.observe(
            viewLifecycleOwner
        ) { t -> renderClayInfo(ClayTypeConverters().fromClayDtoNullToClayInfo(t)) }
    }


    private fun renderClayInfo(clay: ClayInfo) {
        binding.clayId.setText(clay.id?.toString())
        binding.textName.setText(clay.nameClay)
        binding.textKtrVal.setText(clay.CTE.toString())
        binding.textTempVal.setText(clay.maxTemperature.toString())
        binding.textColorVal.setText(clay.colorClay)
        binding.textTotalKgVal.setText(clay.massStock.toString())
    }

    override fun onClick(p0: View?) {
        clayCardViewModel.saveClayCard(

            ClayInfo(
                binding.clayId.text.toString().toIntOrNull(),
                binding.textName.text.toString(),
                binding.textKtrVal.text.toString().toDouble(),
                binding.textTempVal.text.toString().toInt(),
                binding.textColorVal.text.toString(),
                binding.textTotalKgVal.text.toString().toDouble()
            )
        )
    }

    companion object {
        @JvmStatic
        fun newInstance(clayId: Int?): ClayCardFragment {
            val args = Bundle().apply {
                putSerializable(KEY_BUNDLE_CLAY, clayId)
            }
            return ClayCardFragment().apply {
                arguments = args
            }
        }

        fun newInstance() = ClayCardFragment()
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }

}