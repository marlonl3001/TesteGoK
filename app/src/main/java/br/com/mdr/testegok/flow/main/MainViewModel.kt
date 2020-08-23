package br.com.mdr.testegok.flow.main

import androidx.lifecycle.MutableLiveData
import br.com.mdr.testegok.extensions.scopeWithErrorHandling
import br.com.mdr.testegok.flow.BaseViewModel
import br.com.mdr.testegok.flow.error.ErrorViewPresenter
import br.com.mdr.testegok.model.api.ProductsApiResponse
import br.com.mdr.testegok.model.business.Cash
import br.com.mdr.testegok.model.business.Product
import br.com.mdr.testegok.model.business.SpotLight
import br.com.mdr.testegok.throwable.AppThrowable
import kotlinx.coroutines.*

/**
 * @author Marlon D. Rocha
 * @since 21/08/20
 */
class MainViewModel(val handler: MainHandler): BaseViewModel() {
    val productsLive: MutableLiveData<MutableList<Product>> = MutableLiveData()
    val spotsLive: MutableLiveData<MutableList<SpotLight>> = MutableLiveData()
    val cashLive: MutableLiveData<Cash> = MutableLiveData()

    fun fetchProducts() {
        isLoading.postValue(true)

        val scope = scopeWithErrorHandling(this::showError)
        scope.launch {
            val response = handler.fetchProducts()
            fetchApiResult(response)
        }
    }

    private fun fetchApiResult(result: ProductsApiResponse) {
        isLoading.postValue(false)
        GlobalScope.launch {
            withContext(Dispatchers.Main) {
                result.products?.let { productsLive.value = it }
                result.spotlight?.let { spotsLive.value = it }
                result.cash?.let { cashLive.value = it }
            }
        }
    }

    private fun showError(throwable: AppThrowable) {
        isLoading.postValue(false)
        GlobalScope.launch {
            withContext(Dispatchers.Main) {
                val presenter = ErrorViewPresenter().withError(throwable.error)
                handler.mainPresenter.errorLive.value = presenter
            }
        }
    }
}