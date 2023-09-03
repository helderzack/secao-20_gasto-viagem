package com.helder.secao20_gastoviagem

import android.icu.text.NumberFormat
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.helder.secao20_gastoviagem.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        with(binding) {
            setSupportActionBar(toolbar)

            textViewValorGastoTotal.text = NumberFormat
                .getCurrencyInstance()
                .format(0)

            buttonCalcular.setOnClickListener {
                val distancia = textViewDistancia.text.toString().toDouble()
                val preco = textViewPreco.text.toString().toDouble()
                val autonomia = textViewAutonomia.text.toString().toDouble()
                val gastoTotal = (distancia * preco) / autonomia

                textViewValorGastoTotal.text = NumberFormat
                    .getCurrencyInstance()
                    .format(gastoTotal)
            }

            setContentView(root)
        }
    }
}