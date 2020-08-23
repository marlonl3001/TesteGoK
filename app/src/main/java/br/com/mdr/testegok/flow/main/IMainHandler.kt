package br.com.mdr.testegok.flow.main

import br.com.mdr.testegok.flow.IMainPresenter
import br.com.mdr.testegok.service.IMainService

/**
 * @author Marlon D. Rocha
 * @since 21/08/20
 */

interface IMainHandler {
    val service: IMainService
    val mainPresenter: IMainPresenter
}
