package com.example.bookingapp.network

import com.example.bookingapp.data.VOs.SeatVO
import com.example.bookingapp.network.responses.CinemaAndShowTimeResponse
import com.example.bookingapp.network.responses.SeatingPlanResponse
import com.example.bookingapp.utils.API_GET_CINEMA_AND_SHOWTIME_BY_DATE
import com.example.bookingapp.utils.API_GET_SEATING_PLAN_BY_SHOW_TIME
import com.example.bookingapp.utils.AUTHORIZATION
import com.example.bookingapp.utils.PARAM_DATE
import com.example.bookingapp.utils.TOKEN
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query


interface BookingApi {

    @GET(API_GET_CINEMA_AND_SHOWTIME_BY_DATE)
    fun getCinemaAndShowTimeByDate(
        @Header(AUTHORIZATION) token : String = TOKEN,
        @Query(PARAM_DATE) date : String = "2022-9-22"
    ):Call<CinemaAndShowTimeResponse>

    @GET(API_GET_SEATING_PLAN_BY_SHOW_TIME)
    fun getSeatingPlanByShowTime(
        @Header(AUTHORIZATION) token: String = TOKEN,
        @Query("cinema_day_timeslot_id") cinema_day_timeslot_id : Int = 7 ,
        @Query("booking_date") booking_date : String = "2022-08-18"
    ):Call<SeatingPlanResponse>


}