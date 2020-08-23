package br.com.mdr.testegok.flow

import androidx.lifecycle.MutableLiveData
import br.com.mdr.testegok.flow.error.IErrorViewPresenter

/**
 * @author Marlon D. Rocha
 * @since 21/08/20
 */

interface IMainPresenter {
    var isLoading: MutableLiveData<Boolean>
    val errorLive: MutableLiveData<IErrorViewPresenter?>

    fun showLoading(): IMainPresenter
    fun hideLoading(): IMainPresenter
}
