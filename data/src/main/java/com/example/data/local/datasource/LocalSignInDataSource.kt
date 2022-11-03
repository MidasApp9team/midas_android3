package com.example.data.local.datasource

import com.example.domain.entity.SignInEntity

interface LocalSignInDataSource {
    suspend fun autoLogin(): SignInEntity

    suspend fun saveSign(signInEntity: SignInEntity)
}