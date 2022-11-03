package com.example.data.remote.api

import com.example.data.remote.request.SignInRequest
import com.example.data.remote.request.SignUpRequest
import com.example.data.remote.response.SignInResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface SignAPI {

    @POST("user/signin.do")
    suspend fun signIn(
        @Body signInRequest: SignInRequest
    ): SignInResponse

    @POST("user/signup.do")
    suspend fun signUp(
        @Body signUpRequest: SignUpRequest
    )
}