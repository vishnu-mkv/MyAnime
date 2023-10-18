package com.example.myanime.forms.login

import me.naingaungluu.formconductor.annotations.EmailAddress
import me.naingaungluu.formconductor.annotations.Form
import me.naingaungluu.formconductor.annotations.MinLength

@Form
data class LoginFormModel(

    @EmailAddress
    val emailAddress: String = "",

    @MinLength(3)
    val password: String = ""
)