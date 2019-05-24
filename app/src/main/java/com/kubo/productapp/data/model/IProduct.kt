package com.kubo.productapp.data.model

import java.io.Serializable

interface IProduct : Serializable {
    fun getProductId(): String
}