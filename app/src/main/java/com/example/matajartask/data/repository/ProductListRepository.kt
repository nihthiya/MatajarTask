package com.example.matajartask.data.repository

import com.example.matajartask.data.model.Request.ProductListRequest
import com.vajro.robin.kotlin.data.network.ProductListApiHelper
import javax.inject.Inject


class ProductListRepository @Inject constructor(private val apiHelper: ProductListApiHelper) {

    suspend fun getProductList(productListRequest: ProductListRequest) = apiHelper.getProductListAsync(productListRequest)

}
