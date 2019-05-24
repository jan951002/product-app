package com.kubo.productapp.util

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.kubo.productapp.ProductApp
import com.kubo.productapp.R
import com.kubo.productapp.data.model.Product
import com.kubo.productapp.view.productdetail.ProductDetailActivity

class IntentHelper {

    companion object {

        @JvmStatic
        fun goToProductDetailActivity(fromActivity: AppCompatActivity, product: Product?) {
            val intent = Intent(ProductApp.appContext, ProductDetailActivity::class.java)
            val options = ActivityOptions.makeCustomAnimation(
                ProductApp.appContext,
                android.R.anim.slide_in_left,
                android.R.anim.slide_out_right
            )
            intent.putExtra("product", product)
            fromActivity.startActivity(intent, options.toBundle())
        }

    }

}