package com.suncorp.presentation.ui.features.astronutlist

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.suncorp.R
import com.suncorp.databinding.FragmentAstronutListBinding
import com.suncorp.domain.model.models.Astronut
import com.suncorp.presentation.adapters.AstronutListAdapter
import com.suncorp.presentation.base.BaseFragment
import com.suncorp.presentation.ui.features.astronutdetail.AstronutDetailActivity
import com.suncorp.presentation.util.DataState
import com.suncorp.presentation.util.showToast
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AstronutsListFragment : BaseFragment<AstronutViewmodel, FragmentAstronutListBinding>() {

    companion object {
        val FRAGMENT_NAME: String = AstronutsListFragment::class.java.name

        @JvmStatic
        fun newInstance() = AstronutsListFragment()
    }

    override fun getViewBinding() = FragmentAstronutListBinding.inflate(layoutInflater)
    override val viewmodel: AstronutViewmodel by viewModels ()
    private val adapter = AstronutListAdapter(this::onItemClicked)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
        subscribeObservers()
        getAstronutsData()

    }


    /**Method is used to initialize views* */
    private fun initView() {
        binding.run {
            rvAstronut.adapter = adapter
            sortBtn.setOnClickListener { sortItems() }
        }
    }

    /**
     * get Astronuts Data
     */
    private fun getAstronutsData() {
        viewmodel.getAllAstronuts()
    }

    /**
     * Method is used to observe viewmodel livedata
     * */
    private fun subscribeObservers() {
        viewmodel.dataState.observe(viewLifecycleOwner, androidx.lifecycle.Observer { dataState ->
            when (dataState) {
                is DataState.Success -> if (dataState.data?.results?.isNotEmpty() == true) {
                    viewmodel.astronutNameList.addAll(dataState.data.results!!)
                    adapter.submitList(viewmodel.astronutNameList)
                }
                is DataState.Loading -> activity?.showToast(getString(R.string.loading_str))
                is DataState.Failure -> activity?.showToast(getString(R.string.something_went_wrong))
            }
        })
    }

    private fun onItemClicked(astronut: Astronut) {
        context?.let {
            val intent = AstronutDetailActivity.getStartIntent(it, astronut.id?:0)
            startActivity(intent)
        }
    }

    private fun sortItems(){
        if(viewmodel.aSorted) {
            //Decending Sorting
            viewmodel.aSorted = false
            viewmodel.astronutNameList.sortByDescending { it.name }
        }else{
            //Ascending Sorting
            viewmodel.aSorted = true
            viewmodel.astronutNameList.sortBy { it.name }
        }
        adapter.notifyDataSetChanged()
    }

}