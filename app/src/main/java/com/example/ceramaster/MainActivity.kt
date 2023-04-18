package com.example.ceramaster

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ceramaster.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
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
}