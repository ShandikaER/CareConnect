package com.example.project14

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import com.example.project14.databinding.ActivityRegisterBinding
import com.google.firebase.auth.FirebaseAuth

class Register : AppCompatActivity() {
    lateinit var binding: ActivityRegisterBinding
    lateinit var auth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()
        binding.btnRegister.setOnClickListener {
            var username = binding.edtUsername.text.toString()
            var email = binding.edtEmail.text.toString()
            var password = binding.edtPassword.text.toString()
            var passwordConfirmation = binding.edtPasswordConfirm.text.toString()

            if (username.isEmpty()){
                binding.edtUsername.error = "Username Harus Diisi"
                binding.edtUsername.requestFocus()
                return@setOnClickListener
            }
            if (email.isEmpty()){
                binding.edtEmail.error = "Email Harus Diisi"
                binding.edtEmail.requestFocus()
                return@setOnClickListener
            }
            if (!Patterns.EMAIL_ADDRESS.matcher(email) .matches()) {
                binding.edtEmail.error = "Email Tidak Valid"
                binding.edtEmail.requestFocus()
                return@setOnClickListener
            }
            if (password.isEmpty()){
                binding.edtPassword.error = "Password Harus Diisi"
                binding.edtPassword.requestFocus()
                return@setOnClickListener
            }
            if (password.length < 6){
                binding.edtPassword.error = "Password Minimal 6 Karakter"
                binding.edtPassword.requestFocus()
                return@setOnClickListener
            }
            if (!password.equals(passwordConfirmation)){
                binding.edtPasswordConfirm.error = "Password Tidak Cocok"
                binding.edtPasswordConfirm.requestFocus()
                return@setOnClickListener
            }

            datarUserFirebase(email, password)
        }
    }

    private fun datarUserFirebase(email: String, password: String) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) {
                if(it.isSuccessful){
                    Toast.makeText(this, "Berhasil Membuat Akun", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this, FillProfile::class.java))
                    finish()
                } else{
                    Toast.makeText(this, "Coba Lagi", Toast.LENGTH_SHORT).show()
                }
            }

    }

}