package sistemas.jd.gomes.aeroinfo.presentation.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun ErrorScreen(message: String?) {
    Box(modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
        content = {
            message?.let { Text(text = it) }
        }
    )
}