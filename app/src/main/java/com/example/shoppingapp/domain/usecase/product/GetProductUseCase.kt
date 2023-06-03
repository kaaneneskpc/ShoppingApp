package com.example.shoppingapp.domain.usecase.product

import com.example.shoppingapp.core.data.model.ProductResponse
import com.example.shoppingapp.core.data.remote.repository.ProductRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
class GetProductsUseCase @Inject constructor(private val productRepository: ProductRepository) {
    operator fun invoke(): Flow<List<ProductResponse>> {
        return flow {
            val result = productRepository.getProducts()
            (result.getOrNull() ?: throw IllegalArgumentException("error message")).also {
                emit(it)
            }
        }
    }
}