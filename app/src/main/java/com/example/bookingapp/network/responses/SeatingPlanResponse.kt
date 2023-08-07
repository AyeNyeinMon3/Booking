package com.example.bookingapp.network.responses

import com.example.bookingapp.data.VOs.CinemaVO
import com.example.bookingapp.data.VOs.SeatVO
import com.google.gson.annotations.SerializedName

data class SeatingPlanResponse (

    @SerializedName("code")
    val code : Int,

    @SerializedName("message")
    val message : String,

    @SerializedName("data")
    val data : List<List<SeatVO>>,

    )