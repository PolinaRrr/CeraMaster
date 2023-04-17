package com.example.ceramaster

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.ceramaster.databinding.FragmentSettingsBinding

class SettingsFragment: Fragment(), View.OnClickListener {
    private var _binding: FragmentSettingsBinding? = null
    private val binding: FragmentSettingsBinding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSettingsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onClick(v: View?) {
        TODO("Not yet implemented")
    }
    companion object {
        @JvmStatic
        fun newInstance() = SettingsFragment()
    }
    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }

}