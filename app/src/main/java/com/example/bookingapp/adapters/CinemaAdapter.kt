package com.example.bookingapp.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bookingapp.R
import com.example.bookingapp.data.VOs.CinemaVO
import com.example.bookingapp.delegate.CinemaViewHolderDelegate
import com.example.bookingapp.viewholders.CinemaViewHolder

class CinemaAdapter(private var delegate: CinemaViewHolderDelegate): RecyclerView.Adapter<CinemaViewHolder>() {

    private var mCinemaList : List<CinemaVO> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CinemaViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_holder_cinema,parent,false)
        return CinemaViewHolder(view,delegate)
    }

    override fun getItemCount(): Int {
       return mCinemaList.count()
    }

    override fun onBindViewHolder(holder: CinemaViewHolder, position: Int) {
       holder.bindData(mCinemaList[position])
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setNewData(cinemaList: List<CinemaVO>){
        mCinemaList = cinemaList
        notifyDataSetChanged()
    }
}