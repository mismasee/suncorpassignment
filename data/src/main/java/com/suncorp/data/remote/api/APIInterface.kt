package com.suncorp.data.remote.api

import com.suncorp.data.util.GET_ASTRONAUT_DETAIL
import com.suncorp.data.util.GET_ASTRONAUT_LIST
import com.suncorp.domain.model.models.Astronut
import com.suncorp.domain.model.models.AstronutResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface APIInterface {
    @GET(GET_ASTRONAUT_LIST)
    suspend fun getList(
        @Query("limit") limit: Int
    ): AstronutResponse

    @GET(GET_ASTRONAUT_DETAIL)
    suspend fun getAstronutDetail(
        @Path("id") id: Int
    ): Astronut
}