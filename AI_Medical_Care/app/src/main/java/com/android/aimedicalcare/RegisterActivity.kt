package com.android.aimedicalcare

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val btnDoctor = findViewById<View>(R.id.btn_doctor)
        val btnPatient = findViewById<View>(R.id.btn_patient)

        btnDoctor.setOnClickListener {
            val intent = Intent(this, RegisterDoctorActivity::class.java)
            startActivity(intent)
        }
        btnPatient.setOnClickListener {
            val intent = Intent(this, RegisterPatientActivity::class.java)
            startActivity(intent)
        }
    }
}