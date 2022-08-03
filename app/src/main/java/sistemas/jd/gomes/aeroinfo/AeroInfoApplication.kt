package sistemas.jd.gomes.aeroinfo

import android.app.Application
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.ktx.Firebase
import dagger.hilt.android.HiltAndroidApp
import sistemas.jd.gomes.aeroinfo.util.AnalyticsManager

@HiltAndroidApp
class AeroInfoApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        AnalyticsManager().init(this)
    }
}