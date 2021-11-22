package com.android.aimedicalcare

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.navigation.NavDeepLinkBuilder
import com.android.aimedicalcare.ui.patient.PatientFragment
import com.google.zxing.BarcodeFormat
import com.google.zxing.WriterException
import com.google.zxing.qrcode.QRCodeWriter

class GenerateQRCodeActivity : AppCompatActivity() {

    private  lateinit var  ivQRcode : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_generate_qrcode)

        ivQRcode = findViewById(R.id.qr_code_img)

        generateQRCode()


//      val qrCodeImage = findViewById<View>(R.id.qr_code_img) as ImageView
        val cancelGenerate = findViewById<View>(R.id.cancel_generate) as Button
        cancelGenerate.setOnClickListener {
            onBackPressed()
        }

//        val actionbar = supportActionBar
//        actionbar!!.title = "QR Code"
//
//        actionbar.setDisplayHomeAsUpEnabled(true)

    }

    fun generateQRCode() {
        val data = "Abdo"
        if(data.isEmpty()){
            Toast.makeText(this, "enter tsxt", Toast.LENGTH_SHORT).show()
        }
        else {
            val writer = QRCodeWriter()
            try {
                val bitMatrix=writer.encode(data, BarcodeFormat.QR_CODE,512,512)
                val width =bitMatrix.width
                val height =bitMatrix.height
                val bmp = Bitmap.createBitmap(width,height, Bitmap.Config.RGB_565)
                for(x in 0 until width) {
                    for(y in 0 until  height){
                        bmp.setPixel(x,y,if(bitMatrix[x,y]) Color.BLACK else Color.WHITE)
                    }
                }
                ivQRcode.setImageBitmap(bmp)
            }catch (e: WriterException){
                e.printStackTrace()
            }

        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}