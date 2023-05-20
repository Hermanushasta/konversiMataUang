package org.d3if0043.konversimatauang.ui.histori

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.d3if0043.konversimatauang.db.ConvertionDao

class   HistoriViewModelFactory(
    private val db: ConvertionDao
) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HistoriViewModel::class.java)) {
            return HistoriViewModel(db) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}