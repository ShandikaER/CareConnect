package com.example.project14

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.project14.databinding.ActivityEditAccountBinding

class EditAccount : AppCompatActivity() {
    lateinit var binding: ActivityEditAccountBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityEditAccountBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnBack.setOnClickListener {
            startActivity(Intent(this, Profile::class.java))
            finish()
        }
    }
}