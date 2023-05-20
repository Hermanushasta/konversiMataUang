package org.d3if0043.konversimatauang.ui.hitung

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.d3if0043.konversimatauang.db.ConvertionDao

class ConvertionViewModelFactory(
    private val db : ConvertionDao
) : ViewModelProvider.Factory  {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ConvertionViewModel::class.java)) {
            return ConvertionViewModel(db) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}