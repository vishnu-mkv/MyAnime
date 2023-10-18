package com.example.myanime.forms.login

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.myanime.screens.Screens
import com.example.myanime.ui.common.ErrorMessage
import com.example.myanime.ui.common.ErrorText
import com.example.myanime.ui.common.FormButton
import com.example.myanime.ui.common.FormContainer
import com.example.myanime.ui.common.InputField
import com.example.myanime.viewmodel.LoginViewModel
import me.naingaungluu.formconductor.FieldResult
import me.naingaungluu.formconductor.FormResult
import me.naingaungluu.formconductor.composeui.field
import me.naingaungluu.formconductor.composeui.form


@Composable
fun LoginForm(
    vm: LoginViewModel = hiltViewModel()
) {

    FormContainer {
        form(LoginFormModel::class) {

            val loginUser = {
                val state = this.validate()

                if (state is FormResult.Success) {
                        vm.login(state.data)
                }
            }

            vm.errorMessage.let {
                if (it.isNotEmpty()) {
                    ErrorMessage(text = it)
                }
            }

            field(LoginFormModel::emailAddress) {
                InputField(
                    value = state.value?.value.orEmpty(),
                    onValueChange = this::setField,
                    isError = resultState.value is FieldResult.Error,
                    label = "Email Address"
                )

                this.resultState.value.let {
                    if (it is FieldResult.Error) {
                        ErrorText(text = it.message)
                    }
                }
            }

            field(LoginFormModel::password) {
                InputField(
                    value = state.value?.value.orEmpty(),
                    onValueChange = this::setField,
                    isError = resultState.value is FieldResult.Error,
                    visualTransformation = PasswordVisualTransformation(),
                    label = "Password"
                )

                this.resultState.value.let {
                    if (it is FieldResult.Error) {
                        ErrorText(text = it.message)
                    }
                }
            }

            FormButton(
                text = "Login", enabled = this.formState.value is FormResult.Success,
                onClick = loginUser,
                loading = vm.isLoading
            )
        }
    }
}