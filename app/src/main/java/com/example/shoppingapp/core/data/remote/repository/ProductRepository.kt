package com.example.shoppingapp.core.data.remote.repository

import com.example.shoppingapp.core.data.model.ProductResponse

interface ProductRepository {
    suspend fun getProducts(): Result<List<ProductResponse>>
    suspend fun getProductDetail(id: Int): Result<ProductResponse>
}