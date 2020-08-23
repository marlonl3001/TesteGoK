package br.com.mdr.testegok.api

import br.com.mdr.testegok.model.api.ProductsApiResponse
import retrofit2.Response
import retrofit2.http.GET

/**
 * @author Marlon D. Rocha
 * @since 21/08/20
 */
interface MainApi {
    companion object {
        private const val PRODUCTS_PATH = "products"
    }

    @GET(PRODUCTS_PATH)
    suspend fun getProducts(): Response<ProductsApiResponse>
}