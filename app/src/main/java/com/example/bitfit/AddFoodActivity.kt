package com.example.bitfit.ui

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.bitfit.FoodViewModel
import com.example.bitfit.databinding.MorefoodBinding

class AddFoodActivity : AppCompatActivity() {
    private lateinit var binding: MorefoodBinding
    private val vm: FoodViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MorefoodBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSave.setOnClickListener {
            val name = binding.etFood.text?.toString().orEmpty()
            val calText = binding.etCalories.text?.toString().orEmpty()
            val calories = calText.toIntOrNull()

            if (name.isBlank() || calories == null) {
                Toast.makeText(this, "Enter a name and number of calories", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            vm.morefood(name, calories)
            finish() // MainActivity's observer will refresh the list
        }
    }
}
