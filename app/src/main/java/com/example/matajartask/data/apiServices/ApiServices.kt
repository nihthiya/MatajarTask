package com.example.matajartask.data.apiServices

import com.example.matajartask.data.model.Request.ProductListRequest
import com.example.matajartask.data.model.Response.ProductListResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST


interface ProductListApi{

    @POST("/v2/api/product/get_product_under_sub_category")
    suspend fun getProductListAsync(@Body loginRequest: ProductListRequest): Response<ProductListResponse>


}