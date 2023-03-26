package org.d3if0043.konversimatauang

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.Toast
import org.d3if0043.konversimatauang.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button.setOnClickListener { konvertMataUang() }
    }

    private fun konvertMataUang() {
        val berat = binding.masukanIDRInp.text.toString()
        if (TextUtils.isEmpty(berat)) {
            Toast.makeText(this, R.string.berat_invalid, Toast.LENGTH_LONG).show()
            return
        }
        val kursUSD = 15166
        val bmi = berat.toFloat() / kursUSD
        binding.bmiTextView.text = getString(R.string.bmi_x, bmi)

    }
}