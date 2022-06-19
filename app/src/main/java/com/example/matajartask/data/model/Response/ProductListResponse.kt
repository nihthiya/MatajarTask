package com.example.matajartask.data.model.Response

import com.google.gson.annotations.SerializedName

data class ProductListResponse(

	@field:SerializedName("data")
	val data: List<DataItem?>? = null,

	@field:SerializedName("success")
	val success: Boolean? = null,

	@field:SerializedName("count")
	val count: Int? = null,

	@field:SerializedName("message")
	val message: String? = null
)

data class DataItem(

	@field:SerializedName("objSubCategory")
	val objSubCategory: ObjSubCategory? = null,

	@field:SerializedName("blnNormal")
	val blnNormal: Boolean? = null,

	@field:SerializedName("strBrandName")
	val strBrandName: String? = null,

	@field:SerializedName("strDisclaimer")
	val strDisclaimer: String? = null,

	@field:SerializedName("objShop")
	val objShop: ObjShop? = null,

	@field:SerializedName("intSellingPrice")
	val intSellingPrice: Double? = null,

	@field:SerializedName("intDeliveryTime")
	val intDeliveryTime: Int? = null,

	@field:SerializedName("intMRP")
	val intMRP: Double? = null,

	@field:SerializedName("fkBrandId")
	val fkBrandId: String? = null,

	@field:SerializedName("pkProductId")
	val pkProductId: String? = null,

	@field:SerializedName("arrayThumbnail")
	val arrayThumbnail: List<ArrayThumbnailItem?>? = null,

	@field:SerializedName("intMinimumAmount")
	val intMinimumAmount: Int? = null,

	@field:SerializedName("strDescription")
	val strDescription: String? = null,

	@field:SerializedName("arrayOtherImages")
	val arrayOtherImages: List<ArrayOtherImagesItem?>? = null,

	@field:SerializedName("intDiscount")
	val intDiscount: Int? = null,

	@field:SerializedName("strProductName")
	val strProductName: String? = null,

	@field:SerializedName("intMaxQuantity")
	val intMaxQuantity: Int? = null,

	@field:SerializedName("intMinQuantity")
	val intMinQuantity: Int? = null,

	@field:SerializedName("blnStockAvailability")
	val blnStockAvailability: Boolean? = null,

	@field:SerializedName("sortNum")
	val sortNum: Int? = null,

	@field:SerializedName("arrayProductDetail")
	val arrayProductDetail: Any? = null,

	@field:SerializedName("blnExpress")
	val blnExpress: Boolean? = null
)

data class ArrayOtherImagesItem(

	@field:SerializedName("imageName")
	val imageName: String? = null,

	@field:SerializedName("imageUrl")
	val imageUrl: String? = null
)

data class ObjShop(

	@field:SerializedName("fkShopId")
	val fkShopId: String? = null,

	@field:SerializedName("strPlace")
	val strPlace: String? = null,

	@field:SerializedName("strShopName")
	val strShopName: String? = null,

	@field:SerializedName("strImageUrl")
	val strImageUrl: String? = null
)

data class ObjSubCategory(

	@field:SerializedName("fkSubCategoryId")
	val fkSubCategoryId: String? = null,

	@field:SerializedName("strSubCategoryName")
	val strSubCategoryName: String? = null
)

data class ArrayThumbnailItem(

	@field:SerializedName("imageName")
	val imageName: String? = null,

	@field:SerializedName("imageUrl")
	val imageUrl: String? = null
)
