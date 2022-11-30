package com.example.testgenerator.base

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import com.example.testgenerator.R
import com.example.testgenerator.databinding.DialogLoadingBinding
import java.util.*

class LoadingBarDialog : DialogFragment() {

    lateinit var bind: DialogLoadingBinding
    private var shown = false

    override fun onStart() {
        super.onStart()

        dialog?.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        bind = DataBindingUtil.inflate(inflater, R.layout.dialog_loading, container, false)
        with(Objects.requireNonNull<Window>(dialog?.window))
        {
            setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            attributes.windowAnimations = R.style.DialogAnimation
        }

        isCancelable = false

        return bind.root

    }

    fun removeFromFragment(manager: FragmentManager) {
        val fragment = manager.findFragmentByTag(LOADING_TAG)
        if (fragment != null) {
            manager.beginTransaction().remove(fragment).commitAllowingStateLoss()
        }
    }

    override fun show(manager: FragmentManager, tag: String?) {
        if (shown || isVisible || isAdded) return
        removeFromFragment(manager)
        try {
            manager.beginTransaction().add(this, LOADING_TAG).commitAllowingStateLoss()
        } catch (e: Exception) {
            removeFromFragment(manager)
        }
        shown = true
    }

    override fun dismiss() {
        if (!shown || !isVisible) return

        shown = false
        super.dismissAllowingStateLoss()
    }

    companion object {
        private const val LOADING_TAG = "loading-tag"
    }

}