package br.com.mdr.testegok.di

import br.com.mdr.testegok.repository.MainRepository
import org.koin.dsl.module

/**
 * @author Marlon D. Rocha
 * @since 21/08/20
 */

val repositoryModule = module {
    single { MainRepository(get()) }
}