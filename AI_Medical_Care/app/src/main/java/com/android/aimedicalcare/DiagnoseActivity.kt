package com.android.aimedicalcare

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.RecognizerIntent
import android.speech.SpeechRecognizer
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.util.*
import kotlin.collections.ArrayList

class DiagnoseActivity : AppCompatActivity() {

    private  val  RQ_SPEECH_REC = 102

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_diagnose)

        val btnDone = findViewById<View>(R.id.done_diagnose_btn) as Button
        val btnCncl = findViewById<View>(R.id.cancel_diagnose_btn) as Button

        askSpeechInput()

        btnCncl.setOnClickListener {
            onBackPressed()
        }

        btnDone.setOnClickListener {
            val intent = Intent(this, DiagnoseResultActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        val input = findViewById<View>(R.id.diagnoseInputSpeech) as TextView

        if(requestCode == RQ_SPEECH_REC && resultCode == Activity.RESULT_OK){
            val res: ArrayList<String>? = data?.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS)
            Toast.makeText(this, res?.get(0).toString(), Toast.LENGTH_LONG).show()
            input.text = res?.get(0).toString()
        }
    }

    private fun askSpeechInput() {
        if(!SpeechRecognizer.isRecognitionAvailable(this )){
            Toast.makeText(this , "not available", Toast.LENGTH_LONG).show()
        }
        else {
            val i= Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH)
            i.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM)
            i.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.ENGLISH)
            i.putExtra(RecognizerIntent.EXTRA_PROMPT,"Say something!")
            startActivityForResult(i,RQ_SPEECH_REC)
        }
    }
}