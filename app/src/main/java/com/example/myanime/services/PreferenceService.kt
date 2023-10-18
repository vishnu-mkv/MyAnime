package com.example.myanime.services

import android.content.Context
import android.content.SharedPreferences
import com.example.myanime.models.responses.LoginData
import com.google.gson.Gson
import java.util.UUID

class PreferenceService
    (context: Context){

    val preference = context.getSharedPreferences("MyAnime", Context.MODE_PRIVATE)

    // on constructor check if a value with device id exists
    // if not, create one
    val deviceIdKey = "deviceId"
    val loginDataKey = "loginData"

    var deviceId: String = ""
        get() = preference.getString(deviceIdKey, "") ?: ""
       private set;

    var loginData: LoginData? = null
        get() = run {
            val loginDataString = preference.getString(loginDataKey, "")
            if(loginDataString.isNullOrEmpty()) {
                null
            } else {
                Gson().fromJson(loginDataString, LoginData::class.java)
            }
        }
        private set;

    init {
        if (!preference.contains(deviceIdKey)) {
            val deviceId = UUID.randomUUID().toString()
            preference.edit().putString(deviceIdKey, deviceId).apply()
            this.deviceId = deviceId
        }
    }

    // given login data, save it to preference
    fun saveLoginData(loginData: LoginData) {
        // stringfy login data
        val loginDataString = Gson().toJson(loginData)
        // save it to preference
        preference.edit().putString(loginDataKey, loginDataString).apply()
    }

    fun logout() {
        preference.edit().remove(loginDataKey).apply()
    }
}