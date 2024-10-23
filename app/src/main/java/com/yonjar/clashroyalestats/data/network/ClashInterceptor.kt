package com.yonjar.clashroyalestats.data.network

import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class ClashInterceptor @Inject constructor():Interceptor {
    private val apiToken:String = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiIsImtpZCI6IjI4YTMxOGY3LTAwMDAtYTFlYi03ZmExLTJjNzQzM2M2Y2NhNSJ9.eyJpc3MiOiJzdXBlcmNlbGwiLCJhdWQiOiJzdXBlcmNlbGw6Z2FtZWFwaSIsImp0aSI6ImI0NWQ2NDUxLTdmNmUtNDUwOS05ZjdmLWU4Y2JjNTljYmI5MyIsImlhdCI6MTcxMjYxODI2Nywic3ViIjoiZGV2ZWxvcGVyLzgyNDkyZjg0LTA3OGEtZjAyYS05YWE2LWFhMWI0NjI5YmUyZCIsInNjb3BlcyI6WyJyb3lhbGUiXSwibGltaXRzIjpbeyJ0aWVyIjoiZGV2ZWxvcGVyL3NpbHZlciIsInR5cGUiOiJ0aHJvdHRsaW5nIn0seyJjaWRycyI6WyIxODYuNzcuMTMyLjE5NiJdLCJ0eXBlIjoiY2xpZW50In1dfQ.Rs7AbAi7S_Jv-_rCfVMyg_0pE6dYVDMZSkVPFsSiX0G_8xHqY4HhqSAGZgTuH0E6-wYKp4eIQ_diXYXS3qK0DQ"
        override fun intercept(chain: Interceptor.Chain): Response {
            val original = chain.request()
            val request = original.newBuilder()
                .header("Authorization", "Bearer $apiToken")
                .method(original.method, original.body)
                .build()
            return chain.proceed(request)
    }
}