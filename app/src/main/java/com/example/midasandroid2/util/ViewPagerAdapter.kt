package com.example.midasandroid2.util

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.midasandroid2.bus.BusFragment
import com.example.midasandroid2.home.HomeFragment
import com.example.midasandroid2.main.MainFragment

class ViewPagerAdapter(fragment: FragmentActivity) : FragmentStateAdapter(fragment){
    override fun getItemCount(): Int = 3
    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> MainFragment()
            1-> HomeFragment()
            2 -> BusFragment()
            else -> MainFragment()
        }
    }
}