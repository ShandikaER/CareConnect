package com.example.project14

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.project14.databinding.ActivityProfileBinding
import com.google.firebase.auth.FirebaseAuth

class Profile : AppCompatActivity() {
    lateinit var binding: ActivityProfileBinding
    lateinit var auth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityProfileBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnEditAccount.setOnClickListener {
            startActivity(Intent(this, EditAccount::class.java))
            finish()
        }

        binding.btnBack.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
        binding.btnLogOut.setOnClickListener {
            auth = FirebaseAuth.getInstance()
            auth.signOut()
            Toast.makeText(this@Profile, "Berhasil LogOut",Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, Login::class.java))
            finish()
        }
    }
}