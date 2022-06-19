package com.vajro.robin.kotlin.data.network

import com.example.matajartask.data.apiServices.ProductListApi
import com.example.matajartask.data.model.Request.ProductListRequest
import com.example.matajartask.data.model.Response.ProductListResponse
import retrofit2.Response
import javax.inject.Inject


class ProductListApiHelperImpl @Inject constructor(private val productListApi: ProductListApi) :
    ProductListApiHelper {

    override suspend fun getProductListAsync(productListRequest: ProductListRequest): Response<ProductListResponse> =
        productListApi.getProductListAsync(productListRequest)
}


