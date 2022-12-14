package com.suncorp.domain.usecase

import com.suncorp.domain.repository.RepositoryInterface
import com.suncorp.domain.model.models.AstronutResponse
import javax.inject.Inject


class GetAllAstronutsUseCase  @Inject constructor(private val repository: RepositoryInterface) {
    suspend fun getAllPokemonNames(limit: Int): AstronutResponse = repository.getAstronuts(limit)
}