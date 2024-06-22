package com.lucas.fuelcalculator

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.lucas.fuelcalculator.databinding.ActivityStepTwoBinding

class StepTwo : AppCompatActivity() {
    private lateinit var binding: ActivityStepTwoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStepTwoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bmbNext1.setOnClickListener {
            val distanciaTemp = binding.tieDistancia.text

            if (distanciaTemp?.isEmpty() == true) {
                Snackbar.make(binding.tieDistancia, "Preencha os campos", Snackbar.LENGTH_LONG)
                    .show()
            } else {
                val fuelPrice = intent.getFloatExtra("fuelprice", 0.0f)

                val distancia: Int = distanciaTemp.toString().toInt()

                val intent = Intent(this,StepThree::class.java)
                intent.apply {
                    putExtra("distancia",distancia)
                    putExtra("fuelprice",fuelPrice)

                }
                startActivity(intent)



            }
        }

        binding.bmbBackOne.setOnClickListener {
            intent = Intent(this,StepOne::class.java)
            startActivity(intent)
        }

    }
}