package org.d3if0043.konversimatauang.ui.hitung

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import org.d3if0043.konversimatauang.R
import org.d3if0043.konversimatauang.databinding.FragmentConvertionBinding

class ConvertionFragment : Fragment() {
    private lateinit var binding: FragmentConvertionBinding

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding = ActivityMainBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//        binding.button.setOnClickListener { konvertMataUang() }
//    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentConvertionBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.button.setOnClickListener { konvertMataUang() }
    }

    private fun konvertMataUang() {
        val nominal = binding.masukanIDRInp.text.toString()
        if (TextUtils.isEmpty(nominal)) {
            Toast.makeText(context, R.string.nominal_invalid, Toast.LENGTH_LONG).show()
            return
        }
        val selectRadioButton = binding.radioGroup.checkedRadioButtonId
        if (selectRadioButton == -1) {
            Toast.makeText(context, R.string.radioInvalid, Toast.LENGTH_LONG).show()
            return
        }
        val isIDR = selectRadioButton == R.id.idrToUsdRadioButton
        val kursUSD = 15166.0f

        var nominalKonversi = getNominal(isIDR, nominal.toFloat(), kursUSD)
//        nominalKonversi = getString(R.string.usd_x, nominalKonversi)

        binding.hasilTextView.text = nominalKonversi

    }

    private fun getNominal(isIDR: Boolean, nominal: Float, kursUSD: Float): String {
        var hasil = 0f
        var nominalKonversi = ""

        if (isIDR) {
            hasil = nominal / kursUSD
            nominalKonversi = getString(R.string.usd_x, hasil.toString())
        } else {
            hasil = nominal * kursUSD
            nominalKonversi = getString(R.string.rp_x, hasil.toString())
        }
        return nominalKonversi
    }

}