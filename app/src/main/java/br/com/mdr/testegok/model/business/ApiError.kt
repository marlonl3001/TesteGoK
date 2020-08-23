package br.com.mdr.testegok.model.business

/**
 * @author Marlon D. Rocha
 * @since 21/08/20
 */

data class ApiError (
    val status: Int? = null,
    val title: String? = null,
    val detail: List<String>? = null
) {
    companion object {
        fun unknown() = ApiError(500, ErrorType.UNKNOWN.name)

        fun notFound() = ApiError(404, ErrorType.NOT_FOUND.name)
    }
}