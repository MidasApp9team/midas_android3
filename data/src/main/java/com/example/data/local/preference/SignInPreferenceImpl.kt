package com.example.data.local.preference

import android.content.SharedPreferences
import com.example.data.local.helper.SharedPreferenceHelper
import javax.inject.Inject

class SignInPreferenceImpl @Inject constructor(
    private val s: SharedPreferenceHelper
): SignInPreference {

    override suspend fun saveNum(num: String) {
        s.saveStringPreference(NUM,num)
    }

    override suspend fun savePassword(password: String) {
        s.saveStringPreference(PASSWORD,password)
    }

    override suspend fun fetchNum(): String =
        s.fetchStringPreference(NUM)

    override suspend fun fetchPassword(): String =
        s.fetchStringPreference(PASSWORD)

    companion object Key{
        const val NUM = "NUM"
        const val PASSWORD = "PASSWORD"
    }
}