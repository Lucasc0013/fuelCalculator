package com.lucas.fuelcalculator

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.lucas.fuelcalculator.databinding.ActivityStepOneBinding

class StepOne : AppCompatActivity() {
    private lateinit var binding: ActivityStepOneBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStepOneBinding.inflate(layoutInflater)
        setContentView(binding.root)




        binding.bmbNext.setOnClickListener {
            val fuelPriceTemp = binding.tieFuelPrice.text

            if (fuelPriceTemp?.isEmpty() == true) {
                Snackbar.make(binding.tieFuelPrice, "preencha o campo", Snackbar.LENGTH_LONG).show()


            } else {

                val fuelPrice: Float = fuelPriceTemp.toString().toFloat()

                val intent = Intent(this, StepTwo::class.java)
                intent.apply {
                    putExtra("fuelprice", fuelPrice)

                }
                startActivity(intent)

            }

        }

    }
}