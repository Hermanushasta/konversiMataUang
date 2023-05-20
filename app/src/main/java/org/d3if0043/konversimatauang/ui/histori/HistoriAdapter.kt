package org.d3if0043.konversimatauang.ui.histori

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import org.d3if0043.konversimatauang.databinding.ItemHistoriBinding
import org.d3if0043.konversimatauang.db.ConvertionEntity
import org.d3if0043.konversimatauang.model.getNominal
import java.text.SimpleDateFormat
import java.util.*

class HistoriAdapter :
    ListAdapter<ConvertionEntity, HistoriAdapter.ViewHolder>(DIFF_CALLBACK) {

    companion object {
        private val DIFF_CALLBACK =
            object : DiffUtil.ItemCallback<ConvertionEntity>() {
                override fun areItemsTheSame(
                    oldData: ConvertionEntity, newData: ConvertionEntity
                ): Boolean {
                    return oldData.id == newData.id
                }

                override fun areContentsTheSame(
                    oldData: ConvertionEntity, newData: ConvertionEntity
                ): Boolean {
                    return oldData == newData
                }
            }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemHistoriBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ViewHolder(
        private val binding: ItemHistoriBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        private val dateFormatter = SimpleDateFormat("dd MMMM yyyy", Locale("id", "ID"))

        fun bind(item: ConvertionEntity) = with(binding) {
            val hasilKonversi = item.getNominal()
        }
    }

}