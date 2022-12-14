package com.suncorp.domain.usecase

import com.suncorp.domain.model.models.Astronut
import com.suncorp.domain.repository.RepositoryInterface
import javax.inject.Inject


class GetAstronutDetailUsecase  @Inject constructor(private val repository: RepositoryInterface) {
    suspend fun getAstronutDetail(id:Int): Astronut = repository.getAstronutDetail(id)
}