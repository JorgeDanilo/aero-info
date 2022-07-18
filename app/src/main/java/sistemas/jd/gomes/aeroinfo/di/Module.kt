package sistemas.jd.gomes.aeroinfo.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import sistemas.jd.gomes.aeroinfo.data.remote.AirportApi
import sistemas.jd.gomes.aeroinfo.data.remote.MeteorologyApi
import sistemas.jd.gomes.aeroinfo.data.remote.SunriseDayApi
import sistemas.jd.gomes.aeroinfo.util.Constants
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
    fun provideServiceSunsetDay(retrofit: Retrofit): SunriseDayApi {
        return retrofit.create(SunriseDayApi::class.java)
    }

}