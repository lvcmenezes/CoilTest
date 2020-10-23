package de.rewe.coiltest

import android.app.Application
import android.util.Log.VERBOSE
import coil.ImageLoader
import coil.ImageLoaderFactory
import coil.request.CachePolicy
import coil.util.DebugLogger
import de.rewe.coiltest.BuildConfig.DEBUG
import de.rewe.coiltest.injection.appComponent
import okhttp3.OkHttpClient
import org.rewedigital.katana.Component
import timber.log.Timber

class CoreApplication: Application(), ImageLoaderFactory {

    private val coreComponent: Component by lazy { appComponent(this) }

    override fun onCreate() {
        super.onCreate()

        startTimber()
    }

    private fun startTimber() {
        if (DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

    override fun newImageLoader(): ImageLoader = ImageLoader.Builder(applicationContext)
        .crossfade(1000)
        .allowHardware(true)
        .logger(DebugLogger(VERBOSE))
        .error(R.drawable.ic_img_placeholder)
        .fallback(R.drawable.ic_img_placeholder)
        .placeholder(R.drawable.ic_img_placeholder)
        .diskCachePolicy(CachePolicy.DISABLED)
//        .memoryCachePolicy(CachePolicy.DISABLED)
//        .networkCachePolicy(CachePolicy.DISABLED)
        .okHttpClient(coreComponent.injectNow<OkHttpClient>())
        .build()
}