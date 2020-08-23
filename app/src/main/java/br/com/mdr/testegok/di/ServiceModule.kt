package br.com.mdr.testegok.di

import br.com.mdr.testegok.service.MainService
import org.koin.dsl.module

/**
 * @author Marlon D. Rocha
 * @since 21/08/20
 */

val serviceModule = module {
    single { MainService(get()) }
}