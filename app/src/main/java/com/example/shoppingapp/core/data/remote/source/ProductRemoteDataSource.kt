package com.example.shoppingapp.core.data.remote.source

import com.example.shoppingapp.core.data.model.ProductResponse

interface ProductRemoteDataSource {
    suspend fun getProducts(): Result<List<ProductResponse>>
    suspend fun getProductDetail(id: Int): Result<ProductResponse>
}