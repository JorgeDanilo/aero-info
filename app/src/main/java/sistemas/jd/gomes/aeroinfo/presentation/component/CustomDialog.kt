import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import coil.compose.rememberAsyncImagePainter
import com.mxalbert.zoomable.Zoomable

@Composable
fun CustomDialogScrollable(
    url: String? = "",
    onConfirmClicked: () -> Unit,
    onDismiss: () -> Unit
) {
    Scaffold(
        content = {
            val painter = rememberAsyncImagePainter(url)
            Zoomable {
                Image(
                    painter = painter,
                    contentDescription = null,
                    modifier = Modifier
                        .aspectRatio(0.5f)
                        .fillMaxSize()
                )
            }
        }
    )
}