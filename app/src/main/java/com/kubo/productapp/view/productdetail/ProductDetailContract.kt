package com.kubo.productapp.view.productdetail

import com.kubo.productapp.view.base.BaseMvpPresenter
import com.kubo.productapp.view.base.BaseMvpView

interface ProductDetailContract {

    interface View : BaseMvpView {

    }

    interface Presenter : BaseMvpPresenter<View> {

    }

}