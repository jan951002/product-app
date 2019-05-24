package com.kubo.productapp.data.network.response

import com.kubo.productapp.data.model.Product

data class ProductResponse(var code: String, var data: List<Product>)