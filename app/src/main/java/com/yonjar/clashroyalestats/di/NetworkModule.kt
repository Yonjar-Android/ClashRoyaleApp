package com.yonjar.clashroyalestats.di

import com.yonjar.clashroyalestats.data.network.ClashInterceptor
import com.yonjar.clashroyalestats.data.network.UserService
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
object NetworkModule {

    @Provides
    @Singleton
    fun getRetrofit(httpClient: OkHttpClient) : Retrofit = Retrofit.Builder()
        .baseUrl("https://api.clashroyale.com/v1/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(httpClient)
        .build()

    @Provides
    @Singleton
    fun provideInterceptor(clashInterceptor: ClashInterceptor): OkHttpClient {
        return OkHttpClient
            .Builder()
            .addInterceptor(clashInterceptor)
            .build()
    }

    @Provides
    fun getUserService(retrofit: Retrofit) : UserService = retrofit.create(UserService::class.java)
}