package com.example.project14.charities

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.project14.*
import com.example.project14.databinding.LayoutListCharitiesBinding

class CharitiesRecylerAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var items: List<ListObjCharities> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharitiesViewHolder {
        val binding = LayoutListCharitiesBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false)
        return CharitiesViewHolder(binding)
    }
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is CharitiesViewHolder -> {
                holder.bind(items.get(position))
                holder.klik.setOnClickListener {
                    holder.kalau_diklik (items.get(position))
                }
            }
        }
    }

    fun submitlist (listCharities: List<ListObjCharities>) {
        items = listCharities
    }
    override fun getItemCount(): Int {
        return items.size
    }
    class CharitiesViewHolder constructor(val binding: LayoutListCharitiesBinding) :
        RecyclerView.ViewHolder(binding.root) {

        val gambar: ImageView = binding.gambar
        val nama_charities: TextView = binding.namaCharities
        val ket_charities: TextView = binding.keteranganCharities
        var klik: RelativeLayout = binding.rlKlik

        fun bind(ListObjCharities: ListObjCharities) {
            nama_charities.setText(ListObjCharities.namaChar)
            ket_charities.setText (ListObjCharities.ketChar)

            val requestOp = RequestOptions()
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)

            Glide.with(itemView.context)
                .applyDefaultRequestOptions(requestOp)
                .load(ListObjCharities.gambar)
                .into(gambar)
        }
        fun kalau_diklik(get: ListObjCharities) {
            val intent = Intent (itemView.context, CharitiesDetail::class.java)
            intent.putExtra( "namanya", get.namaChar)
            intent.putExtra( "ketnya", get.penjelasan)
            intent.putExtra( "gambarnya", get.gambar)
            itemView.context.startActivity(intent)
        }

    }
}
