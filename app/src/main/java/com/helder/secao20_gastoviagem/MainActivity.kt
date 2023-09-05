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

            textViewTotalExpenseValue.text = NumberFormat
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
        distance: String,
        price: String,
        autonomy: String
    ) {
        if (distance.isBlank() || distance.isEmpty()
            || price.isBlank() || price.isEmpty()
            || autonomy.isBlank() || autonomy.isEmpty()
        ) {
            Toast.makeText(
                applicationContext,
                getString(R.string.warning),
                Toast.LENGTH_SHORT
            ).show()
            return
        }

        val totalExpense = (distance.toDouble() * price.toDouble()) / autonomy.toDouble()

        binding.textViewTotalExpenseValue.text = NumberFormat
            .getCurrencyInstance()
            .format(totalExpense)
    }
}