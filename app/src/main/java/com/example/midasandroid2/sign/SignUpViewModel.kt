package com.example.midasandroid2.sign

import com.example.domain.entity.SignUpEntity
import com.example.domain.exception.BadRequestException
import com.example.domain.usecase.sign.SignUpUseCase
import com.example.midasandroid2.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val signUpUseCase: SignUpUseCase
): BaseViewModel<SignUpViewModel.Event>() {

    fun signUp(signUpEntity: SignUpEntity) = execute(
        job = { signUpUseCase.execute(signUpEntity) },
        onSuccess = { emitEvent(Event.Success) },
        onFailure = {
            when(it) {
                is BadRequestException -> emitEvent(Event.BadRequest)
            }
        }
    )

    sealed class Event{
        object Success: Event()
        object BadRequest : Event()
    }
}