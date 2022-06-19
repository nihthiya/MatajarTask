package com.example.matajartask.di

import com.example.matajartask.BuildConfig
import com.example.matajartask.data.apiServices.ProductListApi
import com.vajro.robin.kotlin.data.network.ProductListApiHelper
import com.vajro.robin.kotlin.data.network.ProductListApiHelperImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule{

    @Provides
    fun provideBaseUrl() = "http://www.matajar.ae"

    @Singleton
    @Provides
    fun provideOkHttpClient() = if (BuildConfig.DEBUG){
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
    }else{
        OkHttpClient
            .Builder()
            .build()
    }

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient, BASE_URL:String): Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .build()

    @Provides
    @Singleton
    fun provideProductListApiService(retrofit: Retrofit): ProductListApi = retrofit.create(ProductListApi::class.java)

    @Provides
    @Singleton
    fun provideApiHelper(apiHelper: ProductListApiHelperImpl): ProductListApiHelper = apiHelper

}