package com.kubo.productapp.view.main

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.kubo.productapp.R
import com.kubo.productapp.util.NetworkUtil
import com.kubo.productapp.view.products.ProductsFragment

class MainActivity : AppCompatActivity(), MainContract.View {

    private var productsFragment: ProductsFragment? = null
    private var presenter: MainContract.Presenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter = MainPresenter()
        presenter?.attachView(this)
        presenter?.showProducts()
    }

    override fun showProducts() {
        if (NetworkUtil.verifyAvailableNetwork(this)) {
            productsFragment = ProductsFragment()
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragmentContent, productsFragment!!)
            transaction.commit()
            showMessage("Conectado")
        } else {
            showMessage("No hay conexión a internet")
        }

    }

    override fun getContext(): Context {
        return this
    }

    override fun showMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun showError(message: String) {
        Toast.makeText(this, "Error: $message", Toast.LENGTH_SHORT).show()
    }

}
