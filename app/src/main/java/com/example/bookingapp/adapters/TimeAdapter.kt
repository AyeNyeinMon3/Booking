package com.example.bookingapp.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bookingapp.R
import com.example.bookingapp.data.VOs.TimeslotsVO
import com.example.bookingapp.delegate.TimeViewHolderDelegate
import com.example.bookingapp.viewholders.TimeViewHolder

class TimeAdapter(private var delegate: TimeViewHolderDelegate): RecyclerView.Adapter<TimeViewHolder>() {

    private var mTimeList :  List<TimeslotsVO> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TimeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_holder_time,parent,false)
        return TimeViewHolder(view,delegate)
    }

    override fun getItemCount(): Int {
        return mTimeList.count()
    }

    override fun onBindViewHolder(holder: TimeViewHolder, position: Int) {

            holder.bindData(mTimeList[position])

    }

    @SuppressLint("NotifyDataSetChanged")
    fun setNewData(timeList : List<TimeslotsVO>){
        mTimeList = timeList
        notifyDataSetChanged()
    }
}