package com.example.myanime.forms.signup

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.myanime.forms.login.LoginFormModel
import com.example.myanime.screens.Screens
import com.example.myanime.ui.common.ErrorText
import com.example.myanime.ui.common.FormButton
import com.example.myanime.ui.common.FormContainer
import com.example.myanime.ui.common.InputField
import com.example.myanime.viewmodel.LoginViewModel
import kotlinx.coroutines.launch
import me.naingaungluu.formconductor.FieldResult
import me.naingaungluu.formconductor.FormResult
import me.naingaungluu.formconductor.composeui.field
import me.naingaungluu.formconductor.composeui.form

@Composable
fun SignupForm(
    vm: LoginViewModel = hiltViewModel()
) {

    FormContainer {
        form(SignupFormModel::class) {

            val signupUser = {
                val state = this.validate()

                if (state is FormResult.Success) {
                        vm.signup(state.data)

                }
            }

            vm.errorMessage.let {
                if (it.isNotEmpty()) {
                    ErrorText(text = it)
                }
            }

            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
            ) {

                Column(
                    modifier = Modifier.weight(1f),
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                ) {
                    field(SignupFormModel::firstName) {
                        InputField(
                            value = state.value?.value.orEmpty(),
                            onValueChange = this::setField,
                            isError = resultState.value is FieldResult.Error,
                            label = "First Name"
                        )

                        this.resultState.value.let {
                            if (it is FieldResult.Error) {
                                ErrorText(text = it.message)
                            }
                        }
                    }
                }

                Column(
                    modifier = Modifier.weight(1f),
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                ) {
                    field(SignupFormModel::lastName) {

                        InputField(
                            value = state.value?.value.orEmpty(),
                            onValueChange = this::setField,
                            isError = resultState.value is FieldResult.Error,
                            label = "Last Name"
                        )

                        this.resultState.value.let {
                            if (it is FieldResult.Error) {
                                ErrorText(text = it.message)
                            }
                        }
                    }
                }
            }

            field(SignupFormModel::emailAddress) {
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

            field(SignupFormModel::password) {

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
                text = "Sign Up", enabled = this.formState.value is FormResult.Success,
                onClick = signupUser,
                loading = vm.isLoading
            )
        }
    }
}