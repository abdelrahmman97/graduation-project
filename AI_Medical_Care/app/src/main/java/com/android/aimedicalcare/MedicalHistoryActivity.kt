package com.android.aimedicalcare

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlin.collections.ArrayList

class MedicalHistoryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_medical_history)

        val recyclerView = findViewById<View>(R.id.my_recycler_view) as RecyclerView

        val arrData = ArrayList<RecyclerViewData>()
        arrData.add(RecyclerViewData("Commodo vestibulum ultricies ", "2020-07-13"))
        arrData.add(RecyclerViewData("Enim quis lorem ", "2020-06-18"))
        arrData.add(RecyclerViewData("Pharetra consequat", "2020-02-23"))
        arrData.add(RecyclerViewData("Commodo vestibulum ultricies ", "2020-07-13"))
        arrData.add(RecyclerViewData("Enim quis lorem ", "2020-06-18"))
        arrData.add(RecyclerViewData("Pharetra consequat", "2020-02-23"))
        arrData.add(RecyclerViewData("Commodo vestibulum ultricies ", "2020-07-13"))
        arrData.add(RecyclerViewData("Enim quis lorem ", "2020-06-18"))
        arrData.add(RecyclerViewData("Pharetra consequat", "2020-02-23"))
        arrData.add(RecyclerViewData("Commodo vestibulum ultricies ", "2020-07-13"))
        arrData.add(RecyclerViewData("Enim quis lorem ", "2020-06-18"))
        arrData.add(RecyclerViewData("Pharetra consequat", "2020-02-23"))

        recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        val adapter = CustomAdapter(arrData)
        recyclerView.adapter = adapter
    }
}