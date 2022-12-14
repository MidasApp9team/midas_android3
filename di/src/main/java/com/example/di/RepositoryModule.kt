package com.example.di

import com.example.data.repository.SignRepositoryImpl
import com.example.domain.repository.SignRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindSignInRepository(
        signInRepositoryImpl: SignRepositoryImpl
    ): SignRepository
}