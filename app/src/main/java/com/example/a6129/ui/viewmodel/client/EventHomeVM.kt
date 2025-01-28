package com.example.a6129.ui.viewmodel.client

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import coil.network.HttpException
import com.example.a6129.models.Event
import com.example.a6129.repository.EventRepo
import kotlinx.coroutines.launch
import java.io.IOException

sealed class EventUiState {
    data class Success(val acara: List<Event>) : EventUiState()
    object Error : EventUiState()
    object Loading : EventUiState()
}

class EventHomeVM(acr1: SavedStateHandle, private val acr: EventRepo): ViewModel(){
    var acrUiState : EventUiState by mutableStateOf(EventUiState.Loading)
        private set

    init {
        getAcr()
    }

    fun getAcr(){
        viewModelScope.launch {
            acrUiState = EventUiState.Loading
            acrUiState = try {
                EventUiState.Success(acr.getAcara())
            }catch (e:Exception) {
                EventUiState.Error
            }catch (e:Exception) {
                EventUiState.Error
            }
        }
    }

    fun deleteAcr(id_acara:String) {
        viewModelScope.launch {
            try {
                acr.deleteAcara(id_acara)
            }catch(e: IOException){
                EventUiState.Error
            }catch (e: HttpException) {
                EventUiState.Error
            }
        }
    }
}
