package com.shooter.drumncode_test.ui.main_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shooter.drumncode_test.data.network.MockRepository
import com.shooter.drumncode_test.data.network.MockResponse
import com.shooter.drumncode_test.domain.model_ui.SportModelUI
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModel @Inject constructor(
    private val mockRepository: MockRepository
): ViewModel() {
    private val _sportsState = MutableStateFlow(listOf<SportModelUI>())
    val sportsState: StateFlow<List<SportModelUI>> = _sportsState

    init {
        viewModelScope.launch {
            when(val response = mockRepository.getSports()) {
                is MockResponse.Failure -> {}
                is MockResponse.Success -> _sportsState.value = response.sports
            }
        }
    }
}