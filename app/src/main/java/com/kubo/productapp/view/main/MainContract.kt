package com.kubo.productapp.view.main

import com.kubo.productapp.view.base.BaseMvpPresenter
import com.kubo.productapp.view.base.BaseMvpView

interface MainContract {

    interface View : BaseMvpView {

        fun showProducts();

    }

    interface Presenter : BaseMvpPresenter<View> {

        fun showProducts();

    }

}