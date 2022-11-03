package com.example.midasandroid2.main

import android.view.MenuItem
import androidx.viewpager2.widget.ViewPager2
import com.example.midasandroid2.R
import com.example.midasandroid2.base.BaseActivity
import com.example.midasandroid2.databinding.ActivityMainBinding
import com.example.midasandroid2.util.ViewPagerAdapter
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main), BottomNavigationView.OnNavigationItemSelectedListener{

    private lateinit var bottomNavigationView: BottomNavigationView

    override fun initView() {
        binding.run {
            pager.run {
                adapter = ViewPagerAdapter(this@MainActivity)
                registerOnPageChangeCallback(
                    object : ViewPager2.OnPageChangeCallback() {
                        override fun onPageSelected(position: Int) {
                            super.onPageSelected(position)
                            mainBottomNavigation.menu.getItem(position).isChecked = true
                        }
                    }
                )
            }
            mainBottomNavigation.setOnNavigationItemSelectedListener(this@MainActivity)

            bottomNavigationView = mainBottomNavigation
            bottomNavigationView.run {
                setOnNavigationItemSelectedListener(this@MainActivity)
                selectedItemId = R.id.menu_time
            }
        }
    }

    override fun observeEvent() {}

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        binding.run {
            when (item.itemId) {
                R.id.menu_time -> {
                    pager.currentItem = 0
                    return true
                }
                R.id.menu_home -> {
                    pager.currentItem = 1
                    return true
                }
                R.id.menu_bus -> {
                    pager.currentItem = 2
                    return true
                }
            }
            return false
        }

    }
}