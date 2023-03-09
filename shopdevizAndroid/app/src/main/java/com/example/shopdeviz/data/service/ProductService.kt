package com.example.shopdeviz.data.service

import com.example.shopdeviz.data.response.ProductResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface ProductService {
    @GET("product/all")
    fun getProduct(): Single<List<ProductResponse>>
}