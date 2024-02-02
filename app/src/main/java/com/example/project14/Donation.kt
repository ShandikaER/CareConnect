package com.example.project14

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.TaskStackBuilder
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.core.app.NotificationCompat
import com.example.project14.charities.CharitiesRecylerAdapter
import com.example.project14.charities.SumberData
import com.example.project14.databinding.ActivityDonationBinding

class Donation : AppCompatActivity() {
    lateinit var binding: ActivityDonationBinding
    private lateinit var charitiesAdapter: CharitiesRecylerAdapter
    val CHANNEL_ID = "channelID"
    val CHANNEL_NAME = "channelName"
    val NOTIFICATION_ID = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityDonationBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        buatNotifikasi()

        val intent = Intent(this, Notification::class.java)
        val pendingIntent = TaskStackBuilder.create(this).run {
            addNextIntentWithParentStack(intent)
            getPendingIntent(0, PendingIntent.FLAG_MUTABLE)
        }

        val notification = NotificationCompat.Builder(this, CHANNEL_ID)
            .setContentTitle("Belajar Notifikasi")
            .setContentText("Ini isi dari notifikasi kita ya")
            .setSmallIcon(R.drawable.ic_notif)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setContentIntent(pendingIntent)
            .build()

        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        binding.btnDonate.setOnClickListener {
            var selectChar = binding.ddSelectChar.text.toString()
            var amount = binding.amount.text.toString()
            var payment = binding.ddPayment.text.toString()

            if (selectChar.isEmpty()){
                binding.ddSelectChar.error = "Pilih Badan Amal Terlebih Dahulu"
                binding.ddSelectChar.requestFocus()
                return@setOnClickListener
            }
            if (amount.isEmpty()){
                binding.amount.error = "Masukkan Nominal Terlebih Dahulu"
                binding.amount.requestFocus()
                return@setOnClickListener
            }
            if (payment.isEmpty()){
                binding.ddPayment.error = "Pilih Pembayaran Terlebih Dahulu"
                binding.ddPayment.requestFocus()
                return@setOnClickListener
            }

            startActivity(Intent(this, DonationAccept::class.java))
            notificationManager.notify(NOTIFICATION_ID, notification)
            finish()
        }

        binding.btnBack.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }

    }

    override fun onResume() {
        super.onResume()
        val feelings = resources.getStringArray(R.array.feelings)
        val arrayAdapter = ArrayAdapter(this, R.layout.dropdown_item, feelings)
        binding.ddSelectChar.setAdapter(arrayAdapter)

        val payment = resources.getStringArray(R.array.payment)
        val arrayAdapter2 = ArrayAdapter(this, R.layout.dropdown_item, payment)
        binding.ddPayment.setAdapter(arrayAdapter2)

    }

    fun buatNotifikasi(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                CHANNEL_ID,
                CHANNEL_NAME,
                NotificationManager.IMPORTANCE_DEFAULT
            )
                .apply {
                    lightColor = Color.GREEN
                    enableLights(true)
                }
            val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            manager.createNotificationChannel(channel)
        }
    }
}