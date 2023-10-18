package com.example.myanime.ui.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun FormButton(
    text: String,
    onClick: () -> Unit = {},
    enabled: Boolean = false,
    modifier: Modifier = Modifier,
    loading:Boolean = false
) {

    Button(
        onClick = onClick, enabled = enabled && !loading, shape = RoundedCornerShape(4.dp),
        modifier = modifier.fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.primary,
            contentColor = MaterialTheme.colorScheme.onPrimary,
            disabledContainerColor = MaterialTheme.colorScheme.inversePrimary,
            disabledContentColor = MaterialTheme.colorScheme.onPrimary,
        )
    ) {
        if (loading) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Loader()
                Text(text = "Please Wait", style = MaterialTheme.typography.bodyMedium)
            }
        } else {
            Text(text = text, style = MaterialTheme.typography.bodyMedium)
        }

    }
}