package com.example.mvvmcitei.ui.quotes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmcitei.databinding.ActivityQuotesBinding
import com.example.mvvmcitei.utilities.InjectorUtils

class QuotesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityQuotesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityQuotesBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initializeUi(binding)

        binding.buttonAddQuote.setOnClickListener {
            startActivity(Intent(this, AddCitacaoActivity::class.java))
        }
    }

    private fun initializeUi(binding: ActivityQuotesBinding) {
        val factory = InjectorUtils.provideQuotesViewModelFactory()
        val viewModel = ViewModelProvider(this, factory).get(QuotesViewModel::class.java)

        viewModel.getQuotes().observe(this, Observer { quotes ->
            val stringBuilder = StringBuilder()
            quotes.forEach {quote ->
                stringBuilder.append("$quote\n\n")
            }
            binding.textViewQuotes.text =  stringBuilder.toString()
        })
    }
}