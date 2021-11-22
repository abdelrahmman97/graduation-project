package com.android.aimedicalcare

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class RegisterPatientActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_patient)

        val btnSignIn = findViewById<View>(R.id.button4)
        val btnRgistr = findViewById<View>(R.id.button5)
        val btnActionRgistr = findViewById<View>(R.id.button6)

        btnSignIn.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
        btnRgistr.setOnClickListener {
            val intent = Intent(this, RegisterPatientActivity::class.java)
            startActivity(intent)
        }
        btnActionRgistr.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

    }
}