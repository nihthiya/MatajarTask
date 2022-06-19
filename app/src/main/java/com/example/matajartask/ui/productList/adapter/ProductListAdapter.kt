package com.example.matajartask.ui.productList.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.matajartask.R
import com.example.matajartask.data.model.Response.DataItem
import com.example.matajartask.databinding.ItemProductBinding
import android.content.Context.MODE_PRIVATE

import android.content.SharedPreferences
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT

typealias onLoadDetails = (name: String, url: String) -> Unit

class ProductListAdapter() : RecyclerView.Adapter<ProductListAdapter.ViewHolder>() {

    private var itemList: List<DataItem?>? = null
    private lateinit var context: Context
    private lateinit var onLoadDetails: onLoadDetails

    constructor(context: Context, productList: List<DataItem?>?, onLoadDetails: onLoadDetails) : this() {
        this.context = context
        this.itemList = productList
        this.onLoadDetails = onLoadDetails
    }

    override fun getItemCount() = itemList!!.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_product,
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = itemList!![position]
        try {
            Glide.with(context).load(item!!.arrayThumbnail?.get(0)?.imageUrl).into(holder.itemProductBinding.ivImage)


            holder.itemProductBinding.tvProductName.text = item.strProductName
            holder.itemProductBinding.tvProductDes.text = item.strDescription
            holder.itemProductBinding.tvProductPrice.text = "AED " + item.intSellingPrice.toString()

            holder.itemProductBinding.btnAdd.setOnClickListener {
                val editor: SharedPreferences.Editor =
                    context.getSharedPreferences("MY_PREF", MODE_PRIVATE).edit()
                editor.putString("productId", item.pkProductId)
                editor.putInt("quantity", 1)
                editor.apply()
                Toast.makeText(context,"Item Added to Cart", LENGTH_SHORT).show()
            }

            holder.itemView.setOnClickListener {
                onLoadDetails.invoke(item.strProductName!!, item.arrayThumbnail?.get(0)?.imageUrl.toString())

            }

        } catch (e: Exception) {

        }


    }


    inner class ViewHolder(
        val itemProductBinding: ItemProductBinding
    ) : RecyclerView.ViewHolder(itemProductBinding.root)

}