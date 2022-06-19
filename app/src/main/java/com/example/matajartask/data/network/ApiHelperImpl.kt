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


//    override suspend fun getProductListByHandle(
//        appId: String,
//        page: String,
//        handle: String,
//        sort : String,
//        languageCode: String
//    ): Response<ProductListResponse>  = productListApi.getProductListByHandle(appId = appId, page = page, handle = handle, sort= sort, languageCode = languageCode)

//    override suspend fun subscribeProduct(
//        appId: String,
//        type: String,
//        subscribeProductRequest: SubscribeProductRequest
//    ): Response<SubscribeProductResponse> =
//        productListApi.subscribeProduct(appId,type,subscribeProductRequest)

}


