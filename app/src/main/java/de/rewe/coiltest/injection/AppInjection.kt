package de.rewe.coiltest.injection

import android.app.Application
import android.content.Context
import de.rewe.coiltest.interceptor.DelayInterceptor
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.rewedigital.katana.Component
import org.rewedigital.katana.Module
import org.rewedigital.katana.android.modules.APPLICATION_CONTEXT
import org.rewedigital.katana.android.modules.ApplicationModule
import org.rewedigital.katana.dsl.factory
import org.rewedigital.katana.dsl.get
import org.rewedigital.katana.dsl.singleton
import timber.log.Timber
import java.util.concurrent.TimeUnit

private const val CACHE_SIZE_BYTES = (1024 * 1024 * 1L)/4

val appModule = Module {
    singleton {
        Cache(get<Context>(APPLICATION_CONTEXT).cacheDir, CACHE_SIZE_BYTES)
    }

    factory { HttpLoggingInterceptor.Logger { message -> Timber.d(message) } }

    factory { HttpLoggingInterceptor(get()).apply { level = HttpLoggingInterceptor.Level.HEADERS } }

    factory { DelayInterceptor() }

    singleton {
        OkHttpClient.Builder()
            .connectTimeout(10, TimeUnit.SECONDS)
            .readTimeout(10, TimeUnit.SECONDS)
            .writeTimeout(10, TimeUnit.SECONDS)
            .callTimeout(10, TimeUnit.SECONDS)
            .cache(get<Cache>())
            .addInterceptor(get<HttpLoggingInterceptor>())
            .addNetworkInterceptor(get<DelayInterceptor>())
    }

    singleton { get<OkHttpClient.Builder>().build() }
}

fun appComponent(app: Application) = Component(
    modules = listOf(
        ApplicationModule(app),
        appModule,
    )
)