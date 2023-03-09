package com.example.shopdeviz.presentation.livedata

import android.content.Context
import android.util.Log
import com.example.shopdeviz.data.helper.subscribeByResource
import com.example.shopdeviz.domain.helper.Resource
import com.example.shopdeviz.domain.helper.isError
import com.example.shopdeviz.domain.helper.isSuccess
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.disposables.Disposable

fun <E : Any> Single<E>.subscribeToResource(
    context: Context,
    isLoading: Boolean = true,
    onLoading: (() -> Unit)? = null,
    onError: (() -> Unit?)? = null,
    onSuccess: ((Resource<E>) -> Unit?)? = null,
): Disposable {
    return doOnSubscribe {
        if (isLoading) {
        } else {
            onLoading?.invoke()
        }
    }.subscribeByResource {
        when {
            it.isSuccess() -> {
                Log.d("Success : subscribeByResource", it.toString())
                onSuccess?.invoke(it)
            }
            it.isError() -> {
                Log.d("Error : subscribeByResource", "Error :subscribeByResource")
                onError?.invoke()
            }
        }
    }
}
