package com.kubo.productapp.view.products

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.kubo.productapp.R
import com.kubo.productapp.data.model.Product
import java.text.FieldPosition

class ProductAdapter(private val products: List<Product>, private val listener: OnClickListener) :
    RecyclerView.Adapter<ProductViewHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ProductViewHolder {
        val itemView = LayoutInflater.from(p0.context).inflate(R.layout.product_item_view, p0, false)
        return ProductViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return products.size
    }

    override fun onBindViewHolder(p0: ProductViewHolder, p1: Int) {
        p0.bind(products[p1], listener)
    }

    interface OnClickListener {
        fun onClick(product: Product)
    }
}