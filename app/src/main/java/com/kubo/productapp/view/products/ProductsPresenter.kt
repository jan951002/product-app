package com.kubo.productapp.view.products

import com.kubo.productapp.data.network.api.product.ProductApiAdapter
import com.kubo.productapp.data.network.api.product.ProductApiClient
import com.kubo.productapp.data.network.api.product.ProductApiListener
import com.kubo.productapp.data.network.response.ProductResponse

class ProductsPresenter : ProductsContract.Presenter {

    var view: ProductsContract.View? = null
    var productApiClient: ProductApiClient? = null

    init {
        this.productApiClient = ProductApiClient(createdApiListener())
    }

    private fun createdApiListener(): ProductApiListener = object : ProductApiAdapter(ProductApiAdapter::class.java) {
        override fun onGetProductsSuccess(productResponse: ProductResponse) {
            super.onGetProductsSuccess(productResponse)
            view?.showProducts(productResponse.data)
        }

        override fun onGetProuctsError(cause: String) {
            super.onGetProuctsError(cause)
            view?.showMessage(cause)
        }
    }

    override fun attachView(view: ProductsContract.View) {
        this.view = view
    }

    override fun detachView() {
        this.view = null
    }

    override fun getProducts() {
        productApiClient?.getProducts()
    }
}