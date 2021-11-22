package com.android.aimedicalcare

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telecom.Call
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.Toast
import okhttp3.Callback
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class TextDiagnoseActivity : AppCompatActivity() {



    lateinit var txt:EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_text_diagnose)

        val cnclBtn = findViewById<View>(R.id.cancel_diagnose)
        val doneBtn = findViewById<View>(R.id.done_diagnose)

        txt= findViewById<View>(R.id.editTextTextPersonName9) as EditText



        cnclBtn.setOnClickListener {
            onBackPressed()
        }

        doneBtn.setOnClickListener {
            val url = "http://192.168.137.1:8888/"
//        val url = "http://127.0.0.1:8000/"
//        val url = "http://10.0.2.52:8000/"
            val retrofit = Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
//        val api: API = retrofit.create(API::class.java)
            val api: API2 = retrofit.create(API2::class.java)





            api
                .postComplaint(MyPostData("Ahmed", txt.text.toString()))
                .enqueue(object : retrofit2.Callback<MyResponse?> {
                    override fun onResponse(
                        call: retrofit2.Call<MyResponse?>,
                        response: retrofit2.Response<MyResponse?>
                    ) {
                        if (response.isSuccessful && response.body() != null) {
                            Toast.makeText(
                                this@TextDiagnoseActivity,
                                "ok" + response.body()?.diagnose1,
                                Toast.LENGTH_SHORT
                            ).show()


                            var msg =
                                "onResponse: diagnose1 =  ${response.body()!!.diagnose1} \n diag 2 = ${response.body()!!.diagnose2} \n list is ${response.body()!!.symptoms[0]}"
                            Log.d("TEST_API", msg)


                            val intent = Intent(
                                this@TextDiagnoseActivity,
                                DiagnoseResultActivity::class.java
                            )
                            intent.putExtra("res", response.body())
                            startActivity(intent)


                        } else {
                            Toast.makeText(
                                this@TextDiagnoseActivity,
                                "No Page Founded",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }

                    override fun onFailure(call: retrofit2.Call<MyResponse?>, t: Throwable) {
                        Toast.makeText(this@TextDiagnoseActivity, "error", Toast.LENGTH_LONG).show()

                        Log.d("TEST_API", "onFailure: ${t.message}")
                    }
                })


        }
    }
}