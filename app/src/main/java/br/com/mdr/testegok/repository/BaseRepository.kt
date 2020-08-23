package br.com.mdr.testegok.repository

import retrofit2.Response

/**
 * @author Marlon D. Rocha
 * @since 21/08/20
 */

abstract class BaseRepository {

    protected fun <T> handleResponse(response: Response<T>): T? {
        return response.body()
    }
}