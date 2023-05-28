package com.example.shoppingapp.core.data.di

import com.example.shoppingapp.core.data.remote.repository.AuthRepository
import com.example.shoppingapp.core.data.remote.repository.impl.AuthRepositoryImpl
import com.example.shoppingapp.core.data.remote.source.AuthRemoteDataSource
import com.example.shoppingapp.core.data.remote.source.AuthRemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface LoginModule {
    @Binds
    fun bindLoginRemoteDataSource(sourceImpl: AuthRemoteDataSourceImpl): AuthRemoteDataSource

    @Binds
    fun bindLoginRepository(repositoryImpl: AuthRepositoryImpl): AuthRepository
}