package com.example.domain.repository

interface TimeRepository {
    suspend fun start(time: String)

    suspend fun finish(time: String)

    suspend fun date(date: String)

    suspend fun over()

    suspend fun getStart(): String?

    suspend fun getFinish(): String?

    suspend fun getDate(): String?
}