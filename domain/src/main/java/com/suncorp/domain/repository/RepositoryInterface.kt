package com.suncorp.domain.repository

import com.suncorp.domain.model.models.Astronut
import com.suncorp.domain.model.models.AstronutResponse

interface RepositoryInterface {
    suspend fun getAstronuts(limit:Int): AstronutResponse
    suspend fun getAstronutDetail(id:Int) : Astronut
}