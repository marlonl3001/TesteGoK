package br.com.mdr.testegok.flow.main

import br.com.mdr.testegok.flow.MainPresenter
import br.com.mdr.testegok.model.api.ProductsApiResponse
import br.com.mdr.testegok.service.MainService

class MainHandler(
    override val service: MainService,
    override val mainPresenter: MainPresenter
) : IMainHandler {

    suspend fun fetchProducts(): ProductsApiResponse {
        var response = ProductsApiResponse()

        service.getProducts()?.let {
            response = it
        }
        return response
    }

}
