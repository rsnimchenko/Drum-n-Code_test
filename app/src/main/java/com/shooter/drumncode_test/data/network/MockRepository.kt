package com.shooter.drumncode_test.data.network

import com.shooter.drumncode_test.domain.model_api.toUI
import javax.inject.Inject

class MockRepository @Inject constructor(
    private val mockApi: MockApi
) {
    suspend fun getSports(): MockResponse {
        val response = mockApi.getSports()
        return if (response.isSuccessful) {
            val sports = response.body()
            MockResponse.Success(sports?.toUI() ?: listOf())
        } else MockResponse.Failure(
            errorCode = response.raw().code(),
            message = response.raw().message()
        )
    }
}