package com.example.tbviewp2.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tbviewp2.model.PlantModel

class MainViewModel : ViewModel() {
    val plant = MutableLiveData<PlantModel>()
}