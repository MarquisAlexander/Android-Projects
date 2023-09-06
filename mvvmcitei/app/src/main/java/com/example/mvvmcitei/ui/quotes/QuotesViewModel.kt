package com.example.mvvmcitei.ui.quotes

import androidx.lifecycle.ViewModel
import com.example.mvvmcitei.data.Citacao
import com.example.mvvmcitei.data.CitacaoRepository

class QuotesViewModel(private val quoteRepository: CitacaoRepository) : ViewModel() {
    fun getQuotes() = quoteRepository.getQuotes()

    fun addQuote(quote: Citacao) = quoteRepository.addQuote(quote)
}