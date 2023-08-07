package com.example.bookingapp.delegate

import com.example.bookingapp.data.VOs.TimeslotsVO

interface CinemaViewHolderDelegate {

    fun onTapCinema(cinema: String, timeslots: List<TimeslotsVO>)

}