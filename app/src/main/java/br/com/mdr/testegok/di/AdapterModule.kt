package br.com.mdr.testegok.di

import br.com.mdr.testegok.adapter.ProductsAdapter
import br.com.mdr.testegok.adapter.SpotlightsAdapter
import org.koin.dsl.module

/**
 * @author Marlon D. Rocha
 * @since 21/08/20
 */

val adapterModule = module {
    single { ProductsAdapter() }
    single { SpotlightsAdapter() }
}