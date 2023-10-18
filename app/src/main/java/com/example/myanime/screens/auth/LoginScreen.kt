package com.example.myanime.screens.auth

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.myanime.forms.login.LoginForm
import com.example.myanime.screens.Screens
import com.example.myanime.ui.common.LogoHeader

@Composable
fun LoginScreen(
    navController: NavController
) {

    Column(modifier= Modifier
        .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(32.dp, Alignment.CenterVertically),
       ) {

        LogoHeader(subtitle = "Please login to continue")
        LoginForm()
        Row(
            horizontalArrangement = Arrangement.spacedBy(5.dp, Alignment.CenterHorizontally),
        ) {
            Text(text = "Don't have an account?",
                color = MaterialTheme.colorScheme.surfaceVariant)
            Text(text = "Sign up", style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.primary,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.clickable(onClick = {
                    navController.navigate(Screens.SIGNUP_SCREEN)
                }) // navigate to signup screen
            )
        }
    }
}