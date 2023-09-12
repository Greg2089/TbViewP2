package com.example.tbviewp2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.tbviewp2.databinding.FragmentMainBinding
import com.example.tbviewp2.model.PlantModel
import com.example.tbviewp2.viewModel.MainViewModel

class MainFragment : Fragment() {
    private val model: MainViewModel by activityViewModels()
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.button.setOnClickListener {
            model.plant.value = PlantModel(R.drawable.kalendula, "Календула", "Цветок")
            (activity as AppCompatActivity).supportFragmentManager.beginTransaction()
                .replace(R.id.holder, ContentFragment()).commit()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}