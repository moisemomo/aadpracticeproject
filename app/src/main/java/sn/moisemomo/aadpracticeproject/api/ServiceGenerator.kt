package sn.moisemomo.aadpracticeproject.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import sn.moisemomo.aadpracticeproject.BuildConfig

object ServiceGenerator {
    var httpClientBuilder = OkHttpClient.Builder()


    fun createService(baseUrl: String): WebService {
        val retrofitBuilder: Retrofit.Builder = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())

        if (BuildConfig.DEBUG) {
            val logging = HttpLoggingInterceptor()
            logging.setLevel(HttpLoggingInterceptor.Level.BODY)
            httpClientBuilder.addInterceptor(logging)
        }

        val retrofit = retrofitBuilder.client(httpClientBuilder.build()).build()
        return retrofit.create(WebService::class.java)
    }
}