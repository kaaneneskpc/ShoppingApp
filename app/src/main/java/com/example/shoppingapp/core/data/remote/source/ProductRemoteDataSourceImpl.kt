package com.example.shoppingapp.core.data.remote.source

import com.example.shoppingapp.core.data.model.ProductResponse
import com.example.shoppingapp.core.data.remote.api.ProductService
import javax.inject.Inject

class ProductRemoteDataSourceImpl @Inject constructor(
    private val productService: ProductService
) : ProductRemoteDataSource {

    override suspend fun getProducts(): Result<List<ProductResponse>> {
        return runCatching {
            productService.getProducts()
        }
    }

    override suspend fun getProductDetail(id: Int): Result<ProductResponse> {
        return runCatching {
            productService.getProductDetail(id)
        }
    }
}