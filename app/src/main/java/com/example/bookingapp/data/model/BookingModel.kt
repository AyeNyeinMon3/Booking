package com.example.bookingapp.data.model

import com.example.bookingapp.data.VOs.CinemaVO
import com.example.bookingapp.data.VOs.SeatVO
import com.example.bookingapp.data.VOs.SeatVos
import com.example.bookingapp.data.VOs.TimeslotsVO
import com.example.bookingapp.network.dataagents.BookingDataAgent
import com.example.bookingapp.network.dataagents.RetrofitDataAgentImpl

interface BookingModel {




    fun getCinemaAndShowTimeByDate(
        onSuccess : (List<CinemaVO>) -> Unit,
        onFailure : (String) -> Unit
    )

    fun getSeatingPlanByShowTime(
        onSuccess: (List<List<SeatVO>>) -> Unit,
        onFailure: (String) -> Unit
    )




}