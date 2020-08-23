package br.com.mdr.testegok.service

import br.com.mdr.testegok.model.api.ProductsApiResponse
import br.com.mdr.testegok.repository.MainRepository

class MainService(
    private val mainRepository: MainRepository
) : IMainService {

    override suspend fun getProducts(): ProductsApiResponse? {
        return mainRepository.getProducts()
    }

}