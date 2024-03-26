package com.yonjar.clashroyalestats.data.network

import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class ClashInterceptor @Inject constructor():Interceptor {
    private val apiToken:String = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiIsImtpZCI6IjI4YTMxOGY3LTAwMDAtYTFlYi03ZmExLTJjNzQzM2M2Y2NhNSJ9.eyJpc3MiOiJzdXBlcmNlbGwiLCJhdWQiOiJzdXBlcmNlbGw6Z2FtZWFwaSIsImp0aSI6IjdmODdiMjE2LTkxODItNDkyZS1hNzhkLTU1ODU2ZmE0YmQyNiIsImlhdCI6MTcxMTQ2NDM3OCwic3ViIjoiZGV2ZWxvcGVyLzgyNDkyZjg0LTA3OGEtZjAyYS05YWE2LWFhMWI0NjI5YmUyZCIsInNjb3BlcyI6WyJyb3lhbGUiXSwibGltaXRzIjpbeyJ0aWVyIjoiZGV2ZWxvcGVyL3NpbHZlciIsInR5cGUiOiJ0aHJvdHRsaW5nIn0seyJjaWRycyI6WyIxODYuNzcuMTk5LjIyMyJdLCJ0eXBlIjoiY2xpZW50In1dfQ.KvBXX8P9SHNGsLZpFvFuGltdI4ZIOLX0xu8Sv58IPhVdpB025irSjUBhFFTv0vzzcFTAsw4tceYBG7QcRT8-mw"
        override fun intercept(chain: Interceptor.Chain): Response {
            val original = chain.request()
            val request = original.newBuilder()
                .header("Authorization", "Bearer $apiToken")
                .method(original.method, original.body)
                .build()
            return chain.proceed(request)
    }
}