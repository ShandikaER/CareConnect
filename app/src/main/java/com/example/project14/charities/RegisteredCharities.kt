package com.example.project14.charities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.project14.*
import com.example.project14.databinding.ActivityRegisteredCharitiesBinding

class RegisteredCharities : AppCompatActivity() {
    private lateinit var charitiesAdapter: CharitiesRecylerAdapter
    lateinit var binding: ActivityRegisteredCharitiesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityRegisteredCharitiesBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initRecyclerView()
        tambahDataSet()

        binding.btnBack.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }
    private fun tambahDataSet(){
        val data = SumberData.buatSetData()
        charitiesAdapter.submitlist(data)
    }

    private fun initRecyclerView(){
        binding.recylerView.apply {
            layoutManager = LinearLayoutManager(this@RegisteredCharities)
            val spacingAtas = DekorasiSpasiGambar(20)
            addItemDecoration(spacingAtas)
            charitiesAdapter = CharitiesRecylerAdapter()
            adapter = charitiesAdapter
        }
    }
}