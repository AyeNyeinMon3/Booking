package com.example.bookingapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bookingapp.R
import com.example.bookingapp.data.VOs.DateVos
import com.example.bookingapp.viewholders.DateViewHolder

class DateAdapter(private val dateList: List<DateVos>): RecyclerView.Adapter<DateViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DateViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_holder_date,parent,false)
        return DateViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dateList.count()
    }

    override fun onBindViewHolder(holder: DateViewHolder, position: Int) {
        val dateVo = dateList[position]
        holder.bindData(dateVo)

    }
}