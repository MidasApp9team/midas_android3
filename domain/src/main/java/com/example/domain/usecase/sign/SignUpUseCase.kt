package com.example.domain.usecase.sign

import com.example.domain.entity.SignUpEntity
import com.example.domain.repository.SignRepository
import com.example.domain.usecase.UseCase
import javax.inject.Inject

class SignUpUseCase @Inject constructor(
    private val signRepository: SignRepository
): UseCase<SignUpEntity,Unit>() {
    override suspend fun execute(data: SignUpEntity) = signRepository.signUp(data)
}