package com.example.project14

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.project14.databinding.ActivityCongratsRegisterBinding

class CongratsRegister : AppCompatActivity() {
    lateinit var binding: ActivityCongratsRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityCongratsRegisterBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnGotohome.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }
}