package com.kubo.productapp.view.main

class MainPresenter : MainContract.Presenter {

    private var view: MainContract.View? = null

    override fun showProducts() {
        view?.showProducts()
    }

    override fun attachView(view: MainContract.View) {
        this.view = view
    }

    override fun detachView() {
        this.view = null
    }
}