package com.example.praktikummobile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var etLength: EditText
    private lateinit var etWidth: EditText
    private lateinit var etHeight: EditText
    private lateinit var btnCalculate: Button
    private lateinit var tvResult: TextView
    private lateinit var btnMove: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        relasiToXml()
    }

    fun relasiToXml(){
        etLength = findViewById(R.id.et_length)
        etWidth = findViewById(R.id.et_width)
        etHeight = findViewById(R.id.et_height)
        tvResult = findViewById(R.id.tv_hasil)
        btnCalculate = findViewById(R.id.btn_hitung)
        btnCalculate.setOnClickListener(this)
        btnMove = findViewById(R.id.btn_move_profile)
        btnMove.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        // cek Tombol untuk Hitung
        when (v.id){
            R.id.btn_hitung -> {
                val inputLength = etLength.text.toString().trim()
                val inputWidth = etWidth.text.toString().trim()
                val inputHeight = etHeight.text.toString().trim()

                var isEmptyFields = false

                // Validasi apakah inputan masih ada yang kosong
                if (inputLength.isEmpty()){
                    isEmptyFields = true
                    etLength.error = "Field ini tidak boleh kosong"
                }
                if (inputWidth.isEmpty()){
                    isEmptyFields = true
                    etWidth.error = "Field ini tidak boleh kosong"
                }
                if (inputHeight.isEmpty()){
                    isEmptyFields = true
                    etHeight.error = "Field ini tidak boleh kosong"
                }

                // Jika semua inputan valid, maka tampilkan hasilnya
                if (!isEmptyFields){
                    val volume = inputLength.toDouble() * inputWidth.toDouble() * inputHeight.toDouble()
                    tvResult.text = volume.toString()

                    // Tambahkan Toast
                    Toast.makeText(applicationContext, tvResult.text, Toast.LENGTH_LONG).show()
                }
            }
            R.id.btn_move_profile -> {
                val inten = Intent(this@MainActivity, Profile::class.java)
                startActivity(inten)
            }
            R.id.btn_move_list -> {
                val itn = Intent(this@MainActivity, RecyclerView::class.java)
                startActivity(itn)
            }
        }
    }
}