package com.example.bookingapp.viewholders

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.bookingapp.R
import com.example.bookingapp.data.VOs.DateVos

class DateViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private var mdate : DateVos? = null

   fun bindData(date: DateVos){
       mdate = date

       itemView.findViewById<TextView>(R.id.tv_monthName).text = date.monthName
       itemView.findViewById<TextView>(R.id.tv_day).text = date.day
       itemView.findViewById<TextView>(R.id.tv_dayName).text = date.dayName
   }

}