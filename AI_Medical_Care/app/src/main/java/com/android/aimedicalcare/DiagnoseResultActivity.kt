package com.android.aimedicalcare

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast

class DiagnoseResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_diagnose_result)

        val textView12 = findViewById<View>(R.id.textView12) as TextView

        val intent = intent
        var reponse : MyResponse = intent.getSerializableExtra("res") as MyResponse

        "Your symptoms are: ${reponse.symptoms.toString()}, and you may have: ${reponse.diagnose1.toString()}  and ${reponse.diagnose2.toString()}".also { textView12.text = it }

        Toast.makeText(this, "Test is ${reponse.diagnose1}", Toast.LENGTH_SHORT).show()


    }
}