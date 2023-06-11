package org.d3if0043.konversimatauang.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import org.d3if0043.konversimatauang.R
import org.d3if0043.konversimatauang.databinding.BenderaBinding
import org.d3if0043.konversimatauang.model.Bendera
import org.d3if0043.konversimatauang.network.BenderaApi

class MainAdapter() : RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    private val data = mutableListOf<Bendera>()

    fun updateData(newData: List<Bendera>) {
        data.clear()
        data.addAll(newData)
        notifyDataSetChanged()
    }

    class ViewHolder(
        private val binding: BenderaBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(bendera: Bendera) = with(binding) {
            mataUang.text = bendera.konversi
            Glide.with(flagImageView.context)
                .load(BenderaApi.getBenderaUrl(bendera.imageResId))
                .error(R.drawable.baseline_broken_image_24)
                .into(flagImageView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = BenderaBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])
    }
}