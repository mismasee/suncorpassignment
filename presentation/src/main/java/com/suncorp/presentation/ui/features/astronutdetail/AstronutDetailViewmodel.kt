package com.suncorp.presentation.ui.features.astronutdetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.suncorp.domain.model.models.Astronut
import com.suncorp.domain.usecase.GetAstronutDetailUsecase
import com.suncorp.presentation.util.DataState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AstronutDetailViewmodel
@Inject constructor(private val getAstronutDetailUsecase: GetAstronutDetailUsecase) : ViewModel() {

    private val _dataState: MutableLiveData<DataState<Astronut>> = MutableLiveData()

    val dataState: LiveData<DataState<Astronut>>
        get() = _dataState

    var astronutDetail:Astronut? = null

    fun getAstronutDetails(id:Int) {
        viewModelScope.launch {
            _dataState.value = DataState.Loading
            _dataState.value =
                DataState.Success(getAstronutDetailUsecase.getAstronutDetail(id))
        }

    }
}