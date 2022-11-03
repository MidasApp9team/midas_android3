package com.example.domain.repository

import com.example.domain.entity.SignInEntity
import com.example.domain.entity.SignUpEntity
import com.example.domain.param.SignInParam

interface SignRepository {

    suspend fun signIn(signInEntity: SignInEntity): SignInParam

    suspend fun signUp(signUpEntity: SignUpEntity)

    suspend fun autoLogin(): SignInParam

    suspend fun saveSign(signInEntity: SignInEntity)
}