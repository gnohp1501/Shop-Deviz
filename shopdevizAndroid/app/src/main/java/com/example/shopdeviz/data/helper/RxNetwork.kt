package com.example.shopdeviz.data.helper

import android.content.Context
import android.net.ConnectivityManager
import android.util.Log
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers

object RxNetwork {

    fun checkInternetNetwork(
        context: Context,
        handlerNoNetwork: (() -> Unit)? = null
    ): Single<Unit> {
        return Single.fromCallable {
            if (context.isNetworkConnected().not()) {
                if (handlerNoNetwork != null) {
                    Log.d("checkInternetNetwork", "handlerNoNetwork")
                }
                Log.d("checkInternetNetwork", "isNetworkConnected().not()")
            }
        }.subscribeOn(Schedulers.io())
    }
}

fun Context.isNetworkConnected(): Boolean {
    val cm =
        applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE) as? ConnectivityManager
    cm ?: return false

    val network = cm.activeNetwork
    if (network != null) {
        val networkCapabilities = cm.getNetworkCapabilities(network)
        return networkCapabilities != null
    }
    return false
}