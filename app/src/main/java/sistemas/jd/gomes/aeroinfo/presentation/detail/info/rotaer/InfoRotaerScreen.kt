package sistemas.jd.gomes.aeroinfo.presentation.detail.info.rotaer

import android.annotation.SuppressLint
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.runtime.Composable
import androidx.compose.ui.viewinterop.AndroidView
import sistemas.jd.gomes.aeroinfo.presentation.component.LoadingProgressBar
import sistemas.jd.gomes.aeroinfo.util.SearchDTO

@SuppressLint("SetJavaScriptEnabled")
@Composable
fun InfoRotaerScreen() {
    LoadingProgressBar()
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