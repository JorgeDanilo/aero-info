package sistemas.jd.gomes.aeroinfo.presentation.detail.info.rotaer

import android.annotation.SuppressLint
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import coil.compose.AsyncImage
import sistemas.jd.gomes.aeroinfo.R
import sistemas.jd.gomes.aeroinfo.util.SearchDTO

@SuppressLint("SetJavaScriptEnabled")
@Composable
fun InfoRotaerScreen() {
    val url = "https://aisweb.decea.mil.br/?i=aerodromos&codigo=${SearchDTO.icaoCode}#rotaer"

    AndroidView(factory = {
        WebView(it).apply {
            this.settings.javaScriptEnabled = true

            webViewClient = object  : WebViewClient() {
                override fun onPageFinished(view: WebView?, url: String?) {
                    loadUrl("javascript:document.getElementById('barra_decea').remove();\n" +
                            "javascript:document.querySelectorAll('.header-body').forEach(el => el.remove());\n" +
                            "javascript:document.querySelectorAll('.page-header').forEach(el => el.remove());\n" +
                            "javascript:document.querySelectorAll('.btn-group').forEach(el => el.remove());\n" +
                            "javascript:document.querySelectorAll('.popup-external').forEach(el => el.remove());\n" +
                            "javascript:document.querySelectorAll('.notam').forEach(el => el.remove());\n" +
                            "javascript:document.querySelectorAll('.dashed').forEach(el => el.remove());\n" +
                            "javascript:document.querySelectorAll('#sup').forEach(el => el.remove());\n" +
                            "javascript:document.querySelectorAll('.inverted').forEach(el => el.remove());\n" +
                            "javascript:document.querySelectorAll('.col-lg-4').forEach(el => el.remove());\n" +
                            "javascript:document.getElementById('footer').remove();")
                }
            }
            loadUrl(url)
        }
    })
}