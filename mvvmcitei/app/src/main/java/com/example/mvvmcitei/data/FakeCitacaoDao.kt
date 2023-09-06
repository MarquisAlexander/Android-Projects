package com.example.mvvmcitei.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class FakeCitacaoDao {
    private val quoteList = mutableListOf<Citacao>()
    private val quotes = MutableLiveData<List<Citacao>>()

    init {
        quotes.value = quoteList
    }

    fun addQuote(quote: Citacao) {
        quoteList.add(quote)
        quotes.value = quoteList
    }

    fun getQuotes() = quotes as LiveData<List<Citacao>>
}