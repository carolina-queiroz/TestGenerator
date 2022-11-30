package com.example.testgenerator.view

import android.content.Intent
import androidx.activity.R
import com.example.testgenerator.base.BaseActivity
import com.example.testgenerator.databinding.ActivityHomeBinding
import com.example.testgenerator.viewmodel.HomeViewModel

class HomeActivity :  BaseActivity<ActivityHomeBinding>() {

    private val homeViewModel: HomeViewModel by viewModel()

    override fun getLayoutId(): Int {
        return R.layout.activity_home

    }

    override fun init() {
        bind.cardView.setOnClickListener { startActivity(Intent(this, SplashActivity::class.java)) }

       bind.
    }
}