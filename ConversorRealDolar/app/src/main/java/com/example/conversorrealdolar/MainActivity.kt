package com.example.conversorrealdolar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.conversorrealdolar.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonConverter.setOnClickListener {
            val real: Double = binding.editReal.text.toString().toDouble()
            val dolares = String.format("%.2f", real / 5)

            binding.textDolares.text = "$dolares $"
        }
    }
}