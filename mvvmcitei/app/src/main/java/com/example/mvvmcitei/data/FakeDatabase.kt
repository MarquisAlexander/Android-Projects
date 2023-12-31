package com.example.mvvmcitei.data

class FakeDatabase private constructor() {

    var quoteDao = FakeCitacaoDao()
        private set

    companion object {
        @Volatile private var instance: FakeDatabase? = null

        fun getInstance() =
            instance ?: synchronized(this) {
                instance ?: FakeDatabase().also { instance = it }
            }
    }
}