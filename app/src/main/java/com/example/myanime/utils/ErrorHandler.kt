package com.example.myanime.utils

import com.example.myanime.models.responses.ErrorResponse
import com.google.gson.Gson
import retrofit2.Response

class ErrorHandler {

    companion object {
        fun getErrorMessage(response:Response<*>): String {
            val error = Gson().fromJson(
                response.errorBody()?.string(),
                ErrorResponse::class.java
            )
            return error.error.let {
                // get a key from the map
                val key = it?.keys?.firstOrNull()
                if (key != null) {
                  it.getValue(key)
                }
                else {
                    error.message
                }
            }
        }
    }
}