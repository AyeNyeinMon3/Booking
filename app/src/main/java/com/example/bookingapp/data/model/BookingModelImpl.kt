package com.example.bookingapp.data.model

import com.example.bookingapp.data.VOs.CinemaVO
import com.example.bookingapp.data.VOs.SeatVO
import com.example.bookingapp.data.VOs.SeatVos
import com.example.bookingapp.data.VOs.TimeslotsVO
import com.example.bookingapp.network.dataagents.BookingDataAgent
import com.example.bookingapp.network.dataagents.RetrofitDataAgentImpl

object BookingModelImpl : BookingModel{

    private var mBookingDataAgent : BookingDataAgent = RetrofitDataAgentImpl

    override fun getCinemaAndShowTimeByDate(
        onSuccess: (List<CinemaVO>) -> Unit,
        onFailure: (String) -> Unit
    ) {

        mBookingDataAgent.getCinemaAndShowTimeByDate(
            onSuccess,
            onFailure
        )

    }

    override fun getSeatingPlanByShowTime(
        onSuccess: (List<List<SeatVO>>) -> Unit,
        onFailure: (String) -> Unit
    ) {
       mBookingDataAgent.getSeatingPlanByShowTime(
           onSuccess,
           onFailure
       )
    }


}