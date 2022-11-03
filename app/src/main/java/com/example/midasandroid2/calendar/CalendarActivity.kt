package com.example.midasandroid2.calendar

import com.example.midasandroid2.R
import com.example.midasandroid2.base.BaseActivity
import com.example.midasandroid2.databinding.ActivityCalendarBinding

class CalendarActivity : BaseActivity<ActivityCalendarBinding>(R.layout.activity_calendar){
    override fun initView() {
        binding.run {
            btnBack.setOnClickListener {
                finish()
            }
        }
    }

    override fun observeEvent() {}

}