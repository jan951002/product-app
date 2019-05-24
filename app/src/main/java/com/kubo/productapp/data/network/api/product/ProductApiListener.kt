package com.kubo.productapp.data.network.api.product

import com.kubo.productapp.data.network.response.ProductResponse

interface ProductApiListener {

    fun onGetProductsSuccess(productResponse: ProductResponse)
    fun onGetProuctsError(cause: String)
}