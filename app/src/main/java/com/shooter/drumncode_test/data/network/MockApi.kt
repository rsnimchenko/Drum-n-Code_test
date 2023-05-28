package com.shooter.drumncode_test.data.network

import com.shooter.drumncode_test.domain.model_api.SportModelAPI
import retrofit2.Response
import retrofit2.http.GET

interface MockApi {
    @GET("api/v1/demo")
    suspend fun getSports(): Response<List<SportModelAPI>>
}