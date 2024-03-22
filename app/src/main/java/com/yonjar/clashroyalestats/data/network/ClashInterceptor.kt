package com.yonjar.clashroyalestats.data.network

import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class ClashInterceptor @Inject constructor():Interceptor {
    private val apiToken:String = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiIsImtpZCI6IjI4YTMxOGY3LTAwMDAtYTFlYi03ZmExLTJjNzQzM2M2Y2NhNSJ9.eyJpc3MiOiJzdXBlcmNlbGwiLCJhdWQiOiJzdXBlcmNlbGw6Z2FtZWFwaSIsImp0aSI6ImQwYTA1MzllLWRkMjItNDU1Yy1iYTJmLTUzNjc1Mzg4MjdhNiIsImlhdCI6MTcxMTExOTg5OCwic3ViIjoiZGV2ZWxvcGVyLzgyNDkyZjg0LTA3OGEtZjAyYS05YWE2LWFhMWI0NjI5YmUyZCIsInNjb3BlcyI6WyJyb3lhbGUiXSwibGltaXRzIjpbeyJ0aWVyIjoiZGV2ZWxvcGVyL3NpbHZlciIsInR5cGUiOiJ0aHJvdHRsaW5nIn0seyJjaWRycyI6WyIxODYuNzcuMTk4LjIyMyJdLCJ0eXBlIjoiY2xpZW50In1dfQ.TlW9zPLMy3lF01s4Q15WqAhMqPHRMBMvhrvoTIQJls6wtnjymfTtHLGbYmnA8qp3b4tCv88rnsy44u9FAevN4A"
        override fun intercept(chain: Interceptor.Chain): Response {
            val original = chain.request()
            val request = original.newBuilder()
                .header("Authorization", "Bearer $apiToken")
                .method(original.method, original.body)
                .build()
            return chain.proceed(request)
    }
}