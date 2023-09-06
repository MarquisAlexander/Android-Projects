package com.example.mvvmcitei.ui.quotes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmcitei.data.Citacao
import com.example.mvvmcitei.databinding.ActivityAddCitacaoBinding
import com.example.mvvmcitei.utilities.InjectorUtils

class AddCitacaoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddCitacaoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityAddCitacaoBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initializeUi(binding)
    }

    private fun initializeUi(binding: ActivityAddCitacaoBinding) {
        val factory = InjectorUtils.provideQuotesViewModelFactory()
        val viewModel = ViewModelProvider(this, factory).get(QuotesViewModel::class.java)

        binding.buttonAddQuote.setOnClickListener {
            val quote =
                Citacao(binding.editTextQuote.text.toString(), binding.editTextAuthor.text.toString())
            viewModel.addQuote(quote)
            binding.editTextQuote.setText("")
            binding.editTextAuthor.setText("")

            Handler(Looper.getMainLooper()).postDelayed({
                finish()
            }, 1000)
        }

    }
}