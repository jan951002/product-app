package com.kubo.productapp.data.network.api.product

import com.kubo.productapp.ProductApp
import com.kubo.productapp.data.network.response.ProductResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

open class ProductApiClient {

    private var productApiListener: ProductApiListener? = null
    private var productApi: ProductApi? = null

    constructor(productApiListener: ProductApiListener) {
        this.productApiListener = productApiListener
        this.productApi = ProductApp.getRetrofit().create(ProductApi::class.java)
    }

    open fun getProducts() {

        productApi?.getProducts()?.enqueue(object : Callback<ProductResponse> {

            override fun onFailure(call: Call<ProductResponse>, t: Throwable) {
                productApiListener?.onGetProuctsError("Error al obtener los productos")
            }

            override fun onResponse(call: Call<ProductResponse>, response: Response<ProductResponse>) {
                if (response.code() == 200 && response.isSuccessful) {
                    productApiListener?.onGetProductsSuccess(response.body()!!)
                } else {
                    productApiListener?.onGetProuctsError("Error al obtener los productos")
                }
            }

        })
    }
}