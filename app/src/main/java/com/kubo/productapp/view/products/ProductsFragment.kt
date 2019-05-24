package com.kubo.productapp.view.products

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.kubo.productapp.R
import com.kubo.productapp.data.model.Product
import com.kubo.productapp.util.IntentHelper

class ProductsFragment : Fragment(), ProductsContract.View, ProductAdapter.OnClickListener {

    var recyclerProduct: RecyclerView? = null

    var presenter: ProductsContract.Presenter? = null
    var productAdapter: ProductAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val itemView: View = inflater.inflate(R.layout.fragment_products, container, false)

        presenter = ProductsPresenter()
        presenter?.attachView(this)
        presenter?.getProducts()
        return itemView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerProduct = view.findViewById(R.id.recyclerProducts) as? RecyclerView
        recyclerProduct?.layoutManager = LinearLayoutManager(context, LinearLayout.VERTICAL, false)
    }

    override fun getContext(): Context {
        return activity?.applicationContext!!
    }

    override fun showProducts(products: List<Product>) {
        if (productAdapter == null) {
            productAdapter = ProductAdapter(products, this)
            recyclerProduct?.adapter = productAdapter
        } else {
            productAdapter?.notifyDataSetChanged()
        }

    }

    override fun showMessage(message: String) {
        println(message)
    }

    override fun showError(message: String) {
        println(message)
    }

    override fun onClick(product: Product) {
        IntentHelper.goToProductDetailActivity(activity as AppCompatActivity, product)
    }
}
