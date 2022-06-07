package com.example.ageinminutes

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import com.example.ageinminutes.databinding.ActivityMainBinding
import java.text.SimpleDateFormat
import java.util.*


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        binding.btnDatePicker.setOnClickListener { view ->
            clickDatePicker(view)
        }





    }

    fun clickDatePicker(view: View){
        val myCalendar = Calendar.getInstance()
        val year = myCalendar.get(Calendar.YEAR)
        val month = myCalendar.get(Calendar.MONTH)
        val day = myCalendar.get(Calendar.DAY_OF_MONTH)
        DatePickerDialog(this,
            DatePickerDialog.OnDateSetListener {view, selectedYear, selectedMonth, selectedDayOfMonth ->
                Toast.makeText(this, "Date selected!", Toast.LENGTH_LONG).show()

                val selectedDate = "${selectedMonth+1}-$selectedDayOfMonth-$selectedYear"

                binding.tvSelectedDate.setText(selectedDate)

                val minutes = (year-selectedYear)*365*24*60 + (month-selectedMonth)*30*24*60 + (day-selectedDayOfMonth)*24*60

                binding.tvAgeInMinutes.setText("$minutes")

            },
            year,
            month,
            day
        ).show()

    }
}