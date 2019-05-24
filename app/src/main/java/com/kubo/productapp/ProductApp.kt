package com.kubo.productapp

import android.app.Application
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

open class ProductApp : Application() {

    companion object {

        @JvmField
        var appContext: ProductApp? = null

        @JvmStatic
        fun getAppContext(): ProductApp = appContext as ProductApp

        @JvmStatic
        fun getRetrofit(): Retrofit = Retrofit.Builder()
            .baseUrl("https://api.bazzaio.com/v5/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }

    override fun onCreate() {
        super.onCreate()
        appContext = this
    }

}