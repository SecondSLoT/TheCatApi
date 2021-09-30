package com.secondslot.thecatsapi.data.api.okhttp

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

private const val API_KEY = "105f501f-40c9-4604-bea3-efd5e01fbe75"

class CatsRequestInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest: Request = chain.request()

//        val newUrl: HttpUrl = originalRequest.url.newBuilder()
//            .addPathSegment("search")
//            .build()


        val newRequest: Request = originalRequest.newBuilder()
            .header("x-api-key", API_KEY)
//            .url(newUrl)
            .build()

        return chain.proceed(newRequest)
    }
}
