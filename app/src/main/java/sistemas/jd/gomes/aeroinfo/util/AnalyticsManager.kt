package sistemas.jd.gomes.aeroinfo.util

import android.content.Context
import android.os.Bundle
import com.google.firebase.analytics.FirebaseAnalytics

class AnalyticsManager {


    fun init(context: Context) {
        firebaseAnalytics = FirebaseAnalytics.getInstance(context)
    }

    companion object {
        private lateinit var firebaseAnalytics: FirebaseAnalytics

        fun trackEvent(name: String, key: String, value: String) {
            val bundle = Bundle()
            bundle.putString(key, value)
            firebaseAnalytics.logEvent(name, bundle)
        }
    }

}