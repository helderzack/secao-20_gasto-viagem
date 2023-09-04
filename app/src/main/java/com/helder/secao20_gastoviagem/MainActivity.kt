package com.helder.secao20_gastoviagem

import android.icu.text.NumberFormat
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.helder.secao20_gastoviagem.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        with(binding) {
            setSupportActionBar(toolbar)

            textViewTotalExpense.text = NumberFormat
                .getCurrencyInstance()
                .format(0)

            buttonCalculate.setOnClickListener {
                calculate(
                    editTextDistance.text.toString(),
                    editTextPrice.text.toString(),
                    editTextAutonomy.text.toString()
                )
            }

            setContentView(root)
        }
    }

    private fun calculate(
        distanceText: String,
        priceText: String,
        autonomyText: String
    ) {
        if (distanceText.isBlank() || distanceText.isEmpty()
            || priceText.isBlank() || priceText.isEmpty()
            || autonomyText.isBlank() || autonomyText.isEmpty()
        ) {
            Toast.makeText(
                applicationContext,
                getString(R.string.warning),
                Toast.LENGTH_SHORT
            ).show()
            return
        }

        val distance = distanceText.toDouble()
        val price = priceText.toDouble()
        val autonomy = autonomyText.toDouble()
        val totalExpense = (distance * price) / autonomy

        binding.textViewTotalExpense.text = NumberFormat
            .getCurrencyInstance()
            .format(totalExpense)
    }
}