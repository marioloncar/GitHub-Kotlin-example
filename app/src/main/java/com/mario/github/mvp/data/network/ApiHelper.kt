package com.mario.github.mvp.data.network

import android.text.TextUtils
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import okhttp3.Credentials
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiHelper {
    companion object {
        private val API_BASE_URL = "https://api.github.com/"

        private val httpClient = OkHttpClient.Builder()
        private val logging = HttpLoggingInterceptor()

        private val builder = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(API_BASE_URL)

        private var retrofit = builder.build()

        fun <S> createService(serviceClass: Class<S>): S {
            return createService(serviceClass, null)
        }

        fun <S> createService(serviceClass: Class<S>, clientId: String?, clientSecret: String?): S {
            if (!TextUtils.isEmpty(clientId) && !TextUtils.isEmpty(clientSecret)) {
                val authToken = Credentials.basic(clientId, clientSecret)
                return createService(serviceClass, authToken)
            }

            return createService(serviceClass, null, null)
        }

        fun <S> createService(serviceClass: Class<S>, authToken: String?): S {
            logging.level = HttpLoggingInterceptor.Level.BODY

            if (!TextUtils.isEmpty(authToken)) {
                val interceptor = AuthenticationInterceptor(authToken)

                if (!httpClient.interceptors().contains(interceptor)) {
                    httpClient.addInterceptor(interceptor)
                    httpClient.addInterceptor(logging)

                    builder.client(httpClient.build())
                    retrofit = builder.build()
                }
            }

            return retrofit.create(serviceClass)
        }
    }

}