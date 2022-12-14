package com.suncorp.presentation.ui.features.astronutlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.suncorp.R

import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AstronutListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigateToAstronutList()
    }

    private fun navigateToAstronutList() {
        supportFragmentManager.beginTransaction()
            .replace(
                R.id.container,
                AstronutsListFragment.newInstance(),
                AstronutsListFragment.FRAGMENT_NAME
            ).commitAllowingStateLoss()
    }


}