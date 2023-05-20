package org.d3if0043.konversimatauang.ui.histori

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.d3if0043.konversimatauang.db.ConvertionDao

class HistoriViewModel(private val db:ConvertionDao):ViewModel() {
val data = db.getLastConvertion()

    fun hapusData() = viewModelScope.launch {
        withContext(Dispatchers.IO) {
            db.clearData()
        }
    }
}