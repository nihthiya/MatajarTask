package com.example.matajartask.ui.productList.fragment


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.matajartask.R
import com.example.matajartask.data.model.Response.DataItem
import com.example.matajartask.databinding.FragmentProductListBinding
import com.example.matajartask.ui.productDetails.fragment.ProductDetailsFragment
import com.example.matajartask.ui.productList.adapter.ProductListAdapter
import com.example.matajartask.ui.productList.viewmodel.ProductListViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class ProductListFragment : Fragment() {
    private lateinit var productslistBinding: FragmentProductListBinding
    private val productListViewModel: ProductListViewModel by viewModels()
    var previousItemCount: Int = 0
    var totalCount: Int = 0
    var list = ArrayList<DataItem?>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        productslistBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_product_list, container, false)
        return productslistBinding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
    }

    private fun initUI() {
        productslistBinding.lifecycleOwner = this
        productslistBinding.productListViewModel = productListViewModel

        val layoutManager = GridLayoutManager(requireContext(), 2)
        productslistBinding.rvProductList.layoutManager = layoutManager

        productslistBinding.rvProductList.addOnScrollListener(object :
            RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if (!recyclerView.canScrollVertically(1) && newState == RecyclerView.SCROLL_STATE_IDLE) {
                    if (previousItemCount < totalCount) {
                        productslistBinding.loadMoreLayout.visibility = VISIBLE
                        productListViewModel.getAllProducts(requireContext(), previousItemCount)
                    }
                }
            }
        })
        productListViewModel.getAllProducts(requireContext(), 0)


        productListViewModel.productList.observe(this.viewLifecycleOwner) { productList ->

            list.addAll(productList.data!!.toList())
            totalCount = productList.count!!
            if (previousItemCount < totalCount) {

                productslistBinding.rvProductList.also { rv ->
                    rv.adapter = ProductListAdapter(
                        requireContext(),
                        list
                    ) { name, url ->
                        moveToNextFragment(name,url)

                    }

                    previousItemCount = rv.adapter!!.itemCount
                    rv.adapter!!.notifyItemRangeInserted(previousItemCount,previousItemCount + productList.data.count())
                    productslistBinding.loadMoreLayout.visibility = View.GONE

                }

            }


        }

    }

    private fun moveToNextFragment(name: String, url: String) {
        val frag = ProductDetailsFragment()
        val args = Bundle()
        args.putString("productImage", url)
        args.putString("productName", name)
        frag.arguments = args
        fragmentManager!!.beginTransaction().add(R.id.main, frag)
            .addToBackStack(null).commit()
    }
}