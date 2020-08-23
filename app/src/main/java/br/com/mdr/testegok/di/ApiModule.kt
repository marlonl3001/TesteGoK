package br.com.mdr.testegok.di

import br.com.mdr.testegok.api.MainApi
import org.koin.dsl.module
import retrofit2.Retrofit

/**
 * @author Marlon D. Rocha
 * @since 21/08/20
 */

val apiModule = module {
    single { get<Retrofit>().create(MainApi::class.java) }

}