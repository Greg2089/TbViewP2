package com.example.tbviewp2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.tbviewp2.databinding.ContentFragmentBinding
import com.example.tbviewp2.viewModel.MainViewModel
import com.google.android.material.tabs.TabLayoutMediator


class ContentFragment : Fragment() {
    private val model: MainViewModel by activityViewModels()
    private var _binding: ContentFragmentBinding? = null
    private val binding get() = _binding!!

    private var listFragment =
        listOf(
            InfoFragment(),
            UseFragment.newInstance()
        )
    private val fragListTitles =
        listOf(
            "Описание",
            "Применение"
        )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = ContentFragmentBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        model.plant.observe(viewLifecycleOwner) {
            binding.imageContent.setImageResource(it.imageId)
        }
        val adapter = ViewPagerAdapter(activity as AppCompatActivity, listFragment)
        binding.vp2.adapter = adapter
        TabLayoutMediator(binding.tabMain, binding.vp2) { tab, pos ->
            tab.text = fragListTitles[pos]
        }.attach()
    }

    companion object {

        @JvmStatic
        fun newInstance() = ContentFragment()
    }
}
