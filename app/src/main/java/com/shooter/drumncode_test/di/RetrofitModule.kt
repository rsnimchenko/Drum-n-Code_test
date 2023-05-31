package com.shooter.drumncode_test.di

import com.shooter.drumncode_test.data.network.MockApi
import com.shooter.drumncode_test.util.Const
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {
    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient = OkHttpClient
        .Builder()
        .build()

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(Const.BASE_URL)
        .client(okHttpClient)
        .build()

    @Provides
    @Singleton
    fun provideMockApi(retrofit: Retrofit): MockApi =
        retrofit.create(MockApi::class.java)
}