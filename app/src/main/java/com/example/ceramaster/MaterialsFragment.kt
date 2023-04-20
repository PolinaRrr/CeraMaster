package com.example.ceramaster

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.ceramaster.clay.MyClaysFragment
import com.example.ceramaster.databinding.FragmentMaterialsBinding
import com.example.ceramaster.glaze.MyGlazesFragment
import com.example.ceramaster.engobe.MyEngobesFragment
import com.example.ceramaster.pigment.MyPigmentsFragment
import com.example.ceramaster.supplement.MySupplementsFragment
import com.example.ceramaster.probe.MyProbesFragment


class MaterialsFragment : Fragment(), View.OnClickListener {
    private var _binding: FragmentMaterialsBinding? = null
    private val binding: FragmentMaterialsBinding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMaterialsBinding.inflate(inflater, container, false)
        binding.myClay.setOnClickListener(this)
        binding.myGlaze.setOnClickListener(this)
        binding.myEngobe.setOnClickListener(this)
        binding.myPigments.setOnClickListener(this)
        binding.mySupplements.setOnClickListener(this)
        binding.myProbes.setOnClickListener(this)
        return binding.root
    }


    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.my_clay -> {
                activity?.supportFragmentManager?.beginTransaction()?.replace(
                    R.id.fragment_container,
                    MyClaysFragment.newInstance()
                )?.addToBackStack("")?.commit()
            }
            R.id.my_glaze -> {
                activity?.supportFragmentManager?.beginTransaction()?.replace(
                    R.id.fragment_container,
                    MyGlazesFragment.newInstance()
                )?.addToBackStack("")?.commit()
            }
            R.id.my_engobe -> {
                activity?.supportFragmentManager?.beginTransaction()?.replace(
                    R.id.fragment_container,
                    MyEngobesFragment.newInstance()
                )?.addToBackStack("")?.commit()
            }
            R.id.my_pigments -> {
                activity?.supportFragmentManager?.beginTransaction()?.replace(
                    R.id.fragment_container,
                    MyPigmentsFragment.newInstance()
                )?.addToBackStack("")?.commit()
            }
            R.id.my_supplements -> {
                activity?.supportFragmentManager?.beginTransaction()?.replace(
                    R.id.fragment_container,
                    MySupplementsFragment.newInstance()
                )?.addToBackStack("")?.commit()
            }
            R.id.my_probes -> {
                activity?.supportFragmentManager?.beginTransaction()?.replace(
                    R.id.fragment_container,
                    MyProbesFragment.newInstance()
                )?.addToBackStack("")?.commit()
            }

        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = MaterialsFragment()
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }

}