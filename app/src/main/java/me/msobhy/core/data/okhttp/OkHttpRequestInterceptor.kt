package com.musliminfo.prayertimes.data.okhttp

import com.musliminfo.prayertimes.Constants
import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import java.io.IOException

/**
 * Adds common request param headers (ex: content-type)
 */
class OkHttpRequestInterceptor : Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()

        var urlBuilder: HttpUrl.Builder = request.url().newBuilder()
        if (request.method() == "GET" || request.method() == "DELETE") {
            urlBuilder = addDefaultQueryParams(urlBuilder)
        }
        val updatedUrl = urlBuilder.build()

        val updatedRequest = addDefaultHeaders(request.newBuilder())
                .url(updatedUrl)
                .build()

        return chain.proceed(updatedRequest)
    }

    private fun addDefaultHeaders(builder: Request.Builder): Request.Builder {
        return builder
                .addHeader(Constants.ACCEPT_HEADER_KEY, Constants.ACCEPT_JSON_HEADER_VALUE)
                .header(Constants.CONTENT_TYPE_KEY, Constants.CONTENT_TYPE_VALUE)
    }

    private fun addDefaultQueryParams(builder: HttpUrl.Builder): HttpUrl.Builder {
        return builder
//                .addQueryParameter(Constants.API_KEY_PARAM_KEY, Constants.API_KEY_PARAM_VALUE)
    }
}
