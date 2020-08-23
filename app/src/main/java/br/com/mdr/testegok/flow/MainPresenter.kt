package br.com.mdr.testegok.flow

import androidx.lifecycle.MutableLiveData
import br.com.mdr.testegok.flow.error.IErrorViewPresenter

/**
 * @author Marlon D. Rocha
 * @since 21/08/20
 */

class MainPresenter : IMainPresenter {
    override var isLoading: MutableLiveData<Boolean> = MutableLiveData(false)

    override val errorLive: MutableLiveData<IErrorViewPresenter?> = MutableLiveData()

    override fun showLoading(): IMainPresenter = apply {
        this.isLoading.postValue(true)
    }

    override fun hideLoading(): IMainPresenter = apply {
        this.isLoading.postValue(false)
    }
}
