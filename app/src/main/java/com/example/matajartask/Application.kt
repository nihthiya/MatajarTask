package com.example.matajartask

import android.content.Context
import android.content.SharedPreferences
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import androidx.annotation.StringRes
import androidx.multidex.MultiDexApplication
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class Application : MultiDexApplication() {
    companion object {
        private var app: Application? = null
        fun app(): Application = app!!
        fun sharedPreferences(): SharedPreferences =
            app!!.getSharedPreferences("Name", Context.MODE_PRIVATE)

        fun getString(@StringRes stringId: Int): String = app().getString(stringId)


        fun isConnected(): Boolean {
            val connectivityManager =
                app!!.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                val nw = connectivityManager.activeNetwork ?: return false
                val actNw = connectivityManager.getNetworkCapabilities(nw) ?: return false
                return when {
                    actNw.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
                    actNw.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
                    else -> false
                }
            } else {
                val nwInfo = connectivityManager.activeNetworkInfo ?: return false
                return nwInfo.isConnected
            }
        }

    }

    override fun onCreate() {
        super.onCreate()
//        startKoin {
//            androidContext(this@Application)
//            modules(listOf(
//                viewModelModule,
//                apiModule,
//                repositoryModule,
//                RetrofitModule
//            ))
//        }

        app = this
    }
}