package sistemas.jd.gomes.aeroinfo.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun ErrorScreen(message: String?) {
    Box(modifier = Modifier.fillMaxSize().background(Color.White),
        contentAlignment = Alignment.Center,
        content = {
            message?.let { Text(text = it) }
        }
    )
}

@Composable
@Preview
fun ErrorScreenView() {
    ErrorScreen(message = "Erro de conexão")
}