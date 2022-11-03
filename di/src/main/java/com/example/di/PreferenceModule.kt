package com.example.di

import com.example.data.local.preference.SignInPreference
import com.example.data.local.preference.SignInPreferenceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class PreferenceModule {

    @Binds
    abstract fun bindSignInPreference(
        signInPreferenceImpl: SignInPreferenceImpl
    ): SignInPreference
}