package com.example.shopdeviz.data.response

import com.example.shopdeviz.domain.model.Product
import com.google.gson.annotations.SerializedName

data class ProductResponse(
    @SerializedName("name") var name: String? = null,
    @SerializedName("author") var author: String? = null,
) {
    fun convertToModel() = Product(
        name = name ?: "", author = author ?: ""
    )
}
