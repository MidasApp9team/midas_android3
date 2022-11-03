package com.example.midasandroid2.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.domain.repository.TimeRepository
import com.example.midasandroid2.base.BaseViewModel
import com.example.midasandroid2.main.compose.time
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
): ViewModel() {
}