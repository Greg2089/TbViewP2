package com.example.tbviewp2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.tbviewp2.databinding.ContentFragmentBinding
import com.example.tbviewp2.databinding.FragmentInfoBinding
import com.example.tbviewp2.viewModel.MainViewModel

class InfoFragment : Fragment() {
    private val model: MainViewModel by activityViewModels()
    private var _binding: FragmentInfoBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentInfoBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        model.plant.observe(viewLifecycleOwner) {
            binding.tvInfo.text = it.info
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
