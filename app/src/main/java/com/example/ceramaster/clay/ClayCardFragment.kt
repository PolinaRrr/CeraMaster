package com.example.ceramaster.clay

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
import com.example.ceramaster.databinding.FragmentClayCardBinding
import com.example.ceramaster.KEY_BUNDLE_CLAY
import com.example.ceramaster.room.ClayTypeConverters
import com.example.ceramaster.room.ClayDto
import com.example.ceramaster.R
import com.example.ceramaster.validator.ClayCardFieldsData

// TODO:   разобраться с скоролом,  почему подтягивается менчю навигации,  изучить стандартную gboard, как изменить размер
// TODO: прогнать валиацию в карточке глин
// TODO:  продумать валидацию для остальных карточек
// TODO: перенести валидацию на все разделы

class ClayCardFragment : Fragment(), View.OnClickListener {
    private var _binding: FragmentClayCardBinding? = null
    private val binding: FragmentClayCardBinding
        get() = _binding!!

    private var clay: ClayInfo? = null


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentClayCardBinding.inflate(inflater, container, false)
        binding.buttonSave.setOnClickListener(this)


        return binding.root
    }

    private val clayCardViewModel: ClayCardViewModel by lazy {
        ViewModelProvider(this)[ClayCardViewModel::class.java]
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (arguments?.getSerializable(KEY_BUNDLE_CLAY) !== null) {
            clay = arguments?.getSerializable(KEY_BUNDLE_CLAY) as ClayInfo
        }

        val clayCardObserver = Observer<ClayDto?> { t ->
            renderClayInfo(ClayTypeConverters().fromClayDtoNullToClayInfo(t))
        }
        clayCardViewModel.clayLiveData.observe(viewLifecycleOwner, clayCardObserver)
        renderClayInfo(clay)
    }

    private fun renderClayInfo(clay: ClayInfo?) {
        if (clay !== null) {
            binding.clayId.setText(clay.id?.toString())
            binding.textName.setText(clay.nameClay)
            binding.textKtrVal.setText(clay.CTE.toString())
            binding.textTempVal.setText(clay.maxTemperature.toString())
            binding.textColorVal.setText(clay.colorClay)
            binding.textTotalKgVal.setText(clay.massStock.toString())
        }
    }

    override fun onClick(p0: View?) {
        processingFormValidation(
            validateFieldsForm(
                ClayCardFieldsData(
                    binding.clayId.text.toString(),
                    binding.textTempVal.text.toString().toIntOrNull(),
                    binding.textTotalKgVal.text.toString().toDoubleOrNull()
                )
            )
        )
    }

    private fun validateFieldsForm(fieldsValues: ClayCardFieldsData): Boolean {
        return clayCardViewModel.validate(fieldsValues)
    }

    private fun processingFormValidation(result: Boolean) {
        if (result) {
            saveNewCard()
        } else {
            Log.d("LOGCCFRAGMENT", "${print(clayCardViewModel.listError)}")
            for (i in clayCardViewModel.listError.indices) {
                clayCardViewModel.listError.forEach { field ->
                    if (field == "nameClay") {
                        highlightingRedInvalidFields(binding.textName)
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

    private fun saveNewCard() {
        clayCardViewModel.saveClayCard(
            ClayInfo(
                binding.clayId.text.toString().toIntOrNull(),
                binding.textName.text.toString(),
                binding.textKtrVal.text.toString().toDoubleOrNull(),
                binding.textTempVal.text.toString().toInt(),
                binding.textColorVal.text.toString(),
                binding.textTotalKgVal.text.toString().toDouble()
            )

        )
        Toast.makeText(activity, "Сохранено", Toast.LENGTH_SHORT).show()
        activity?.supportFragmentManager?.beginTransaction()?.replace(
            R.id.fragment_container,
            MyClaysFragment.newInstance()
        )?.commit()
    }


    companion object {
        @JvmStatic
        fun newInstance(clay: ClayInfo?): ClayCardFragment {
            val args = Bundle().apply {
                putSerializable(KEY_BUNDLE_CLAY, clay)
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


    private fun highlightingRedInvalidFields(editText: EditText) {
        editText.setBackgroundColor(resources.getColor(R.color.red))
    }



}