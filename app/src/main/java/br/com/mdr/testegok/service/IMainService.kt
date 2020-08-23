package br.com.mdr.testegok.service

import br.com.mdr.testegok.model.api.ProductsApiResponse

interface IMainService {

    suspend fun getProducts(): ProductsApiResponse?

}