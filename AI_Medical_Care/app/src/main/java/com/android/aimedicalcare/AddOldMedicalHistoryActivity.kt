package com.android.aimedicalcare

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class AddOldMedicalHistoryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_old_medical_history)

        val button8 = findViewById<View>(R.id.button8)

        button8.setOnClickListener {
            onBackPressed()
        }
    }
}