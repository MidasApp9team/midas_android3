package com.example.data.local.preference

interface SignInPreference {

    suspend fun saveNum(num: String)
    suspend fun savePassword(password: String)

    suspend fun fetchNum(): String
    suspend fun fetchPassword(): String
}