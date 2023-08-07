package com.example.bookingapp.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bookingapp.R
import com.example.bookingapp.data.VOs.SeatVO
import com.example.bookingapp.delegate.SeatViewHolderDelegate
import com.example.bookingapp.viewholders.SeatViewHolder

class SeatAdapter(val delegate : SeatViewHolderDelegate): RecyclerView.Adapter<SeatViewHolder>() {

    private var mSeatList : List<List<SeatVO>> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SeatViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_holder_seat,parent,false)
        return SeatViewHolder(view,delegate)
    }

    override fun getItemCount(): Int {
        return mSeatList[0].count()
    }

    override fun onBindViewHolder(holder: SeatViewHolder, position: Int) {
//            if (mSeatList.isNotEmpty()){
//                holder.bindData(mSeatList[position])
//            }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setNewData(seatList: List<List<SeatVO>>){
        mSeatList = seatList
        notifyDataSetChanged()
    }
}