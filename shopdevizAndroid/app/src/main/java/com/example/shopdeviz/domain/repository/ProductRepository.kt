package com.example.shopdeviz.domain.repository

import com.example.shopdeviz.domain.model.Product
import io.reactivex.rxjava3.core.Single

interface ProductRepository {

    fun getProduct(): Single<List<Product>>
}