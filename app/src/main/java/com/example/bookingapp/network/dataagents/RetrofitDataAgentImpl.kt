package com.example.bookingapp.network.dataagents

import com.example.bookingapp.data.VOs.CinemaVO
import com.example.bookingapp.data.VOs.SeatVO
import com.example.bookingapp.network.BookingApi
import com.example.bookingapp.network.responses.CinemaAndShowTimeResponse
import com.example.bookingapp.network.responses.SeatingPlanResponse
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

    override fun getCinemaAndShowTimeByDate(
        onSuccess: (List<CinemaVO>) -> Unit,
        onFailure: (String) -> Unit
    ) {
        mBookingApi?.getCinemaAndShowTimeByDate()
            ?.enqueue(object : Callback<CinemaAndShowTimeResponse>{
                override fun onResponse(
                    call: Call<CinemaAndShowTimeResponse>,
                    response: Response<CinemaAndShowTimeResponse>
                ) {
                    if (response.isSuccessful){
                        onSuccess(response.body()?.data ?: listOf())
                    }
                    else{
                        onFailure(response.message())
                    }

                }

                override fun onFailure(call: Call<CinemaAndShowTimeResponse>, t: Throwable) {
                    onFailure(t.message ?: "")
                }

            })

    }

    override fun getSeatingPlanByShowTime(
        onSuccess: (List<List<SeatVO>>) -> Unit,
        onFailure: (String) -> Unit
    ) {
        mBookingApi?.getSeatingPlanByShowTime()
            ?.enqueue(object : Callback<SeatingPlanResponse>{
                override fun onResponse(
                    call: Call<SeatingPlanResponse>,
                    response: Response<SeatingPlanResponse>
                ) {
                    if (response.isSuccessful){

//                       onSuccess((response.body()?.data ?: listOf()) as List<SeatVO>)

//                        val list = response.body()?.data?.get(0) ?: listOf()
//                        onSuccess(list)

                        onSuccess(response.body()?.data?: listOf())


                    }else{
                        onFailure(response.message())

                    }
                }

                override fun onFailure(call: Call<SeatingPlanResponse>, t: Throwable) {
                   onFailure(t.message ?: "")
                }

            })
    }


}