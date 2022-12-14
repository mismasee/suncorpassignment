package com.suncorp.data.repository

import com.suncorp.data.remote.api.APIInterface
import com.suncorp.domain.model.models.Astronut
import com.suncorp.domain.model.models.AstronutResponse
import com.suncorp.domain.repository.RepositoryInterface
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RepositoryImpl @Inject constructor(private val apiInterface: APIInterface) :
    RepositoryInterface {
    override suspend fun getAstronuts(limit: Int): AstronutResponse {
      return  apiInterface.getList(limit)
    }

    override suspend fun getAstronutDetail(id: Int): Astronut {
        return apiInterface.getAstronutDetail(id)
    }

}