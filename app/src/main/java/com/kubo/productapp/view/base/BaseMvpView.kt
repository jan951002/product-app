package com.kubo.productapp.view.base

import android.content.Context
import android.support.annotation.StringRes

interface BaseMvpView {

    fun getContext(): Context

    fun showMessage(message: String)

    fun showError(message: String)

}