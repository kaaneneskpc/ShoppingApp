package com.example.shoppingapp.core.data.di

import com.example.shoppingapp.core.data.remote.repository.ProductRepository
import com.example.shoppingapp.core.data.remote.repository.impl.ProductRepositoryImpl
import com.example.shoppingapp.core.data.remote.source.ProductRemoteDataSource
import com.example.shoppingapp.core.data.remote.source.ProductRemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent


@Module
@InstallIn(ViewModelComponent::class)
interface ProductModule {
    @Binds
    fun bindProductRemoteDataSource(
        sourceImpl: ProductRemoteDataSourceImpl
    ): ProductRemoteDataSource

    @Binds
    fun bindProductRepository(
        sourceImpl: ProductRepositoryImpl
    ): ProductRepository

}