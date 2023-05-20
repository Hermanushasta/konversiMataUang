package org.d3if0043.konversimatauang.model

import android.provider.Settings.Global.getString
import org.d3if0043.konversimatauang.R
import org.d3if0043.konversimatauang.db.ConvertionEntity

fun ConvertionEntity.getNominal(): HasilKonversi {
    var hasil = 0f
    var kursUSD = 15166

    if (isIDR) {
        hasil = nominal / kursUSD
//        nominalKonversi = getString(R.string.usd_x, hasil.toString())
    } else {
        hasil = nominal * kursUSD
//        nominalKonversi = getString(R.string.rp_x, hasil.toString())
    }
    return HasilKonversi(hasil)
}