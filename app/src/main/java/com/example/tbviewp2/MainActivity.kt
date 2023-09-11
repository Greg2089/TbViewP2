package com.example.tbviewp2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tbviewp2.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var listFragment =
        listOf(
            FragmentOne.newInstance(),
            FragmentTwo.newInstance(),
            FragmentThree.newInstance()
        )
    private val fragListTitles =
        listOf(
            "FragmentOne",
            "FragmentTwo",
            "FragmentThree"
        )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val adapter = ViewPagerAdapter(this, listFragment)
        binding.vp2.adapter = adapter
        TabLayoutMediator(binding.tabMain, binding.vp2) { tab, pos ->
            tab.text = fragListTitles[pos]
        }.attach()
    }
}