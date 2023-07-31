package com.example.bookingapp.network.dataagents

import com.example.bookingapp.data.VOs.CinemaVO
import com.example.bookingapp.data.VOs.TimeslotsVO

interface BookingDataAgent {

    fun getCinemaByDate(
        onSuccess:(List<CinemaVO>) -> Unit,
        onFailure:(String) -> Unit
    )

    fun getShowTimeByDate(
        onSuccess: (List<TimeslotsVO>) -> Unit,
        onFailure: (String) -> Unit
    )

}