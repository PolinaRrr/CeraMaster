package com.example.ceramaster

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.ceramaster.databinding.FragmentMaterialsBinding

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
        return binding.root
    }

    override fun onClick(v: View?) {
        TODO("Not yet implemented")
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