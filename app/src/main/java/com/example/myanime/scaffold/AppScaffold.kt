package com.example.myanime.scaffold

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.myanime.R
import com.example.myanime.screens.Screens
import com.example.myanime.viewmodel.UserViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppScaffold(
                navController: NavController,
                content: @Composable () -> Unit) {
    // a scaffold with bottom navigation bar

    Scaffold(
        bottomBar = { BottomBar(
            navController = navController,
        ) },
    ) {
        Box(Modifier.padding(it)
//            .verticalScroll(rememberScrollState())
        ) {
            content()
        }
    }
}

@Composable
fun BottomBar(navController: NavController,
              vm:UserViewModel = hiltViewModel()) {

    val navigate = { route: String ->
        if(!navController.popBackStack(route, inclusive = false)) {
            navController.navigate(route)
        }
    }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = Modifier.fillMaxWidth().background(MaterialTheme.colorScheme.surfaceTint)
            .padding(8.dp, 16.dp)
    ) {
        NavIcon(
            Icons.Filled.Home,
            contentDescription = "Characters",
            onClick = {
                navigate(Screens.HOME_SCREEN)
            }
        )

        NavIcon(ImageVector.vectorResource(R.drawable.baseline_local_movies_24),
            contentDescription = "Anime",
           onClick = {
                navigate(Screens.ANIME_SCREEN)
            }
        )

        NavIcon(
            Icons.Filled.ExitToApp,
            contentDescription = "Logout",
            onClick = {
                vm.logout()
            }
        )
    }
}

@Composable
fun NavIcon(
    icon: ImageVector,
    onClick: () -> Unit,
    contentDescription: String? = null
) {
    Icon(
        icon,
        contentDescription = contentDescription,
        modifier = Modifier.clickable(onClick = onClick),
        tint = MaterialTheme.colorScheme.surface
    )
}