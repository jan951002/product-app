package com.kubo.productapp.data.network.api.product

import com.kubo.productapp.data.network.response.ProductResponse

open class ProductApiAdapter(java: Class<ProductApiAdapter>) : ProductApiListener {


    override fun onGetProductsSuccess(productResponse: ProductResponse) {

    }

    override fun onGetProuctsError(cause: String) {

    }
}