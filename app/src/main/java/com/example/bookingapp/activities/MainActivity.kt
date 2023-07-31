package com.example.bookingapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bookingapp.adapters.CinemaAdapter
import com.example.bookingapp.adapters.DateAdapter
import com.example.bookingapp.adapters.SeatAdapter
import com.example.bookingapp.adapters.TimeAdapter
import com.example.bookingapp.data.VOs.CinemaVO
import com.example.bookingapp.data.VOs.DateVos
import com.example.bookingapp.data.model.BookingModel
import com.example.bookingapp.data.model.BookingModelImpl
import com.example.bookingapp.databinding.ActivityMainBinding
import com.example.bookingapp.delegate.CinemaViewHolderDelegate
import com.example.bookingapp.delegate.SeatViewHolderDelegate
import com.example.bookingapp.delegate.TimeViewHolderDelegate
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class MainActivity : AppCompatActivity(),SeatViewHolderDelegate,CinemaViewHolderDelegate,TimeViewHolderDelegate {

    lateinit var binding: ActivityMainBinding

    lateinit var mSeatAdapter: SeatAdapter
    lateinit var mDateAdapter: DateAdapter
    lateinit var mTimeAdapter: TimeAdapter
    lateinit var mCinemaAdapter: CinemaAdapter

    private var mBookingModel : BookingModel = BookingModelImpl

    private var dateList : MutableList<DateVos> = mutableListOf()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpRecyclerView()
        generateUnlimitedDates()
        requestData()

    }

    private fun requestData() {
        mBookingModel.getCinemaByDate(
            onSuccess = {
                mCinemaAdapter.setNewData(it)

            },
            onFailure = {

            })

        mBookingModel.getShowTimeByDate(
            onSuccess = {
                mTimeAdapter.setNewData(it)
            },
            onFailure = {

            }
        )
    }

    private fun setUpRecyclerView() {
        mSeatAdapter = SeatAdapter(this)
        binding.rvSeat.adapter = mSeatAdapter
//        mSeatAdapter.setNewData(dummySeatList)

        mDateAdapter = DateAdapter(dateList)
        binding.rvDate.adapter = mDateAdapter

        mCinemaAdapter = CinemaAdapter(this)
        binding.rvCinema.adapter = mCinemaAdapter


        mTimeAdapter = TimeAdapter(this)
        binding.rvTime.adapter = mTimeAdapter
    }

    private fun generateUnlimitedDates() {
        val calendar = Calendar.getInstance()
        val dateFormat = SimpleDateFormat("dd", Locale.getDefault())
        val monthFormat = SimpleDateFormat("MMM",Locale.getDefault())
        val dayNameFormat = SimpleDateFormat("EEE", Locale.getDefault())

        // Add dates to the dateList as per your requirement
        for (i in 0 until 100) {
            // You can set any desired number of dates
            dateList.add(DateVos(dateFormat.format(calendar.time),monthFormat.format(calendar.time),dayNameFormat.format(calendar.time)))




            calendar.add(Calendar.DAY_OF_MONTH, 1)
        }
    }

    override fun onTapSeat(seatNumber: String) {
//        Toast.makeText(this,"$seatId",Toast.LENGTH_SHORT).show()
        binding.tvSeatNumber.text = seatNumber
    }

    override fun onTapCinema(cinema: String) {
        binding.tvCinema.text = cinema
    }

    override fun onTapTime(startTime: String) {
        binding.tvShowTime.text = startTime
    }


}