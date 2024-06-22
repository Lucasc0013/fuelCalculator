package com.lucas.fuelcalculator

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.lucas.fuelcalculator.databinding.ActivityStepThreeBinding

class StepThree : AppCompatActivity() {
    private lateinit var binding: ActivityStepThreeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStepThreeBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.bmbNext2.setOnClickListener {
            val consumoTmp = binding.tieConsumoCar.text

            if (consumoTmp?.isEmpty() == true) {
                Snackbar.make(binding.tieConsumoCar, "preencha o campo ", Snackbar.LENGTH_LONG)
                    .show()
            } else {

                val fuelPrice = intent.getFloatExtra("fuelprice", 0.0f)
                val distancia = intent.getIntExtra("distancia", 0)

                val consumo: Float = consumoTmp.toString().toFloat()
                val media = fuelPrice * distancia
                val total = media / consumo

                intent = Intent(this,StepFour::class.java)
                intent.apply {
                    putExtra("fuelprice", fuelPrice)
                    putExtra("distancia",distancia)
                    putExtra("consumo",consumo)
                    putExtra("total",total)

                }
                startActivity(intent)


            }
        }
        binding.bmbBackTwo.setOnClickListener {
            intent = Intent(this,StepTwo::class.java)
            startActivity(intent)
        }


    }
}