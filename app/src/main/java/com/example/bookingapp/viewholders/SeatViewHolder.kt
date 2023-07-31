package com.example.bookingapp.viewholders

import android.annotation.SuppressLint
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.bookingapp.R
import com.example.bookingapp.data.VOs.SeatVos
import com.example.bookingapp.delegate.SeatViewHolderDelegate


@SuppressLint("ResourceAsColor")
class SeatViewHolder(itemView: View,private var delegate : SeatViewHolderDelegate) : RecyclerView.ViewHolder(itemView) {

    private var mSeat: SeatVos? = null

    init {
        itemView.setOnClickListener {
            mSeat?.let {
                delegate.onTapSeat(it.seatNumber)
            }
            itemView.background.setTint(R.color.black)

         }
        }


    fun bindData(seat : SeatVos) {
        mSeat = seat


    }
}





