package com.example.a6129.ui.viewmodel.lokasiviewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import coil.network.HttpException
import com.example.a6129.models.Lokasi
import com.example.a6129.repository.LokasiRepo
import kotlinx.coroutines.launch
import java.io.IOException

sealed class LokasUiState {
    data class Success(val lokasi: List<Lokasi>) : LokasUiState()
    object Error : LokasUiState()
    object Loading : LokasUiState()
}

class LokasiViewModel(lks1: SavedStateHandle, private val lks: LokasiRepo): ViewModel(){
    var lksUiState : LokasUiState by mutableStateOf(LokasUiState.Loading)
        private set

    init {
        getLks()
    }

    fun getLks(){
        viewModelScope.launch {
            lksUiState = LokasUiState.Loading
            lksUiState = try {
                LokasUiState.Success(lks.getLokasi())
            }catch (e:Exception) {
                LokasUiState.Error
            }catch (e:Exception) {
                LokasUiState.Error
            }
        }
    }

    fun deleteLks(id_lokasi:String) {
        viewModelScope.launch {
            try {
                lks.deleteLokasi(id_lokasi)
            }catch(e:IOException){
                LokasUiState.Error
            }catch (e:HttpException) {
                LokasUiState.Error
            }
        }
    }
}