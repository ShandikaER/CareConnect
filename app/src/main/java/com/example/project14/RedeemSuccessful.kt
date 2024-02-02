package com.example.project14

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.project14.databinding.ActivityRedeemSuccessfulBinding

class RedeemSuccessful : AppCompatActivity() {
    lateinit var binding: ActivityRedeemSuccessfulBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityRedeemSuccessfulBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnGoback.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }
}