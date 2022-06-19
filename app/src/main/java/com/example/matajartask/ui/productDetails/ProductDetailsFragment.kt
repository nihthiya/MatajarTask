package com.example.matajartask.ui.productDetails

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.example.matajartask.R
import com.example.matajartask.databinding.FragmentProductDetailsBinding
import com.example.matajartask.databinding.FragmentProductListBinding

class ProductDetailsFragment : Fragment() {
    private lateinit var productdetailsBinding: FragmentProductDetailsBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        productdetailsBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_product_details, container, false)
        return productdetailsBinding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()


    }

    private fun initUI() {
        val productName = arguments!!.getString("productName")
        val productImage = arguments!!.getString("productImage")

        productdetailsBinding.tvProductName.text = productName
        Glide.with(requireContext()).load(productImage).into(productdetailsBinding.ivImage)

    }

}