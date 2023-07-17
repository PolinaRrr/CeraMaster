package com.example.ceramaster.clay

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import com.example.ceramaster.validator.CheckFieldLength
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.ceramaster.databinding.FragmentClayCardBinding
import com.example.ceramaster.KEY_BUNDLE_CLAY
import com.example.ceramaster.room.ClayTypeConverters
import com.example.ceramaster.room.ClayDto
import com.example.ceramaster.R
import com.example.ceramaster.validator.ClayCardFieldsData
import kotlin.math.log


class ClayCardFragment : Fragment(), View.OnClickListener {
    private var _binding: FragmentClayCardBinding? = null
    private val binding: FragmentClayCardBinding
        get() = _binding!!

    private var clay: ClayInfo? = null

//    private var requiredFieldsClayCard: List<EditText> = listOf()
//    private var minLengthFieldClayCard: Map<EditText, Int> = mapOf()
//    private var maxLengthFieldClayCard: Map<EditText, Int> = mapOf()
//    private var minValueFieldClayCard: Map<EditText, Int> = mapOf()
//    private var maxValueFieldClayCard: Map<EditText, Int> = mapOf()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentClayCardBinding.inflate(inflater, container, false)
        binding.buttonSave.setOnClickListener(this)
        //   fillLists()

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
// а вообще происходит привязка
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

    //вот и хз как быть если стринг нул?!

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
           Log.d("LOGCCFRAGMENT","${print(clayCardViewModel.listError)}")
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

//    private fun checkValidFieldsClayCard(editText: EditText): Boolean {
//        val intMin = minLengthFieldClayCard[editText]
//        val intMax = maxLengthFieldClayCard[editText]
//        Log.d(
//            "$$$$$$",
//            CheckFieldLength(intMin!!, intMax!!).validate(editText.toString())
//                .toString() + " min $intMin max $intMax for ${editText.text} $editText "
//        )
//        return CheckFieldLength(intMin, intMax).validate(editText.text.toString())
//    }

//    private fun checkValidFields(): Boolean {
//        return (checkValidFieldsClayCard(binding.textName)
//                && checkValidFieldsClayCard(binding.textTempVal)
//                && checkValidFieldsClayCard(binding.textTotalKgVal))
//    }

    private fun highlightingRedInvalidFields(editText: EditText) {
        editText.setBackgroundColor(resources.getColor(R.color.red))
    }

    private fun highlightingValidFields(editText: EditText) {
        editText.setBackgroundColor(resources.getColor(R.color.white))
    }

//    private fun processingValidFields() {
//        for (i in requiredFieldsClayCard.indices) {
//            if (checkValidFieldsClayCard(requiredFieldsClayCard[i])) {
//                highlightingValidFields(requiredFieldsClayCard[i])
//            } else {
//                highlightingRedInvalidFields(requiredFieldsClayCard[i])
//            }
//        }
//    }

    //вообще надо бы нормальные диапозоны значений задать
//    private fun fillLists() {
//        requiredFieldsClayCard = listOf(
//            binding.textName,
//            binding.textTempVal,
//            binding.textTotalKgVal
//        )
//        minLengthFieldClayCard = mapOf(
//            binding.textName to 3,
//            binding.textTempVal to 3,
//            binding.textTotalKgVal to 1
//        )
//        maxLengthFieldClayCard = mapOf(
//            binding.textName to 45,
//            binding.textTempVal to 4,
//            binding.textTotalKgVal to 4
//        )
//        minValueFieldClayCard = mapOf(
//            binding.textTempVal to 650
//        )
//
//        maxValueFieldClayCard = mapOf(
//            binding.textTempVal to 1350
//        )
//    }

}