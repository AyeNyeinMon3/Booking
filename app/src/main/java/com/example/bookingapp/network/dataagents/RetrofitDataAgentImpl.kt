package com.example.bookingapp.network.dataagents

import com.example.bookingapp.data.VOs.CinemaVO
import com.example.bookingapp.data.VOs.TimeslotsVO
import com.example.bookingapp.network.BookingApi
import com.example.bookingapp.network.responses.BookingResponse
import com.example.bookingapp.utils.BASE_URL
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitDataAgentImpl:BookingDataAgent {

    private var mBookingApi : BookingApi? = null

    init {
        val mOkHttpClient = OkHttpClient.Builder()
            .connectTimeout(15,TimeUnit.SECONDS)
            .readTimeout(15,TimeUnit.SECONDS)
            .writeTimeout(15,TimeUnit.SECONDS)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(mOkHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        mBookingApi = retrofit.create(BookingApi::class.java)
    }


    override fun getCinemaByDate(onSuccess: (List<CinemaVO>) -> Unit, onFailure: (String) -> Unit) {
        mBookingApi?.getCinemaByDate()
            ?.enqueue(object : Callback<BookingResponse>{
                override fun onResponse(
                    call: Call<BookingResponse>,
                    response: Response<BookingResponse>
                ) {
                    if (response.isSuccessful){
                        onSuccess(response.body()?.data ?: listOf())
                    }
                    else{
                        onFailure(response.message())
                    }

                }

                override fun onFailure(call: Call<BookingResponse>, t: Throwable) {
                    onFailure(t.message ?: "")
                }

            })

    }

    override fun getShowTimeByDate(
        onSuccess: (List<TimeslotsVO>) -> Unit,
        onFailure: (String) -> Unit
    ) {
        mBookingApi?.getShowTimeByDate()
            ?.enqueue(object : Callback<CinemaVO>{
                override fun onResponse(call: Call<CinemaVO>, response: Response<CinemaVO>) {
                    if (response.isSuccessful){

                        onSuccess(response.body()?.timeslots ?: listOf())

                    }else{
                        onFailure(response.message())
                    }
                }

                override fun onFailure(call: Call<CinemaVO>, t: Throwable) {
                    onFailure(t.message ?: " ")
                }

            })
    }
}