package com.example.midasandroid2.splash

import com.example.domain.usecase.sign.AutoLoginUseCase
import com.example.midasandroid2.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel

//@HiltViewModel
//class SplashViewModel(
//    private val autoLoginUseCase: AutoLoginUseCase
//): BaseViewModel<SplashViewModel.Event>() {
//
//    fun autoLogin() = execute(
//        job = { autoLoginUseCase },
//        onSuccess = { emitEvent(Event.Success) },
//        onFailure = { emitEvent(Event.Fail) }
//    )
//    sealed class Event{
//        object Success: Event()
//        object Fail: Event()
//    }
//}