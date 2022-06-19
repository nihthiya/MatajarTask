package com.vajro.robin.kotlin.data.network

import com.example.matajartask.data.model.Request.ProductListRequest
import com.example.matajartask.data.model.Response.ProductListResponse
import retrofit2.Response

interface ProductListApiHelper {

    suspend fun getProductListAsync(productListRequest: ProductListRequest): Response<ProductListResponse>

//    suspend fun getProductListByHandle(
//        appId: String,
//        page: String,
//        handle: String,
//        sort : String,
//        languageCode: String
//    ): Response<ProductListResponse>
//

}