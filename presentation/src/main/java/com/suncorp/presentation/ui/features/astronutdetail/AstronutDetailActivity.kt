package com.suncorp.presentation.ui.features.astronutdetail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import com.bumptech.glide.Glide
import com.suncorp.R
import com.suncorp.databinding.ActivityAstronutDetailBinding
import com.suncorp.presentation.base.BaseActivity
import com.suncorp.presentation.util.DataState
import com.suncorp.presentation.util.showToast
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AstronutDetailActivity : BaseActivity<AstronutDetailViewmodel,ActivityAstronutDetailBinding>() {

    companion object {
        private const val EXTRA_DATA = "extra_data"

        /**
         * Method is used to send Extra Data to the Activity and returning its intent
         * [context] is used to send Context of calling activity
         * [Astronut id] is the data parameter*/
        fun getStartIntent(
            context: Context,
            id:Int
        ) = Intent(context, AstronutDetailActivity::class.java).apply {
            putExtra(EXTRA_DATA, id)
        }
    }

    override val viewmodel:AstronutDetailViewmodel by viewModels ()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(viewBinding.root)

        subscribeObservers()
        viewmodel.getAstronutDetails(intent.getIntExtra(EXTRA_DATA,0))
    }

    override fun getBinding(): ActivityAstronutDetailBinding =
        ActivityAstronutDetailBinding.inflate(layoutInflater)


    /**
     * Method is used to observe viewmodel livedata
     * */
    private fun subscribeObservers() {
        viewmodel.dataState.observe(this, androidx.lifecycle.Observer { dataState ->
            when (dataState) {
                is DataState.Success -> if (dataState.data != null) {
                    viewmodel.astronutDetail = dataState.data
                    setAstronutData()
                }
                is DataState.Loading -> showToast(getString(R.string.loading_str))
                is DataState.Failure -> showToast(getString(R.string.something_went_wrong))
            }
        })
    }

    /** Set Astronut Data is used for setting Astronut Data on Astronut Detail Page* */
    private fun setAstronutData() {
        viewmodel.astronutDetail?.let {
            viewBinding.apply {
                Glide.with(this@AstronutDetailActivity)
                    .load(it.profile_image) // image url
                    .into(viewBinding.profileImage)


                tvName.text = it.name
                tvNationality.text = it.nationality
                tvDOB.text = it.date_of_birth
                tvBio.text = it.bio
                rootLayout.visibility = View.VISIBLE
            }

        }
    }
}