package com.example.bitfit

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.bitfit.data.FoodEntity
import kotlinx.coroutines.launch

class FoodViewModel(application: Application) : AndroidViewModel(application) {
    private val dao = FoodDatabase.get(application).foodDao()
    val foods = dao.getAll()

    fun morefood(name: String, calories: Int) {
        viewModelScope.launch {
            dao.insert(FoodEntity(name = name, calories = calories))
        }
    }
    fun deleteFood(food: FoodEntity) {
         viewModelScope.launch {
            dao.deleteById(food.id)
            }
        }

    }