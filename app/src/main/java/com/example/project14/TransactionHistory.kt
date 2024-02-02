package com.example.project14

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.project14.databinding.ActivityTransactionHistory1Binding

class TransactionHistory : AppCompatActivity() {
    lateinit var binding: ActivityTransactionHistory1Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityTransactionHistory1Binding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}