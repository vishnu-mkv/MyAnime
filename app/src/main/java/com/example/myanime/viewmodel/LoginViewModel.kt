package com.example.myanime.viewmodel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.myanime.forms.login.LoginFormModel
import com.example.myanime.forms.signup.SignupFormModel
import com.example.myanime.models.requests.LoginRequest
import com.example.myanime.models.requests.SignupRequest
import com.example.myanime.models.responses.ErrorResponse
import com.example.myanime.models.responses.LoginResponse
import com.example.myanime.services.AuthService
import com.example.myanime.services.PreferenceService
import com.example.myanime.utils.ErrorHandler
import com.google.gson.Gson
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val preferenceService: PreferenceService,
    private val authService: AuthService
): ViewModel() {

    // loading
    var isLoading: Boolean by mutableStateOf(false)
        private set

    var errorMessage: String by mutableStateOf("")
        private set

    var isActionSuccess by mutableStateOf(false)
        private set

    fun login(loginFormModel: LoginFormModel) {

        isLoading = true
        errorMessage = ""

        val loginRequest = LoginRequest(
            loginFormModel.emailAddress,
            loginFormModel.password,
            preferenceService.deviceId
        )


        val call = authService.login(loginRequest)

        call.enqueue(object : Callback<LoginResponse> {
            override fun onResponse(
                call: Call<LoginResponse>,
                response: Response<LoginResponse>
            ) {
                if (response.isSuccessful) {
                    preferenceService.saveLoginData(response.body()!!.data)
                    isActionSuccess = true
                }
                else {
                    errorMessage = ErrorHandler.getErrorMessage(response)
                }
                isLoading = false
            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                errorMessage = t.message.toString()
                isLoading = false
            }
        })
    }

    fun signup(signupFormModel: SignupFormModel) {

        isLoading = true
        errorMessage = ""

        val signupRequest = SignupRequest(
            signupFormModel.firstName,
            signupFormModel.lastName,
            signupFormModel.emailAddress,
            signupFormModel.password,
            preferenceService.deviceId,
        )

        val call = authService.signup(signupRequest)

        call.enqueue(
            object : Callback<LoginResponse> {
                override fun onResponse(
                    call: Call<LoginResponse>,
                    response: Response<LoginResponse>
                ) {
                    if (response.isSuccessful) {
                        preferenceService.saveLoginData(response.body()!!.data)
                        isActionSuccess = true
                    }
                    else {
                        errorMessage = ErrorHandler.getErrorMessage(response)
                    }
                    isLoading = false
                }

                override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                    errorMessage = t.message.toString()
                    isLoading = false
                }
            }
        )

        isLoading = false
    }
}