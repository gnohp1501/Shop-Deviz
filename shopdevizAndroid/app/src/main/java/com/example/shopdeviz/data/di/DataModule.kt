package com.example.shopdeviz.data.di

import com.example.shopdeviz.BuildConfig
import com.example.shopdeviz.data.helper.JsonHelper
import com.example.shopdeviz.data.repositoryImpl.ProductRepositoryImpl
import com.example.shopdeviz.data.service.ProductService
import com.example.shopdeviz.domain.repository.ProductRepository
import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val apiModules = module {

    single { JsonHelper.gson }

    single<ProductService> {
        createWebService(
            gson = get()
        )
    }

    factory<ProductRepository> { ProductRepositoryImpl(get(), get()) }

}


inline fun <reified T> createWebService(
    gson: Gson
): T {
    val interceptor = HttpLoggingInterceptor()
    interceptor.level = HttpLoggingInterceptor.Level.HEADERS
    interceptor.level = HttpLoggingInterceptor.Level.BODY

    return Retrofit.Builder().addCallAdapterFactory(RxJava3CallAdapterFactory.createSynchronous())
        .addConverterFactory(GsonConverterFactory.create(gson))
        .baseUrl(BuildConfig.BASE_URL)
        .client(
            OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .readTimeout(BuildConfig.TIME_OUT, TimeUnit.MILLISECONDS)
                .writeTimeout(BuildConfig.TIME_OUT, TimeUnit.MILLISECONDS)
                .connectTimeout(BuildConfig.TIME_OUT, TimeUnit.MILLISECONDS).cache(null).build()
        ).build().create(T::class.java)
}