package com.example.data.remote.datasource

import com.example.data.remote.api.SignAPI
import com.example.data.remote.request.toRequest
import com.example.data.remote.response.toParam
import com.example.domain.entity.SignInEntity
import com.example.domain.entity.SignUpEntity
import javax.inject.Inject

class RemoteSignInDataSourceImpl @Inject constructor(
    private val signAPI: SignAPI
): RemoteSignInDataSource {
    override suspend fun signIn(signInEntity: SignInEntity) =
        signAPI.signIn(signInEntity.toRequest()).toParam()

    override suspend fun signUp(signUpEntity: SignUpEntity) =
        signAPI.signUp(signUpEntity.toRequest())
}