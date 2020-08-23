package br.com.mdr.testegok.di

import br.com.mdr.testegok.flow.MainPresenter
import br.com.mdr.testegok.flow.error.ErrorViewPresenter
import br.com.mdr.testegok.flow.error.IErrorViewPresenter
import br.com.mdr.testegok.flow.main.MainHandler
import org.koin.dsl.module

/**
 * @author Marlon D. Rocha
 * @since 21/08/20
 */

val presenterModule = module {
    //Main
    single { MainHandler(get(), get()) }
    single { MainPresenter() }

    // Error
    single { ErrorViewPresenter() as IErrorViewPresenter }
}