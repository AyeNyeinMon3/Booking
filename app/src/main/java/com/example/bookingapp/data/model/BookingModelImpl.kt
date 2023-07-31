package com.example.bookingapp.data.model

import com.example.bookingapp.data.VOs.CinemaVO
import com.example.bookingapp.data.VOs.SeatVos
import com.example.bookingapp.data.VOs.TimeslotsVO
import com.example.bookingapp.network.dataagents.BookingDataAgent
import com.example.bookingapp.network.dataagents.RetrofitDataAgentImpl

object BookingModelImpl : BookingModel{

    private var mBookingDataAgent : BookingDataAgent = RetrofitDataAgentImpl

    override fun getCinemaByDate(
        onSuccess: (List<CinemaVO>) -> Unit,
        onFailure: (String) -> Unit
    ) {

        mBookingDataAgent.getCinemaByDate(
            onSuccess,
            onFailure
        )

    }

    override fun getShowTimeByDate(
        onSuccess: (List<TimeslotsVO>) -> Unit,
        onFailure: (String) -> Unit
    ) {
        mBookingDataAgent.getShowTimeByDate(
            onSuccess,
            onFailure
        )
    }
}