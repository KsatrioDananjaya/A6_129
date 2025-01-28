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

class ClientUpdateVM (
    savedStateHandle: SavedStateHandle,
    private val kln: ClientRepo
): ViewModel(){
    var updateUiState by mutableStateOf(KlienUiState1())
        private set

    private val _id_klien : String = checkNotNull(savedStateHandle[DestinasiUpdateKlien.ID_KLIEN])

    init {
        viewModelScope.launch {
            updateUiState = kln.getKlienById(_id_klien)
                .toUIStateKln()
        }
    }

    fun updateInsertKlnState(klienUiEvent: KlienUiEvent){
        updateUiState = KlienUiState1(klienUiEvent = klienUiEvent)
    }

    suspend fun updateKln(){
        viewModelScope.launch {
            try {
                kln.updateKlien(_id_klien, updateUiState.klienUiEvent.toKln())
            }catch (e: Exception){
                e.printStackTrace()
            }
        }
    }
}