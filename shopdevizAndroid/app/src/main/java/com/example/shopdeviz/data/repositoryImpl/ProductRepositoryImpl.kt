package com.example.shopdeviz.data.repositoryImpl

import android.content.Context
import com.example.shopdeviz.data.helper.rxWithNetwork
import com.example.shopdeviz.data.service.ProductService
import com.example.shopdeviz.domain.model.Product
import com.example.shopdeviz.domain.repository.ProductRepository
import io.reactivex.rxjava3.core.Single

class ProductRepositoryImpl(
    private val context: Context,
    private val productService: ProductService
) : ProductRepository {
    override fun getProduct(): Single<List<Product>> {
        return context.rxWithNetwork {
            productService.getProduct()
        }.map {
            it.map { it.convertToModel() }
        }
    }
}