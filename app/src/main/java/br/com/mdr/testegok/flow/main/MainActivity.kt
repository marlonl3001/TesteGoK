package br.com.mdr.testegok.flow.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.mdr.testegok.R
import br.com.mdr.testegok.adapter.ProductsAdapter
import br.com.mdr.testegok.adapter.SpotlightsAdapter
import br.com.mdr.testegok.databinding.ActivityMainBinding
import br.com.mdr.testegok.di.*
import br.com.mdr.testegok.extensions.showSnackMessage
import com.squareup.picasso.Picasso
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.context.startKoin

class MainActivity : AppCompatActivity() {
    private val productsAdapter: ProductsAdapter by inject()
    private val spotsAdapter: SpotlightsAdapter by inject()
    private val viewModel: MainViewModel by viewModel()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupKoin()
        setupObservables()
        setupUI()
    }

    private fun setupUI() {
        binding.recyclerProducts.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.pagerSpots.adapter = spotsAdapter
        binding.recyclerProducts.adapter = productsAdapter
        viewModel.fetchProducts()

        val digio = getString(R.string.digio)
        val cash = getString(R.string.cash)
        val ss1 = SpannableString("$digio $cash")
        ss1.setSpan(
            ForegroundColorSpan(ContextCompat.getColor(this, R.color.colorAccent)),
            0, digio.length, 0)
        ss1.setSpan(
            ForegroundColorSpan(ContextCompat.getColor(this, R.color.grayA9A9A9)),
            digio.length + 1, ss1.length, 0)
        binding.txtDigio.append(ss1)
    }

    private fun setupObservables() {
        viewModel.isLoading.observe(this, Observer {
            GlobalScope.launch {
                withContext(Dispatchers.Main) { binding.showLoading = it }
            }
        })

        viewModel.handler.mainPresenter.errorLive.observe( this, Observer { presenter ->
            presenter?.error?.title?.let { showSnackMessage(it, binding.root) }
        })

        viewModel.cashLive.observe(this, Observer { cash ->
            cash?.let {
                Picasso.get().load(it.bannerURL).into(binding.imgCash)
            }
        })

        viewModel.productsLive.observe(this, Observer {
            it?.let { productsAdapter.replaceItens(it) }
        })

        viewModel.spotsLive.observe(this, Observer {
            it?.let { spotsAdapter.replaceItens(it) }
        })
    }

    private fun setupKoin() {
        startKoin {
            applicationContext
            modules(
                listOf(
                    adapterModule,
                    apiModule,
                    networkModule,
                    presenterModule,
                    repositoryModule,
                    serviceModule,
                    viewModelModule
                )
            )
        }
    }
}