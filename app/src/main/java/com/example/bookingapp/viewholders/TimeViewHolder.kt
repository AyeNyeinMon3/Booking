package com.example.bookingapp.viewholders

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.bookingapp.R
import com.example.bookingapp.data.VOs.CinemaVO
import com.example.bookingapp.data.VOs.TimeslotsVO
import com.example.bookingapp.delegate.TimeViewHolderDelegate

class TimeViewHolder(itemView: View,private var delegate: TimeViewHolderDelegate) : RecyclerView.ViewHolder(itemView) {

    private var mTimeVO : TimeslotsVO? = null

    init {
        itemView.setOnClickListener {
            mTimeVO?.let {
                delegate.onTapTime(it.startTime)
            }
        }

    }

    fun bindData(TimeVO : TimeslotsVO){
        mTimeVO = TimeVO

        itemView.findViewById<TextView>(R.id.tv_startTime).text = TimeVO.startTime
    }

}