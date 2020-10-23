package de.rewe.coiltest.interceptor

import android.os.SystemClock
import okhttp3.Interceptor
import okhttp3.Response

class DelayInterceptor: Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response =
        SystemClock.sleep(2000).run {
            generateResponse(chain)
        }

    private fun generateResponse(chain: Interceptor.Chain): Response = chain.proceed(chain.request())
}
