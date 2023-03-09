package com.example.shopdeviz.domain.helper

// Sealed class help us to return result is general type (maybe included many object Type or State)
sealed class Resource<out T> {
    var page: Int = NO_PAGE

    companion object {
        const val NO_PAGE = 0
    }

    object Initialize : Resource<Nothing>()

    // We must use class here, not object because we must keep track of page variable on loading
    class Loading : Resource<Nothing>()

    data class Success<T>(val data: T) : Resource<T>()
    data class Error(val exception: Throwable) : Resource<Nothing>()

    fun page(page: Int): Resource<T> {
        this.page = page
        return this
    }

}

fun <T> Resource<T>.isInitialize(): Boolean = this is Resource.Initialize
fun <T> Resource<T>.isLoading(): Boolean = this is Resource.Loading
fun <T> Resource<T>.isSuccess(): Boolean = this is Resource.Success
fun <T> Resource<T>.isError(): Boolean = this is Resource.Error

fun <T> Resource<T>.data(): T = (this as Resource.Success).data
fun <T> Resource<T>.exception(): Throwable = (this as Resource.Error).exception
