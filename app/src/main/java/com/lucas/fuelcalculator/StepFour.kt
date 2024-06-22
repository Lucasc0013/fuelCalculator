package com.lucas.fuelcalculator

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.lucas.fuelcalculator.databinding.ActivityStepFourBinding

class StepFour : AppCompatActivity() {
    private lateinit var binding: ActivityStepFourBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStepFourBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fuelPrice = intent.getFloatExtra("fuelprice", 0.0f)
        val distancia = intent.getIntExtra("distancia", 0)
        val consumo = intent.getFloatExtra("consumo", 0.0f)
        val total = intent.getFloatExtra("total", 0.0f)

        binding.tvResult.text = total.toString() + "$"
        binding.tvConsumo.text = consumo.toString()
        binding.tvDistance.text = distancia.toString()
        binding.tvFuelPrice.text = fuelPrice.toString()

        binding.mbRestart.setOnClickListener{
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
    }
}