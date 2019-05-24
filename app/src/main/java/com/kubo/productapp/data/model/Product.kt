package com.kubo.productapp.data.model

data class Product(
    var categoria: String, var cliente: String, var colores: String, var descripcion: String,
    var disponible: String, var estado: String, var fecha_creacion: String, var id: String,
    var nombre: String, var precio: String, var tallas: String, var video: String,
    var decripcion: String, var id_promocion: String, var valor_promo: String,
    var id_producto_promo: String, var fecha_promo: String, var estado_promo: String,
    var likes: String, var megusta: String, var galeria: String, var imagen: String
): IProduct {
    override fun getProductId(): String = id
}