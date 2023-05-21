package org.d3if0043.konversimatauang.model

import android.provider.Settings.Global.getString
import org.d3if0043.konversimatauang.R
import org.d3if0043.konversimatauang.db.ConvertionEntity

fun ConvertionEntity.getNominal(): HasilKonversi {
    var hasil = 0f
    var kursUSD = 15166

    if (isIDR) {
        hasil = nominal / kursUSD
    } else {
        hasil = nominal * kursUSD
    }
    return HasilKonversi(hasil)
}