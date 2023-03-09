package com.example.shopdeviz.presentation.viewmodel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shopdeviz.domain.helper.data
import com.example.shopdeviz.domain.model.Product
import com.example.shopdeviz.domain.repository.ProductRepository
import com.example.shopdeviz.presentation.livedata.subscribeToResource
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.addTo

class ProductViewModel(
    private val repository: ProductRepository
) : ViewModel() {

    val productLiveData = MutableLiveData<List<Product>>()

    fun getProduct(
        context: Context, onFinish: (List<Product>) -> Unit
    ) {
        repository.getProduct().subscribeToResource(context = context, onSuccess = {
            onFinish(it.data())
        }).addTo(CompositeDisposable())
    }
}