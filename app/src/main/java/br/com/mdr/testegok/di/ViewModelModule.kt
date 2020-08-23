package br.com.mdr.testegok.di

import br.com.mdr.testegok.flow.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * @author Marlon D. Rocha
 * @since 21/08/20
 */

val viewModelModule = module {
    viewModel { MainViewModel(handler = get()) }

}