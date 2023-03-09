package com.example.shopdeviz.data.helper

import android.content.Context
import android.util.Log
import com.example.shopdeviz.domain.helper.Resource
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers

fun <E> Context.rxWithNetwork(
    handlerNoNetwork: (() -> Unit)? = null,
    action: () -> Single<E>
): Single<E> {
    return RxNetwork.checkInternetNetwork(this, handlerNoNetwork = handlerNoNetwork)
        .flatMap { action() }.subscribeOn(Schedulers.io())
}

fun <E> Single<E>.subscribeByResource(
    result: (Resource<E>) -> Unit
): Disposable {
    return observeOn(AndroidSchedulers.mainThread()).subscribe({
        Log.d("Success : subscribeByResource", it.toString())
        result(Resource.Success(it))
    }, {
        Log.d("Error : subscribeByResource", it.message.toString())
    })
}