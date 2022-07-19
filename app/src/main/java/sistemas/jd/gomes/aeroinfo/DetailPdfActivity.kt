package sistemas.jd.gomes.aeroinfo

import android.os.Bundle
import androidx.activity.ComponentActivity
import com.github.barteksc.pdfviewer.PDFView
import dagger.hilt.android.AndroidEntryPoint
import sistemas.jd.gomes.aeroinfo.util.SearchDTO


@AndroidEntryPoint
class DetailPdfActivity : ComponentActivity() {

    private lateinit var mPdfView: PDFView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_pdf)
        mPdfView = findViewById(R.id.pdfView)
        mPdfView.fromStream(SearchDTO.inputStreamChart)
            .enableSwipe(true)
            .enableDoubletap(true)
            .load()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}