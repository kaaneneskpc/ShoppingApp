package com.example.shoppingapp.feature.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shoppingapp.core.common.Resource
import com.example.shoppingapp.core.common.asResource
import com.example.shoppingapp.core.data.model.ProductResponse
import com.example.shoppingapp.domain.usecase.product.GetProductsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class HomeViewModel @Inject constructor(
    private val productsUseCase: GetProductsUseCase
) : ViewModel() {
    private val _uiState: MutableStateFlow<HomeUiState> = MutableStateFlow(HomeUiState())
    val uiState = _uiState

    init {
        getProducts()
    }

    private fun getProducts() {
        viewModelScope.launch {
            productsUseCase().asResource().onEach { result ->
                when (result) {
                    is Resource.Loading -> {
                        _uiState.value = _uiState.value.copy(loading = true)
                    }

                    is Resource.Error -> {
                        _uiState.value = _uiState.value.copy(loading = false)
                    }

                    is Resource.Success -> {
                        _uiState.value =
                            _uiState.value.copy(loading = false, products = result.data)
                    }
                }
            }.launchIn(this)
        }
    }
}


data class HomeUiState(
    val loading: Boolean = false,
    val products: List<ProductResponse> = listOf(),
)