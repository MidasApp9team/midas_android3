package com.example.data.remote.response

import com.example.domain.param.SignInParam

data class SignInResponse(
    val accessToken: String,
    val refreshToken: String
)

fun SignInResponse.toParam() = SignInParam(
    accessToken = accessToken,
    refreshToken = refreshToken
)
