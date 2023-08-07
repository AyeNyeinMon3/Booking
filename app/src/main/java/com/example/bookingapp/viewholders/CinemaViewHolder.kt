package com.example.bookingapp.viewholders

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.bookingapp.R
import com.example.bookingapp.data.VOs.CinemaVO
import com.example.bookingapp.delegate.CinemaViewHolderDelegate

class CinemaViewHolder(itemView: View,private var delegate: CinemaViewHolderDelegate) : RecyclerView.ViewHolder(itemView){

    private var mCinemaVO : CinemaVO? = null

    init {
        itemView.setOnClickListener {
            mCinemaVO?.let {
                delegate.onTapCinema(it.cinema,it.timeslots)


            }
        }
    }

    fun bindData(cinemaVO: CinemaVO){
        mCinemaVO = cinemaVO

        itemView.findViewById<TextView>(R.id.tv_cinemaName).text = cinemaVO.cinema
    }

}