package com.example.menurestaurante

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.menurestaurante.databinding.ActivityDadosPedidoBinding

class DadosPedidoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDadosPedidoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDadosPedidoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val i = intent
        val quant_cafe = i.getStringExtra("quant_cafe").toString().toInt()
        val quant_pao = i.getStringExtra("quant_pao").toString().toInt()
        val quant_chocolate = i.getStringExtra("quant_chocolate").toString().toInt()
        val preco_cafe = i.getDoubleExtra("preco_cafe", 0.0)
        val preco_pao = i.getDoubleExtra("preco_pao", 0.0)
        val preco_chocolate = i.getDoubleExtra("preco_chocolate", 0.0)

        val texto = "Resumo do pedido: \n" +
                "Cafe: $quant_cafe Preco: ${quant_cafe * preco_cafe} R$ \n" +
                "Pao: $quant_pao Preco: ${quant_pao * preco_pao} R$ \n" +
                "Chocolate: $quant_chocolate Preco: ${quant_chocolate * preco_chocolate} R$ \n"

        binding.textResumo.text = texto
    }
}