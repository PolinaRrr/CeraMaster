package com.example.ceramaster

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ceramaster.clay.ClayCardFragment
import com.example.ceramaster.clay.ClayInfo
import com.example.ceramaster.databinding.ActivityMainBinding
import com.example.ceramaster.clay.MyClaysFragment

class MainActivity : AppCompatActivity(),MyClaysFragment.Callbacks {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction().replace(
                R.id.fragment_container,
                MaterialsFragment.newInstance()
            ).commit()
        }
        binding.bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.item_materials -> {
                    supportFragmentManager.beginTransaction().replace(
                        R.id.fragment_container,
                        MaterialsFragment.newInstance()
                    ).addToBackStack("").commit()
                }
                R.id.item_calculations -> {
                    supportFragmentManager.beginTransaction().replace(
                        R.id.fragment_container,
                        CalculationsFragment.newInstance()
                    ).addToBackStack("").commit()
                }
                R.id.item_plans -> {
                    supportFragmentManager.beginTransaction().replace(
                        R.id.fragment_container,
                        PlansFragment.newInstance()
                    ).addToBackStack("").commit()
                }
                R.id.item_settings -> {
                    supportFragmentManager.beginTransaction().replace(
                        R.id.fragment_container,
                        SettingsFragment.newInstance()
                    ).addToBackStack("").commit()
                }
            }
            true
        }
    }

    override fun onClaySelected(clay: ClayInfo) {
        supportFragmentManager.beginTransaction().replace(
            R.id.fragment_container,
            ClayCardFragment.newInstance(clay))
            .addToBackStack("")
            .commit()
    }

}