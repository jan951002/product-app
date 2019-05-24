package com.kubo.productapp.view.productdetail

import android.app.Activity
import android.nfc.tech.TagTechnology
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.kubo.productapp.R
import com.kubo.productapp.data.model.Product
import com.squareup.picasso.Picasso
import jp.wasabeef.picasso.transformations.CropCircleTransformation

class ProductDetailActivity : Activity() {

    var labProductName: TextView? = null
    var labProductDescription: TextView? = null
    var labProductPrice: TextView? = null
    var productPhoto: ImageView? = null

    var labProductId: TextView? = null
    var labProductCategory: TextView? = null
    var labProductClient: TextView? = null
    var labProductState: TextView? = null
    var labProductDate: TextView? = null
    var labProductLikes: TextView? = null

    var labPromotionId: TextView? = null
    var labPromotionPrice: TextView? = null
    var labPromotionDate: TextView? = null
    var labPromotionState: TextView? = null

    var product: Product? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_detail)

        labProductName = findViewById(R.id.labProductName)
        labProductDescription = findViewById(R.id.labProductDescription)
        labProductPrice = findViewById(R.id.labProductPrice)
        productPhoto = findViewById(R.id.product_photo)

        labProductId = findViewById(R.id.labProductId)
        labProductCategory = findViewById(R.id.labProductCategory)
        labProductClient = findViewById(R.id.labProductClient)
        labProductState = findViewById(R.id.labProductState)
        labProductDate = findViewById(R.id.labProductDate)
        labProductLikes = findViewById(R.id.labProductLikes)

        labPromotionId = findViewById(R.id.labPromotionId)
        labPromotionPrice = findViewById(R.id.labPromotionPrice)
        labPromotionDate = findViewById(R.id.labPromotionDate)
        labPromotionState = findViewById(R.id.labPromotionState)

        product = intent.getSerializableExtra("product") as Product

        if (product != null) {
            setHeaderData()
            setDetailData()
            setPromData()
        }

    }

    private fun setHeaderData() {
        val price = "$" + product?.precio
        labProductName?.text = product?.nombre
        labProductDescription?.text = product?.descripcion
        labProductPrice?.text = price
        Picasso.get().load(product?.imagen).transform(CropCircleTransformation()).into(productPhoto)
    }

    fun setDetailData() {
        val id = "Id: ${product?.id}"
        val category = "Categoría: ${product?.categoria}"
        val client = "Cliente: ${product?.cliente}"
        val state = "Estado: ${product?.estado}"
        val date = "Fecha creación: ${product?.fecha_creacion}"
        val likes = "Likes: ${product?.likes}"
        labProductId?.text = id
        labProductCategory?.text = category
        labProductClient?.text = client
        labProductState?.text = state
        labProductDate?.text = date
        labProductLikes?.text = likes
    }

    fun setPromData() {
        val promotionId = "Id Promoción: ${product?.id_promocion}"
        val promotionPrice = "Valor Promoción: ${product?.valor_promo}"
        val promotionDate = "Fecha Promoción: ${product?.fecha_promo}"
        val promotionSate = "Esrado Promoción: ${product?.estado_promo}"
        labPromotionId?.text = promotionId
        labPromotionPrice?.text = promotionPrice
        labPromotionDate?.text = promotionDate
        labPromotionState?.text = promotionSate
    }
}
