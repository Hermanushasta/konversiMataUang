package org.d3if0043.konversimatauang

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
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
        val nominal = binding.masukanIDRInp.text.toString()
        if (TextUtils.isEmpty(nominal)) {
            Toast.makeText(this, R.string.nominal_invalid, Toast.LENGTH_LONG).show()
            return
        }
        val selectRadioButton = binding.radioGroup.checkedRadioButtonId
        if (selectRadioButton == -1) {
            Toast.makeText(this, R.string.radioInvalid, Toast.LENGTH_LONG).show()
            return
        }
        val isIDR = selectRadioButton == R.id.idrToUsdRadioButton
        val kursUSD = 15166.0f

        val nominalKonversi =getNominal(isIDR, nominal.toFloat(), kursUSD )
        binding.hasilTextView.text = nominalKonversi

    }
    private fun getNominal(isIDR: Boolean, nominal:Float, kursUSD:Float): String {

        val hasil : Float =
        if (isIDR) {
            nominal / kursUSD
        } else {
            nominal * kursUSD
        }
        return hasil.toString()
    }

}