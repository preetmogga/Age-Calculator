package com.mogga.agecalculator

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var showDate:TextView
    private lateinit var showYear:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

   btnUpdate.setOnClickListener {
       printAge()
   }
    }


    @SuppressLint("SetTextI18n")
    private fun printAge() {
       val myCalendar = Calendar.getInstance()

        val currentYear =myCalendar.get(Calendar.YEAR)
        val currentMonth =myCalendar.get(Calendar.MONTH)
        val currentDay = myCalendar.get(Calendar.DAY_OF_MONTH)
        DatePickerDialog(this, { _, year, month, day ->
            val selectedDate = "$day/${month+1}/$year"
            showDate = findViewById(R.id.ageText)
            showYear = findViewById(R.id.yearText)
            showDate.text = selectedDate
            var finalYear = currentYear - year
            //2/1/2022      /3/1/2021
            if (currentDay <= day){
                finalYear--
                showYear.text = "Your Age is $finalYear "
            }else{
                showYear.text = "Your Age is $finalYear "

            }


        }
            ,currentYear
            ,currentMonth,
            currentDay).show()

    }
}