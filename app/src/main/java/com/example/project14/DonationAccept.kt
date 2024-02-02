package com.example.project14

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.project14.databinding.ActivityDonationAcceptBinding

class DonationAccept : AppCompatActivity() {
    lateinit var binding: ActivityDonationAcceptBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityDonationAcceptBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnGotohome.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }
}