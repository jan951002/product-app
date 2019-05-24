package com.kubo.productapp.view.products

import com.kubo.productapp.data.model.Product
import com.kubo.productapp.view.base.BaseMvpPresenter
import com.kubo.productapp.view.base.BaseMvpView

interface ProductsContract {

    interface View : BaseMvpView {

        fun showProducts(products: List<Product>)

    }

    interface Presenter : BaseMvpPresenter<View> {

        fun getProducts()

    }

}