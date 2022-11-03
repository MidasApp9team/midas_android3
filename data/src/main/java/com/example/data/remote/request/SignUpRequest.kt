package com.example.data.remote.request

import com.example.domain.entity.SignUpEntity

data class SignUpRequest(
    val empnum: String,
    val email: String,
    val check: String,
    val password: String
)

fun SignUpEntity.toRequest() = SignUpRequest(
    empnum = empnum,
    email = email,
    check = check,
    password = password
)
