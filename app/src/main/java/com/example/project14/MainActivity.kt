package com.example.project14

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.project14.charities.RegisteredCharities
import com.example.project14.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnRegisterCharities.setOnClickListener {
            startActivity(Intent(this, RegisteredCharities::class.java))
            finish()
        }

        binding.notif.setOnClickListener {
            startActivity(Intent(this, Notification::class.java))
            finish()
        }

        binding.btnDonate.setOnClickListener {
            startActivity(Intent(this, Donation::class.java))
            finish()
        }

        binding.btnNews.setOnClickListener {
            startActivity(Intent(this, News::class.java))
            finish()
        }

        binding.btnMl.setOnClickListener {
            startActivity(Intent(this, OutputMl::class.java))
            finish()
        }


        binding.profile.setOnClickListener{
            startActivity(Intent(this, Profile::class.java))
            finish()
        }
    }

}
