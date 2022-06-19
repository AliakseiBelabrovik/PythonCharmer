package com.example.pythoncharmer.widgets

import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.pythoncharmer.R

@Composable
fun AlertDialogFinished(
    show : Boolean,
    onConfirm: () -> Unit,
) {
    if (show) {
        AlertDialog(
            onDismissRequest = onConfirm,
            title = {
                Text(text = stringResource(id = R.string.alert_dialog_title))
            },
            text = {
                Text(text = stringResource(id = R.string.alert_dialog_text))
            },
            confirmButton = {
                Button(
                    onClick = {
                        onConfirm()
                    }
                ) {
                    Text(
                        text = stringResource(id = R.string.confirm_alert_dialog)
                    )
                }
            },
        )
    }
}