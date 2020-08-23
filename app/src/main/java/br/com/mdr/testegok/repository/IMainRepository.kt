package br.com.mdr.testegok.repository

import br.com.mdr.testegok.model.api.ProductsApiResponse

interface IMainRepository {
    suspend fun getProducts(): ProductsApiResponse?
}