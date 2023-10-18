package com.example.myanime.viewmodel

import android.content.SharedPreferences
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.myanime.services.PreferenceService
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    val preferenceService: PreferenceService
) : ViewModel(){
    var user by mutableStateOf(preferenceService.loginData?.user)
        private set

    var isLoggedIn = {
        preferenceService.loginData != null
    }

    val logout = preferenceService::logout

    private val listener = SharedPreferences.OnSharedPreferenceChangeListener { sharedPreferences, key ->
        run {
            if (key == preferenceService.loginDataKey) {
                user = preferenceService.loginData?.user
            }
        }
    }

    init {
        preferenceService.preference.registerOnSharedPreferenceChangeListener(listener)
    }

    override fun onCleared() {
        super.onCleared()
        preferenceService.preference.unregisterOnSharedPreferenceChangeListener(listener)
    }
}