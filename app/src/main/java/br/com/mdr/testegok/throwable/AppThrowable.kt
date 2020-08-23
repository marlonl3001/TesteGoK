package br.com.mdr.testegok.throwable

import br.com.mdr.testegok.model.business.ApiError
import retrofit2.HttpException

class AppThrowable(
    val error: ApiError
) : Throwable() {

    companion object {

        fun fromHttpException(httpException: HttpException): AppThrowable {
            return when (httpException.code()) {
                404 -> AppThrowable(notFoundError())
                else -> AppThrowable(unknownError())
            }
        }

        fun fromUnknownHostException(): AppThrowable = AppThrowable(notFoundError())

        fun fromThrowable(t: Throwable) = AppThrowable(unknownError())

        private fun notFoundError() = ApiError.notFound()

        private fun unknownError() = ApiError.unknown()
    }
}