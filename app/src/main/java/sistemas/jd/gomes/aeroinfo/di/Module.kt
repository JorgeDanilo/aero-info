package sistemas.jd.gomes.aeroinfo.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import sistemas.jd.gomes.aeroinfo.data.remote.*
import sistemas.jd.gomes.aeroinfo.util.Constants
import sistemas.jd.gomes.aeroinfo.util.StoreAiport
import sistemas.jd.gomes.aeroinfo.util.XmlOrJsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object Module {

    @Provides
    @Singleton
    fun provideHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .readTimeout(15, TimeUnit.SECONDS)
            .connectTimeout(15, TimeUnit.SECONDS)
            .build()
    }


    @Singleton
    @Provides
    fun provideRetrofit(client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL_REDMET)
            .addConverterFactory(XmlOrJsonConverterFactory())
            .client(client)
            .build()
    }

    @Provides
    @Singleton
    fun provideStoreAirport(
        @ApplicationContext context: Context
    ): StoreAiport {
        return StoreAiport(context = context)
    }

    @Singleton
    @Provides
    fun provideServiceApi(retrofit: Retrofit): AirportApi {
        return retrofit.create(AirportApi::class.java)
    }

    @Singleton
    @Provides
    fun provideServiceMeteorologyApi(retrofit: Retrofit): MeteorologyApi {
        return retrofit.create(MeteorologyApi::class.java)
    }


    @Singleton
    @Provides
    fun provideServiceSunsetDayApi(retrofit: Retrofit): SunriseDayApi {
        return retrofit.create(SunriseDayApi::class.java)
    }

    @Singleton
    @Provides
    fun provideServiceChartsApi(retrofit: Retrofit): ChartsApi {
        return retrofit.create(ChartsApi::class.java)
    }

    @Singleton
    @Provides
    fun provideServiceNotamApi(retrofit: Retrofit): NotamApi {
        return retrofit.create(NotamApi::class.java)
    }

    @Singleton
    @Provides
    fun provideServiceRotaerApi(retrofit: Retrofit): RotaerApi {
        return retrofit.create(RotaerApi::class.java)
    }

}