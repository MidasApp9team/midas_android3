package com.example.domain.usecase.sign

import com.example.domain.param.SignInParam
import com.example.domain.repository.SignRepository
import com.example.domain.usecase.UseCase
import javax.inject.Inject

class AutoLoginUseCase @Inject constructor(
    private val signRepository: SignRepository
): UseCase<Unit, SignInParam>(){
    override suspend fun execute(data: Unit) = signRepository.autoLogin()
}