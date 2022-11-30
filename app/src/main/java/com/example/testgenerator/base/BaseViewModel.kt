package com.example.testgenerator.base

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.Disposable

open class BaseViewModel : ViewModel() {

    var repositoryDisposable: Disposable? = null

    public override fun onCleared() {
        super.onCleared()
        repositoryDisposable?.dispose()
    }

}