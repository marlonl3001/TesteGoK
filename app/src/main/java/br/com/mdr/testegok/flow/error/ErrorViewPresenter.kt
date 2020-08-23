package br.com.mdr.testegok.flow.error

import br.com.mdr.testegok.model.business.ApiError

/**
 * @author Marlon D. Rocha
 * @since 21/08/20
 */

class ErrorViewPresenter(
    override var error: ApiError? = null
) : IErrorViewPresenter {

    override fun withError(error: ApiError?): IErrorViewPresenter {
        error?.let {
            this.error = it
        }
        return this
    }
}
