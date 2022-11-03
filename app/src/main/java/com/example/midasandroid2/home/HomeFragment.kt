package com.example.midasandroid2.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.midasandroid2.R
import com.example.midasandroid2.base.BaseFragment
import com.example.midasandroid2.databinding.FragmentHomeBinding

class HomeFragment : BaseFragment<FragmentHomeBinding>(R.layout.fragment_home){
    override fun initView() {
        binding.run {
            btnPut.setOnClickListener {
                etHomeReason.setText("")
                showToast("재택 근무 신청이 완료 되었습니다!")
            }
        }
    }

    override fun observeEvent() {}

}