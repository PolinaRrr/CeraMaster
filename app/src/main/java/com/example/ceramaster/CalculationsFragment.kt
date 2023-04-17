package com.example.ceramaster

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.ceramaster.databinding.FragmentCalculationsBinding

class CalculationsFragment : Fragment(), View.OnClickListener {
    private var _binding: FragmentCalculationsBinding? = null
    private val binding: FragmentCalculationsBinding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCalculationsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onClick(v: View?) {
        TODO("Not yet implemented")
    }
    companion object {
        @JvmStatic
        fun newInstance() = CalculationsFragment()
    }
    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }

}