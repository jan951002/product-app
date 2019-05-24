package com.kubo.productapp.view.products

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.kubo.productapp.ProductApp
import com.kubo.productapp.R
import com.kubo.productapp.data.model.Product
import com.squareup.picasso.Picasso
import jp.wasabeef.picasso.transformations.CropCircleTransformation
import jp.wasabeef.picasso.transformations.MaskTransformation


class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    var labProductName: TextView? = null
    var labProductDescription: TextView? = null
    var labProductPrice: TextView? = null
    var productPhoto: ImageView? = null

    init {
        labProductName = itemView.findViewById(R.id.labProductName)
        labProductDescription = itemView.findViewById(R.id.labProductDescription)
        labProductPrice = itemView.findViewById(R.id.labProductPrice)
        productPhoto = itemView.findViewById(R.id.product_photo)
    }

    fun bind(product: Product, listener: ProductAdapter.OnClickListener) {
        val price = "$" + product.precio
        labProductName?.text = product.nombre
        labProductDescription?.text = product.descripcion
        labProductPrice?.text = price
        Picasso.get().load(product.imagen).transform(CropCircleTransformation()).into(productPhoto)

        itemView.setOnClickListener { listener.onClick(product) }
    }

}