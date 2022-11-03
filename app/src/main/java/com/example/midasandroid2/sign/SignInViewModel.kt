package com.example.midasandroid2.sign

import android.util.Log
import com.example.domain.entity.SignInEntity
import com.example.domain.exception.BadRequestException
import com.example.domain.exception.NotFoundException
import com.example.domain.exception.ServerException
import com.example.domain.param.SignInParam
import com.example.domain.usecase.sign.SaveSignUseCase
import com.example.domain.usecase.sign.SignInUseCase
import com.example.midasandroid2.base.BaseViewModel
import com.example.midasandroid2.util.ACCESS_TOKEN
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(
    private val signInUseCase: SignInUseCase,
    private val saveSignUseCase: SaveSignUseCase
) : BaseViewModel<SignInViewModel.Event>() {

    fun signIn(signInEntity: SignInEntity) = execute(
        job = { signInUseCase.execute(signInEntity) },
        onSuccess = {
            emitEvent(Event.Success)
            ACCESS_TOKEN = "Bearer " + it.accessToken
            Log.d("TAG", "ACCESS_TOKEN: $ACCESS_TOKEN")
        },
        onFailure = {
            when (it) {
                is BadRequestException -> emitEvent(Event.BadRequest)
                is NotFoundException -> emitEvent(Event.NotFound)
                is ServerException -> emitEvent(Event.Server)
            }
        }
    )

    fun saveSign(signInEntity: SignInEntity) = execute(
        job = { saveSignUseCase.execute(signInEntity) },
        onSuccess = {},
        onFailure = {}
    )

    sealed class Event {
        object Success : Event()
        object BadRequest : Event()
        object NotFound : Event()
        object Server : Event()
    }
}