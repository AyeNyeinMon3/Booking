package com.example.bookingapp.network.dataagents

import com.example.bookingapp.data.VOs.CinemaVO
import com.example.bookingapp.data.VOs.SeatVO

interface BookingDataAgent {

    fun getCinemaAndShowTimeByDate(
        onSuccess:(List<CinemaVO>) -> Unit,
        onFailure:(String) -> Unit
    )

    fun getSeatingPlanByShowTime(
        onSuccess: (List<List<SeatVO>>) -> Unit,
        onFailure: (String) -> Unit
    )

}