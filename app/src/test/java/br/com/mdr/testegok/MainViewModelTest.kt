package br.com.mdr.testegok

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import br.com.mdr.testegok.di.*
import br.com.mdr.testegok.extensions.getOrAwaitValue
import br.com.mdr.testegok.extensions.observeOnce
import br.com.mdr.testegok.flow.main.MainViewModel
import br.com.mdr.testegok.model.business.Product
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.setMain
import org.junit.*

import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.test.KoinTest
import org.koin.test.inject

@RunWith(JUnit4::class)
class MainViewModelTest: KoinTest {
    private val viewModel: MainViewModel by inject()

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @ExperimentalCoroutinesApi
    @Before
    fun setup() {
        Dispatchers.setMain(Dispatchers.Unconfined)
        startKoin {
            modules(
                listOf(
                    apiModule,
                    networkModule,
                    repositoryModule,
                    serviceModule,
                    viewModelModule,
                    presenterModule
                )
            )
        }
    }

    @After
    fun removeModules() {
        stopKoin()
    }

    @ExperimentalCoroutinesApi
    @Test
    fun `Verify if main request returns cash object`() = runBlockingTest {
        viewModel.fetchProducts()

        Assert.assertEquals(true, viewModel.cashLive.getOrAwaitValue() != null)
    }

    @ExperimentalCoroutinesApi
    @Test
    fun `Verify if cash returned by request differs from mock`() = runBlockingTest {
        viewModel.fetchProducts()

        val product = Product()
        product.description = "Null"
        product.imageURL = ""
        product.name = "Teste"

        Assert.assertNotEquals(product, viewModel.cashLive.getOrAwaitValue())
    }

    @ExperimentalCoroutinesApi
    @Test
    fun `Verify if cash object contains image url`() = runBlockingTest {
        viewModel.fetchProducts()

        viewModel.cashLive.observeOnce {
            Assert.assertEquals(true, it.bannerURL.isNotEmpty())
        }
    }
}