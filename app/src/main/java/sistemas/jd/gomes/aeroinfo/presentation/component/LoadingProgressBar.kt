package sistemas.jd.gomes.aeroinfo.presentation.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import sistemas.jd.gomes.aeroinfo.ui.theme.BlueDark

@Composable
fun LoadingProgressBar(color: Color = MaterialTheme.colors.BlueDark) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        CircularProgressIndicator(
            color = color
        )
    }
}