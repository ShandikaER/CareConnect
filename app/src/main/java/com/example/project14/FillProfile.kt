package com.example.project14

import android.app.Dialog
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.project14.databinding.ActivityFillProfileBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference

class FillProfile : AppCompatActivity() {
    private lateinit var binding : ActivityFillProfileBinding
    private lateinit var auth : FirebaseAuth
    private lateinit var databaseReference: DatabaseReference
    private lateinit var storageReference: StorageReference
    private lateinit var imageUri : Uri

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityFillProfileBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()
        val uid = auth.currentUser?.uid
        databaseReference = FirebaseDatabase.getInstance().getReference("Users")
        binding.saveBtn.setOnClickListener {
            val name = binding.etFirstName.text.toString()
            val address = binding.etAddress.text.toString()
            val mobilePhone = binding.etMobilePhone.text.toString()

            if (name.isEmpty()){
                binding.etFirstName.error = "Nama Harus Diisi"
                binding.etFirstName.requestFocus()
                return@setOnClickListener
            }
            if (address.isEmpty()){
                binding.etAddress.error = "Alamat Harus Diisi"
                binding.etAddress.requestFocus()
                return@setOnClickListener
            }
            if (mobilePhone.isEmpty()){
                binding.etMobilePhone.error = "No Telp Harus Diisi"
                binding.etMobilePhone.requestFocus()
                return@setOnClickListener
            }

            val user = UserData(name, address, mobilePhone)
            if(uid != null){
                databaseReference.child(uid).setValue(user).addOnCompleteListener {
                    if (it.isSuccessful){
                        uploadProfilePic()
                    } else {

                        Toast.makeText(this@FillProfile, "Gagal Membuat Profil", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }

    private fun uploadProfilePic(){
        imageUri = Uri.parse("android.resource://$packageName/${R.drawable.profile}")
        storageReference = FirebaseStorage.getInstance().getReference("Users"+auth.currentUser?.uid)
        storageReference.putFile(imageUri).addOnSuccessListener {

            Toast.makeText(this@FillProfile, "Berhasil Membuat Profil", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, CongratsRegister::class.java))
            finish()
        }.addOnFailureListener{
            Toast.makeText(this@FillProfile, "Gagal Membuat Profil", Toast.LENGTH_SHORT).show()
        }
    }
}