package com.example.ceramaster.glaze

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.ceramaster.KEY_BUNDLE_GLAZE
import com.example.ceramaster.R
import com.example.ceramaster.clay.ClayInfo
import com.example.ceramaster.clay.MyClaysFragment
import com.example.ceramaster.room.GlazeDto
import com.example.ceramaster.room.GlazeTypeConverters
import com.example.ceramaster.databinding.FragmentGlazeCardBinding
import com.example.ceramaster.validator.ClayCardFieldsData
import com.example.ceramaster.validator.GlazeCardFieldsData


class GlazeCardFragment : Fragment(), View.OnClickListener {
    private var _binding: FragmentGlazeCardBinding? = null
    private val binding: FragmentGlazeCardBinding
        get() = _binding!!

    private var glaze: GlazeInfo? = null

    private val glazeCardViewModel: GlazeCardViewModel by lazy {
        ViewModelProvider(this)[GlazeCardViewModel::class.java]
    }


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
        val glazeCardObserver = Observer<GlazeDto?> { t ->
            renderGlazeInfo(GlazeTypeConverters().fromGlazeDtoNullToGlazeInfo(t))
        }
        glazeCardViewModel.glazeLiveData.observe(viewLifecycleOwner, glazeCardObserver)
        renderGlazeInfo(glaze)
    }

    private fun renderGlazeInfo(glaze: GlazeInfo?) {
        if (glaze !== null) {
            binding.glazeId.setText(glaze.id?.toString())
            binding.textNameVal.setText(glaze.nameGlaze)
            binding.textKtrVal.setText(glaze.CTE.toString())
            binding.textTempVal.setText(glaze.maxTemperature.toString())
            binding.textEffectVal.setText(glaze.effectGlaze)
            binding.textColorVal.setText(glaze.colorGlaze)
            binding.textTotalKgVal.setText(glaze.massStock.toString())
        }
    }

    override fun onClick(p0: View?) {
        processingFormValidation(
            validateFieldsForm(
                GlazeCardFieldsData(
                    binding.textNameVal.text.toString(),
                    binding.textTempVal.text.toString().toIntOrNull(),
                    binding.textTotalKgVal.text.toString().toDoubleOrNull()
                )
            )
        )
    }

    private fun validateFieldsForm(fieldsValues: GlazeCardFieldsData): Boolean {
        return glazeCardViewModel.validate(fieldsValues)
    }

    private fun processingFormValidation(result: Boolean) {
        if (result) {
            saveNewCard()
        } else {
            Log.d("LOGCCFRAGMENT", "${print(glazeCardViewModel.listError)}")
            for (i in glazeCardViewModel.listError.indices) {
                glazeCardViewModel.listError.forEach { field ->
                    if (field == "nameGlaze") {
                        highlightingRedInvalidFields(binding.textNameVal)
                    }
                    if (field == "maxTemp") {
                        highlightingRedInvalidFields(binding.textTempVal)
                    }

                    if (field == "massStock") {
                        highlightingRedInvalidFields(binding.textTotalKgVal)
                    }
                }
            }
        }
    }

    private fun highlightingRedInvalidFields(editText: EditText) {
        editText.setBackgroundColor(resources.getColor(R.color.red))
    }

    private fun saveNewCard() {
        glazeCardViewModel.saveGlazeCard(
            GlazeInfo(
                binding.glazeId.text.toString().toIntOrNull(),
                binding.textNameVal.text.toString(),
                binding.textKtrVal.text.toString().toDoubleOrNull(),
                binding.textTempVal.text.toString().toInt(),
                binding.textEffectVal.text.toString(),
                binding.textColorVal.text.toString(),
                binding.textTotalKgVal.text.toString().toDouble()
            )
        )
        Toast.makeText(activity, "Сохранено", Toast.LENGTH_SHORT).show()
        activity?.supportFragmentManager?.beginTransaction()?.replace(
            R.id.fragment_container,
            MyGlazesFragment.newInstance()
        )?.commit()
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