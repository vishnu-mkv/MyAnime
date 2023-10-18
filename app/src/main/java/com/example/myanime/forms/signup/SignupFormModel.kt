package com.example.myanime.forms.signup

import me.naingaungluu.formconductor.annotations.EmailAddress
import me.naingaungluu.formconductor.annotations.Form
import me.naingaungluu.formconductor.annotations.MaxLength
import me.naingaungluu.formconductor.annotations.MinLength

@Form
data class SignupFormModel(
    @EmailAddress
    val emailAddress: String = "mkv1722@gmail.com",

    @MinLength(6)
    val password: String = "adminuser",

    @MinLength(2)
    @MaxLength(20)
    val firstName: String = "Vishnu",

    @MinLength(2)
    @MaxLength(20)
    val lastName: String = "Mk"
)