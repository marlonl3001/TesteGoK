package br.com.mdr.testegok.repository

import br.com.mdr.testegok.api.MainApi
import br.com.mdr.testegok.model.api.ProductsApiResponse

/**
 * @author Marlon D. Rocha
 * @since 21/08/20
 */
class MainRepository(
    private val mainApi: MainApi
) : BaseRepository(), IMainRepository {

    override suspend fun getProducts(): ProductsApiResponse? {
        return handleResponse(mainApi.getProducts())
    }
}
