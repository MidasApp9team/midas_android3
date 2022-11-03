package com.example.domain.usecase.sign

import com.example.domain.entity.SignInEntity
import com.example.domain.param.SignInParam
import com.example.domain.repository.SignRepository
import com.example.domain.usecase.UseCase
import javax.inject.Inject

class SignInUseCase @Inject constructor(
    private val signRepository: SignRepository
): UseCase<SignInEntity, SignInParam>(){
    override suspend fun execute(data: SignInEntity) = signRepository.signIn(data)
}