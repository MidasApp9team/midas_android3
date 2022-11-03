package com.example.data.remote.datasource

import com.example.domain.entity.SignInEntity
import com.example.domain.entity.SignUpEntity
import com.example.domain.param.SignInParam

interface RemoteSignInDataSource {
    suspend fun signIn(signInEntity: SignInEntity): SignInParam

    suspend fun signUp(signUpEntity: SignUpEntity)
}