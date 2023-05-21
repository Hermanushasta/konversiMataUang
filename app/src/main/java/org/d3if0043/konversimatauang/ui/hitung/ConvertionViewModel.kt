package org.d3if0043.konversimatauang.ui.hitung

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.d3if0043.konversimatauang.db.ConvertionDao
import org.d3if0043.konversimatauang.db.ConvertionEntity
import org.d3if0043.konversimatauang.model.HasilKonversi
import org.d3if0043.konversimatauang.model.getNominal

class ConvertionViewModel (private val db:ConvertionDao) : ViewModel(){
    private val hasilKonversi = MutableLiveData<HasilKonversi>()

    val data = db.getLastConvertion()
    fun hitungKonversi (isIDR: Boolean, nominal: Float) {
        val dataKonversi = ConvertionEntity(
            nominal = nominal,
            isIDR = isIDR
        )
        hasilKonversi.value = dataKonversi.getNominal()

        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                db.insert(dataKonversi)
            }
        }
    }
}