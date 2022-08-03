package sistemas.jd.gomes.aeroinfo.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import coil.compose.rememberAsyncImagePainter
import com.mxalbert.zoomable.Zoomable
import dagger.hilt.android.AndroidEntryPoint
import sistemas.jd.gomes.aeroinfo.util.SearchDTO

@AndroidEntryPoint
class SigwxActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val painter = rememberAsyncImagePainter(SearchDTO.urlChartSigwx)
            Zoomable {
                Image(
                    painter = painter,
                    contentDescription = null,
                    modifier = Modifier
                        .aspectRatio(1.0f)
                        .fillMaxSize()
                )
            }
        }
    }
}