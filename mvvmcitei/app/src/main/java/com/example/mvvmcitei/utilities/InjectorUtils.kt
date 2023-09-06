package com.example.mvvmcitei.utilities

import com.example.mvvmcitei.data.FakeDatabase
import com.example.mvvmcitei.data.CitacaoRepository
import com.example.mvvmcitei.ui.quotes.QuotesViewModelFactory

object InjectorUtils {
    fun provideQuotesViewModelFactory(): QuotesViewModelFactory {
        val quoteRepository = CitacaoRepository.getInstance(FakeDatabase.getInstance().quoteDao)
        return QuotesViewModelFactory(quoteRepository)
    }
}