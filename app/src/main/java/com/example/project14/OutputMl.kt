package com.example.project14

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONException
import org.json.JSONObject
import java.nio.charset.Charset

class OutputMl : AppCompatActivity() {
    private lateinit var profesi: EditText
    private lateinit var penghasilan: EditText
    private lateinit var umur: EditText
    private lateinit var deteksi: Button
    private lateinit var hasil: TextView
    private lateinit var btnBack: Button
    private val url = "https://shandikaer.pythonanywhere.com/predict"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_output_ml)

        profesi = findViewById(R.id.profesi)
        penghasilan = findViewById(R.id.penghasilan)
        umur = findViewById(R.id.umur)
        deteksi = findViewById(R.id.deteksi)
        hasil = findViewById(R.id.hasil)
        btnBack = findViewById(R.id.btnBack)

        btnBack.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
        deteksi.setOnClickListener{
            val jsonObject = JSONObject()
            jsonObject.put("cgpa", profesi.text.toString())
            jsonObject.put("iq", penghasilan.text.toString())
            jsonObject.put("profile_score", umur.text.toString())

            val requestBody = jsonObject.toString()

            val jsonObjectRequest = object : JsonObjectRequest(
                Method.POST, url, jsonObject,
                Response.Listener { response ->
                    try {
                        val data = response.getString("placement")
                        hasil.text = if (data == "1") {
                            "Layak"
                        } else {
                            "Tidak Layak"
                        }   
                    } catch (e: JSONException) {
                        e.printStackTrace()
                    }
                },
                Response.ErrorListener { error ->
                    Toast.makeText(this@OutputMl, error.message, Toast.LENGTH_SHORT).show()
                }) {
                override fun getBodyContentType(): String {
                    return "application/json"
                }
                override fun getBody(): ByteArray {
                    return requestBody.toByteArray(Charset.defaultCharset())
                }
            }
            val queue = Volley.newRequestQueue(this@OutputMl)
            queue.add(jsonObjectRequest)
        }
    }
}