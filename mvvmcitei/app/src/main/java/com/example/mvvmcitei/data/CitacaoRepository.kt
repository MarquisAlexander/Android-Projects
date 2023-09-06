package com.example.mvvmcitei.data

class CitacaoRepository private constructor(private val quoteDao: FakeCitacaoDao) {

    fun addQuote(quote: Citacao) {
        quoteDao.addQuote(quote)
    }

    fun getQuotes() = quoteDao.getQuotes()

    companion object {
        @Volatile private var instance: CitacaoRepository? = null

        fun getInstance(quoteDao: FakeCitacaoDao) =
            instance ?: synchronized(this) {
                instance ?: CitacaoRepository(quoteDao).also { instance = it }
            }
    }
}