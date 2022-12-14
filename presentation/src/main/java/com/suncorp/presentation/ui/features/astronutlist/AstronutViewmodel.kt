package com.suncorp.presentation.ui.features.astronutlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.suncorp.domain.model.models.Astronut
import com.suncorp.domain.model.models.AstronutResponse
import com.suncorp.domain.usecase.GetAllAstronutsUseCase
import com.suncorp.presentation.util.DataState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AstronutViewmodel
@Inject constructor(private val getAllAstronutsUseCase: GetAllAstronutsUseCase) : ViewModel() {

    private val _dataState: MutableLiveData<DataState<AstronutResponse>> = MutableLiveData()

    val dataState: LiveData<DataState<AstronutResponse>>
        get() = _dataState

    val astronutNameList: MutableList<Astronut> = mutableListOf()
    var aSorted = false


    fun getAllAstronuts() {
        viewModelScope.launch {
            _dataState.value = DataState.Loading
            _dataState.value =
                DataState.Success(getAllAstronutsUseCase.getAllPokemonNames(50))
        }

    }
}