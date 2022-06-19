package com.example.matajartask.ui.productList.viewmodel

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.matajartask.Application
import com.example.matajartask.data.apiServices.ProductListApi
import com.example.matajartask.data.model.Request.ProductListRequest
import com.example.matajartask.data.model.Response.ProductListResponse
import com.example.matajartask.data.repository.ProductListRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class ProductListViewModel @Inject constructor(
    private val productListRepository: ProductListRepository,
    private val productListApi: ProductListApi
) : ViewModel() {
    private val _productList = MutableLiveData<ProductListResponse>()
    val productList: LiveData<ProductListResponse>
        get() = _productList


    fun getAllProducts(context: Context, skipCount: Int) {
        val arrayList = ArrayList<String>()
        arrayList.add("621a01ab2e94a94f51f62afa")
        arrayList.add("623acc516242467c74fd7955")
        arrayList.add("6246a8f82fdf7b7ba71072e0")
        arrayList.add("6253e0831f8593d7c29a992c")
        arrayList.add("6273b3a3ae1a87cc74bfe7ab")

        when {
            Application.isConnected() -> {
                viewModelScope.launch {
                    withContext(Dispatchers.IO) {
                        try {

                            productListRepository.getProductList(
                                ProductListRequest(
                                    "62553da9927cf90f211056b2",
                                    20, "", arrayList, skipCount, false
                                )
                            ).let {
                                if (it.isSuccessful) {
                                    _productList.postValue(it.body())
                                }
                            }

                        } catch (throwable: Throwable) {

                        }

                    }

                }
            }
            else -> Toast.makeText(
                context,
                "",
                Toast.LENGTH_LONG
            ).show()
        }
    }

}