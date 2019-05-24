package com.kubo.productapp.data.network.api.product

import com.kubo.productapp.data.network.response.ProductResponse
import retrofit2.Call
import retrofit2.http.GET

interface ProductApi {

    @GET("listados/listar_productos_tienda/298/0/0")
    fun getProducts(): Call<ProductResponse>
}