package com.example.bookingapp.viewholders

import android.annotation.SuppressLint
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.bookingapp.R
import com.example.bookingapp.data.VOs.SeatVO
import com.example.bookingapp.delegate.SeatViewHolderDelegate


@SuppressLint("ResourceAsColor")
class SeatViewHolder(itemView: View,private var delegate : SeatViewHolderDelegate) : RecyclerView.ViewHolder(itemView) {

    private var mSeat: SeatVO? = null

    init {
        itemView.setOnClickListener {
            mSeat?.let {
                delegate.onTapSeat(it.seatName)
            }
            itemView.background.setTint(R.color.black)

         }
        }


//    fun bindData(seat: List<SeatVO>) {
//        mSeat = seat
//
//
//    }
}





