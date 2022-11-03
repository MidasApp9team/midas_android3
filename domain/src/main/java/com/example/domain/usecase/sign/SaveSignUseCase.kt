package com.example.domain.usecase.sign

import com.example.domain.entity.SignInEntity
import com.example.domain.repository.SignRepository
import com.example.domain.usecase.UseCase
import javax.inject.Inject

class SaveSignUseCase @Inject constructor(
    private val signRepository: SignRepository
): UseCase<SignInEntity,Unit>() {
    override suspend fun execute(data: SignInEntity) = signRepository.saveSign(data)
}