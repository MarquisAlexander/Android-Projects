package com.example.a04_conversormoeda

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.a04_conversormoeda.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonDolar.setOnClickListener {
           escrever(0.8)
        }

        binding.buttonPeso.setOnClickListener {
            escrever(10.2)
        }

        binding.buttonEuro.setOnClickListener {
            escrever(5.0)
        }
    }

    private fun escrever(taxa: Double) {
        val reais = binding.editReais.text.toString().trim()

        if(!reais.isEmpty()) {
            val result = String.format("%.2f", reais.toDouble() / taxa);
            Toast.makeText(applicationContext, "${result}$", Toast.LENGTH_SHORT).show()
        }
    }
}