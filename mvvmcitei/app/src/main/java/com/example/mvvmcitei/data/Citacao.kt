package com.example.mvvmcitei.data

data class Citacao(val quoteText: String, val author: String) {
    override fun toString(): String {
        return "$quoteText - $author"
    }
}