package com.example.data.repository

import com.example.data.local.datasource.LocalSignInDataSource
import com.example.data.remote.datasource.RemoteSignInDataSource
import com.example.domain.entity.SignInEntity
import com.example.domain.entity.SignUpEntity
import com.example.domain.param.SignInParam
import com.example.domain.repository.SignRepository
import javax.inject.Inject

class SignRepositoryImpl @Inject constructor(
    private val remoteSignDataSource: RemoteSignInDataSource,
    private val localSignInDataSource: LocalSignInDataSource
): SignRepository {
    override suspend fun signIn(signInEntity: SignInEntity) =
        remoteSignDataSource.signIn(signInEntity)

    override suspend fun signUp(signUpEntity: SignUpEntity) =
        remoteSignDataSource.signUp(signUpEntity)

    override suspend fun autoLogin(): SignInParam {
        val signData = localSignInDataSource.autoLogin()
        return remoteSignDataSource.signIn(signData)
    }

    override suspend fun saveSign(signInEntity: SignInEntity) =
        localSignInDataSource.saveSign(signInEntity)
}