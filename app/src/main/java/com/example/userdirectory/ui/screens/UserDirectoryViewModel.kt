package com.example.userdirectory.ui.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.userdirectory.network.DirectoryApi
import com.example.userdirectory.network.DirectoryApiService
import kotlinx.coroutines.launch
import java.io.IOException

sealed interface DirectoryUiState {
    data class Success(val userData: String) : DirectoryUiState
    object Error : DirectoryUiState
    object Loading : DirectoryUiState
}

class DirectoryViewModel : ViewModel() {
    var directoryUiState: DirectoryUiState by mutableStateOf(DirectoryUiState.Loading)
        private set

    init {
        getUserData()
    }

    fun getUserData() {
        viewModelScope.launch {
            try {
                val listResult = DirectoryApi.retrofitService.getUserData()
                DirectoryUiState.Success(listResult)
            } catch (e: IOException) {
                DirectoryUiState.Error
            }
        }
    }
}