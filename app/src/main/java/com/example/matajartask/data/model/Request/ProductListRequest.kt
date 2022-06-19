package com.example.matajartask.data.model.Request

import com.google.gson.annotations.SerializedName

data class ProductListRequest(

	@field:SerializedName("strSubCategoryId")
	val strSubCategoryId: String? = null,

	@field:SerializedName("intPageLimit")
	val intPageLimit: Int? = null,

	@field:SerializedName("strStoreId")
	val strStoreId: String? = null,

	@field:SerializedName("arr_stores")
	val arrStores: List<String?>? = null,

	@field:SerializedName("intSkipCount")
	val intSkipCount: Int? = null,

	@field:SerializedName("blnExpress")
	val blnExpress: Boolean? = null
)
