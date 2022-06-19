package com.example.matajartask.data.apiServices

import com.example.matajartask.data.model.Request.ProductListRequest
import com.example.matajartask.data.model.Response.ProductListResponse
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.*

//interface ApiServices {
//
//    @POST("/v2/api/product/get_product_under_sub_category")
//    fun productListRequestCallAsync(@Body loginRequest: ProductListRequest): Deferred<ProductListResponse>
//
//}

interface ProductListApi{

    @POST("/v2/api/product/get_product_under_sub_category")
    suspend fun getProductListAsync(@Body loginRequest: ProductListRequest): Response<ProductListResponse>

//    @GET("/v3/products")
//    suspend fun getProductListByHandle(@Query("appid") appId: String,
//                                       @Query("page") page: String,
//                                       @Query("handle") handle : String,
//                                       @Query("language_code") languageCode: String,
//                                       @Query("sort") sort : String): Response<ProductListResponse>
//
//
//
//    @GET("/v3/products")
//    suspend fun getProductListByHandlePaging(@Query("appid") appId: String,
//                                             @Query("page") page: String,
//                                             @Query("handle") handle : String,
//                                             @Query("language_code") languageCode: String,
//                                             @Query("filter") filter: String,
//                                             @Query("sort") sort : String): ProductListResponse
//
//
//    @GET("/v3/products")
//    suspend fun getProductListByKeywordPaging(@Query("appid") appId: String,
//                                              @Query("page") page: String,
//                                              @Query("q") keyword : String,
//                                              @Query("language_code") languageCode: String,
//                                              @Query("filter") filter: String,
//                                              @Query("sort") sort : String): ProductListResponse
//
//    @POST("/v4/addkeywords")
//    suspend fun subscribeProduct(@Query("appid") appId:String, @Query("type") type:String, @Body subscribeProductRequest: SubscribeProductRequest): Response<SubscribeProductResponse>


}