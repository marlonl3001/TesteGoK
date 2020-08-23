package br.com.mdr.testegok.flow.error

import br.com.mdr.testegok.model.business.ApiError

/**
 * @author Marlon D. Rocha
 * @since 21/08/20
 */
interface IErrorViewPresenter {
    var error: ApiError?

    fun withError(error: ApiError?): IErrorViewPresenter
}