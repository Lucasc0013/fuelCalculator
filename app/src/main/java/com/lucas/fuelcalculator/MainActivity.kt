package com.lucas.fuelcalculator

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.lucas.fuelcalculator.databinding.ActivityMainBinding
import com.lucas.fuelcalculator.databinding.ActivityStepOneBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bmbStart.setOnClickListener{
            intent = Intent(this,StepOne::class.java)
            startActivity(intent)
        }

    }
}