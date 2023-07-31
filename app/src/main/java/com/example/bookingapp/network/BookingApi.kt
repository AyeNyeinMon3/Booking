package com.example.bookingapp.network

import com.example.bookingapp.data.VOs.CinemaVO
import com.example.bookingapp.network.responses.BookingResponse
import com.example.bookingapp.utils.API_GET_CINEMA_AND_SHOWTIME_BY_DATE
import com.example.bookingapp.utils.AUTHORIZATION
import com.example.bookingapp.utils.PARAM_DATE
import com.example.bookingapp.utils.TOKEN
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query


interface BookingApi {

    @GET(API_GET_CINEMA_AND_SHOWTIME_BY_DATE)
    fun getCinemaByDate(
        @Header(AUTHORIZATION) token : String = TOKEN,
        @Query(PARAM_DATE) date : String = "2022-9-22"
    ):Call<BookingResponse>

    @GET(API_GET_CINEMA_AND_SHOWTIME_BY_DATE)
    fun getShowTimeByDate(
        @Header(AUTHORIZATION) token : String = TOKEN,
        @Query(PARAM_DATE) date : String = "2022-9-22"
    ):Call<CinemaVO>


}