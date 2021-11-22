package com.android.aimedicalcare

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter(private val dataList: ArrayList<RecyclerViewData>):RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    class ViewHolder(itemView: View, var mydata:RecyclerViewData?=null):RecyclerView.ViewHolder(itemView) {
        init {
            itemView.setOnClickListener {
                val intent = Intent(itemView.context, MedicalHistoryRecordActivity::class.java)
                intent.putExtra("name", mydata?.name)
                intent.putExtra("date", mydata?.date)
            }
        }

        val vwName = itemView.findViewById<View>(R.id.textView10) as TextView
        val vwDate = itemView.findViewById<View>(R.id.textView13) as TextView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.recycler_row,parent,false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data :RecyclerViewData = dataList[position]
        holder.vwName.text = data.name
        holder.vwDate.text = data.date.toString()
        holder.mydata = data
    }

    override fun getItemCount(): Int {
        return dataList.size
    }
}