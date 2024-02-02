package com.example.project14.charities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.project14.*
import com.example.project14.databinding.ActivityCharitiesDetailBinding

class CharitiesDetail : AppCompatActivity() {

    lateinit var binding: ActivityCharitiesDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityCharitiesDetailBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        if(intent.hasExtra("namanya")) {
            val nama: String = this.intent.getStringExtra("namanya").toString()
            val gambar: String = this.intent.getStringExtra("gambarnya").toString()
            val jelas: String = this.intent.getStringExtra("ketnya").toString()
            setDetil(gambar, nama, jelas)
        }

        binding.btnBack.setOnClickListener{
            startActivity(Intent(this, RegisteredCharities::class.java))
            finish()
        }

        binding.btnDonate.setOnClickListener{
            startActivity(Intent(this, Donation::class.java))
            finish()
        }


    }
    fun setDetil(gambar: String, nama: String, ket: String){
        val requestOp = RequestOptions()
            .placeholder(R.drawable.ic_launcher_background)
            .error(R.drawable.ic_launcher_background)

        binding.namaCharitiesDetil.text = nama
        binding.ketCharitiesDetil.text = ket
        Glide.with(this)
            .load(gambar)
            .apply(requestOp)
            .centerCrop()
            .into(binding.gambarDetil)
    }
}