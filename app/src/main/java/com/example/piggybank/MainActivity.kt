package com.example.piggybank

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.piggybank.databinding.ActivityMainBinding
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var currentTotal = 0.0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button.setOnClickListener{ deposit()}
    }

    private fun deposit() {


        val depositAmount = binding.editTextNumber.text.toString().toDouble()
        currentTotal += depositAmount
        val newTotal = NumberFormat.getCurrencyInstance().format(currentTotal)

        binding.editTextNumber.text.clear()

        binding.total.text = newTotal
    }
}