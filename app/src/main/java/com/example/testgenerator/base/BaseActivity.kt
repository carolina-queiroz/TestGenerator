package com.example.testgenerator.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class BaseActivity <T : ViewDataBinding> : AppCompatActivity() {

    protected lateinit var bind: T

    var loadingBarDialog: LoadingBarDialog? = null

    @LayoutRes
    protected abstract fun getLayoutId(): Int

    protected abstract fun init()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        bind = DataBindingUtil.setContentView(this, getLayoutId())

        init()
    }

    fun hideLoading() {
        loadingBarDialog?.dismissAllowingStateLoss()

        loadingBarDialog = null
    }

    fun showLoading() {

        if (loadingBarDialog == null) {

            loadingBarDialog = LoadingBarDialog()

        }

        loadingBarDialog?.show(supportFragmentManager, null)

    }

}