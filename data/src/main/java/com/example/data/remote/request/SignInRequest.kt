package com.example.data.remote.request

import com.example.domain.entity.SignInEntity

data class SignInRequest(
    val empnum: String,
    val password: String
)

fun SignInEntity.toRequest() = SignInRequest(
    empnum = empnum,
    password = password
)
