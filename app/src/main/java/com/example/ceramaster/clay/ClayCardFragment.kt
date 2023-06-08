package com.example.ceramaster.clay

import android.os.Bundle
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


class ClayCardFragment : Fragment(), View.OnClickListener {
    private var _binding: FragmentClayCardBinding? = null
    private val binding: FragmentClayCardBinding
        get() = _binding!!

    private var clay: ClayInfo? = null

    private var requiredFieldsClayCard: List<EditText> = listOf()
    private var minLengthFieldClayCard: Map<EditText, Int> = mapOf()
    private var maxLengthFieldClayCard: Map<EditText, Int> = mapOf()


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
        //fillLists()
        if(arguments?.getSerializable(KEY_BUNDLE_CLAY) !== null){
            clay = arguments?.getSerializable(KEY_BUNDLE_CLAY) as ClayInfo
        }

        val clayCardObserver = Observer<ClayDto?> { t ->
            renderClayInfo(ClayTypeConverters().fromClayDtoNullToClayInfo(t))
        }
        clayCardViewModel.clayLiveData.observe(viewLifecycleOwner, clayCardObserver)

        renderClayInfo(clay)
    }

    private fun renderClayInfo(clay: ClayInfo?) {
        if(clay !== null){
            binding.clayId.setText(clay.id?.toString())
            binding.textName.setText(clay.nameClay)
            binding.textKtrVal.setText(clay.CTE.toString())
            binding.textTempVal.setText(clay.maxTemperature.toString())
            binding.textColorVal.setText(clay.colorClay)
            binding.textTotalKgVal.setText(clay.massStock.toString())
        }
    }

    override fun onClick(p0: View?) {
        if (checkValidFields()) {
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
            Toast.makeText(activity, "Сохранено", Toast.LENGTH_SHORT).show()
            activity?.supportFragmentManager?.beginTransaction()?.replace(
                R.id.fragment_container,
                MyClaysFragment.newInstance()
            )?.addToBackStack("")?.commit()

        } else {
            processingValidFields()
        }
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

    private fun checkValidFieldsClayCard(editText: EditText): Boolean {
        val intMin = minLengthFieldClayCard[editText]
        val intMax = maxLengthFieldClayCard[editText]
        return CheckFieldLength(intMin!!, intMax!!).validate(editText.toString())
    }

    private fun checkValidFields(): Boolean {
        return (checkValidFieldsClayCard(binding.textName)
                && checkValidFieldsClayCard(binding.textTempVal)
                && checkValidFieldsClayCard(binding.textTotalKgVal))
    }

    private fun selectInvalidFields(editText: EditText) {
        editText.setBackgroundColor(resources.getColor(R.color.red))
    }

    private fun processingValidFields() {
        for (i in 1..requiredFieldsClayCard.size) {
            if (!checkValidFieldsClayCard(requiredFieldsClayCard[i])) {
                selectInvalidFields(requiredFieldsClayCard[i])
            }
        }
    }

    private fun fillLists() {
        requiredFieldsClayCard = listOf(
            binding.textName,
            binding.textTempVal,
            binding.textTempVal
        )
        minLengthFieldClayCard = mapOf(
            binding.textName to 3,
            binding.textTempVal to 3,
            binding.textTempVal to 1
        )
        maxLengthFieldClayCard = mapOf(
            binding.textName to 45,
            binding.textTempVal to 4,
            binding.textTempVal to 4
        )
    }
}