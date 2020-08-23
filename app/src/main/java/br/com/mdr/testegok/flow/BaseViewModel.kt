package br.com.mdr.testegok.flow

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * @author Marlon D. Rocha
 * @since 21/08/20
 */
open class BaseViewModel: ViewModel() {
    var isLoading: MutableLiveData<Boolean> = MutableLiveData(false)
}