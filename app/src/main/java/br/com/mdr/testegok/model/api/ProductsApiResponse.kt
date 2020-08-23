package br.com.mdr.testegok.model.api

import br.com.mdr.testegok.model.business.Product
import br.com.mdr.testegok.model.business.SpotLight
import br.com.mdr.testegok.model.business.Cash

/**
 * @author Marlon D. Rocha
 * @since 21/08/20
 */
data class ProductsApiResponse(
    val spotlight: MutableList<SpotLight>? = null,
    val products: MutableList<Product>? = null,
    val cash: Cash? = null
)