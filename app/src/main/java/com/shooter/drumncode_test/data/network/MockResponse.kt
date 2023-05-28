package com.shooter.drumncode_test.data.network

import com.shooter.drumncode_test.domain.model_ui.SportModelUI

sealed class MockResponse {
    class Success(val sports: List<SportModelUI>): MockResponse()
    class Failure(val errorCode: Int, val message: String): MockResponse()
}
