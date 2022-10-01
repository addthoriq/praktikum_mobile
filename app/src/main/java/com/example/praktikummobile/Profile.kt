package com.example.praktikummobile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView

class Profile : AppCompatActivity(), View.OnClickListener {
    private lateinit var etName: EditText
    private lateinit var etEmail: EditText
    private lateinit var etYearBorn: EditText
    private lateinit var tvName: TextView
    private lateinit var tvEmail: TextView
    private lateinit var tvYear: TextView
    private lateinit var btnBack: Button
    private lateinit var btnSave: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        relasiToXml()
    }

    private fun relasiToXml(){
        etName = findViewById(R.id.et_name)
        etEmail = findViewById(R.id.et_email)
        etYearBorn = findViewById(R.id.et_year_born)
        tvName = findViewById(R.id.tv_my_name)
        tvEmail = findViewById(R.id.tv_my_email)
        tvYear = findViewById(R.id.tv_my_year_born)
        btnBack = findViewById(R.id.btn_back)
        btnBack.setOnClickListener(this)
        btnSave = findViewById(R.id.btn_save)
        btnSave.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        if (v.id == R.id.btn_save){
            // Mengambil inputan
            val name = etName.text.toString().trim()
            val email = etEmail.text.toString().trim()
            val myYear = etYearBorn.text.toString().trim()
            var isEmptyFields = false
            // Validasi
            if (name.isEmpty()){
                isEmptyFields = true
                etName.error = "Field ini tidak boleh kosong"
            }
            if (email.isEmpty()){
                isEmptyFields = true
                etEmail.error = "Field ini tidak boleh kosong"
            }
            if (myYear.isEmpty()){
                isEmptyFields = true
                etYearBorn.error = "Field ini tidak boleh kosong"
            }
            if (!isEmptyFields){
                tvName.text = name
                tvEmail.text = email
                val tx = calculateYear(myYear.trim().toInt()).toString().trim() + " tahun"
                tvYear.text = tx
            }
        } else if (v.id == R.id.btn_back){
            onBackPressed()
        }
    }

    private fun calculateYear(tahun: Int): Int{
        return 2022 - tahun
    }


}