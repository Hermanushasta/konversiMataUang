package org.d3if0043.konversimatauang

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navController = findNavController(R.id.myNavHostFragment)
        NavigationUI.setupActionBarWithNavController(this, navController )
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp()
    }

//    private lateinit var binding: ActivityMainBinding
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding = ActivityMainBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//        binding.button.setOnClickListener { konvertMataUang() }
//    }
//
//    private fun konvertMataUang() {
//        val nominal = binding.masukanIDRInp.text.toString()
//        if (TextUtils.isEmpty(nominal)) {
//            Toast.makeText(this, R.string.nominal_invalid, Toast.LENGTH_LONG).show()
//            return
//        }
//        val selectRadioButton = binding.radioGroup.checkedRadioButtonId
//        if (selectRadioButton == -1) {
//            Toast.makeText(this, R.string.radioInvalid, Toast.LENGTH_LONG).show()
//            return
//        }
//        val isIDR = selectRadioButton == R.id.idrToUsdRadioButton
//        val kursUSD = 15166.0f
//
//        var nominalKonversi = getNominal(isIDR, nominal.toFloat(), kursUSD)
////        nominalKonversi = getString(R.string.usd_x, nominalKonversi)
//
//        binding.hasilTextView.text = nominalKonversi
//
//    }
//
//    private fun getNominal(isIDR: Boolean, nominal: Float, kursUSD: Float): String {
//        var hasil = 0f
//        var nominalKonversi = ""
//
//        if (isIDR) {
//            hasil = nominal / kursUSD
//            nominalKonversi = getString(R.string.usd_x, hasil.toString())
//        } else {
//            hasil = nominal * kursUSD
//            nominalKonversi = getString(R.string.rp_x, hasil.toString())
//        }
//        return nominalKonversi
//    }

}