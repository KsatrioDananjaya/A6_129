package com.example.a6129.ui.viewmodel.event

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.a6129.models.Client
import com.example.a6129.repository.ClientRepo
import kotlinx.coroutines.launch
import java.io.IOException

sealed class ClientUiState {
    data class Success(val klien: List<Client>) : ClientUiState()
    object Error : ClientUiState()
    object Loading : ClientUiState()
}

class KlienHomeVM(
    klienRepository1: SavedStateHandle,
    private val klienRepository: ClientRepo
) : ViewModel() {

    var KUiState: ClientUiState by mutableStateOf(ClientUiState.Loading)
        private set

    init {
        getKln()
    }

    fun getKln() {
        viewModelScope.launch {
            KUiState = ClientUiState.Loading
            try {
                val klienList = klienRepository.getKlien()
                KUiState = ClientUiState.Success(klienList)
            } catch (e: IOException) {
                KUiState = ClientUiState.Error
            } catch (e: Exception) {
                KUiState = ClientUiState.Error
            }
        }
    }

    fun deleteKln(id_klien: String) {
        viewModelScope.launch {
            try {
                klienRepository .deleteKlien(id_klien)
                getKln()
            } catch (e: IOException) {
                KUiState = ClientUiState.Error
            } catch (e: Exception) {
                KUiState = ClientUiState.Error
            }
        }
    }
}