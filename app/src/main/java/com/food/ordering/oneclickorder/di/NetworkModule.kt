package com.food.ordering.oneclickorder.di

import com.food.ordering.oneclickorder.BuildConfig
import com.food.ordering.oneclickorder.data.retrofit.*
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val networkModule = module {
    single { AuthInterceptor(get(),get()) }
    single { provideRetrofit(get()) }
    single { UserRepository(get()) }
    single { ShopRepository(get()) }
    single { PlaceRepository(get()) }
    single { OrderRepository(get()) }
    single { ItemRepository(get()) }
}

fun provideRetrofit(authInterceptor: AuthInterceptor): Retrofit {
    return Retrofit.Builder().baseUrl(BuildConfig.CUSTOM_BASE_URL).client(provideOkHttpClient(authInterceptor))
            .addConverterFactory(GsonConverterFactory.create()).build()
}

fun provideOkHttpClient(authInterceptor: AuthInterceptor): OkHttpClient {
    val builder = OkHttpClient()
            .newBuilder()
            .connectTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS)
            .addInterceptor(authInterceptor)

    if (BuildConfig.DEBUG) {
        val requestInterceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
        builder.addNetworkInterceptor(requestInterceptor)
    }
    return builder.build()
}