package com.example.di

import com.example.data.local.datasource.LocalSignInDataSource
import com.example.data.local.datasource.LocalSignInDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class LocalDataSourceModule {

    @Binds
    abstract fun bindLocalSignInDataSource(
        localSignInDataSourceImpl: LocalSignInDataSourceImpl
    ): LocalSignInDataSource

}