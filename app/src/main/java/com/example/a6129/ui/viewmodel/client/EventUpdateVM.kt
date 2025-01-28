package com.example.a6129.ui.viewmodel.client

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.a6129.models.Client
import com.example.a6129.models.Lokasi
import com.example.a6129.repository.ClientRepo
import com.example.a6129.repository.EventRepo
import com.example.a6129.repository.LokasiRepo
import kotlinx.coroutines.launch

class AcaraUpdateVM(
    savedStateHandle: SavedStateHandle,
    private val acaraRepository: EventRepo,
    private val lokasiRepository: LokasiRepo,
    private val klienRepository: ClientRepo,
) : ViewModel() {

    var lokasilist by mutableStateOf(listOf<Lokasi>())
        private set

    var klienlist by mutableStateOf(listOf<Client>())
        private set

    var uiState by mutableStateOf(InsertAcaraUiState())
        private set

    private val _id_acara: String = checkNotNull(savedStateHandle[DestinasiUpdateAcara.ID_ACARA])

    init {
        fetchDropdownData()
        loadAcaraData()
    }

    private fun fetchDropdownData() {
        viewModelScope.launch {
            try {
                lokasilist = lokasiRepository.getLokasi()
                Log.d("DropdownData", "Lokasi List: $lokasilist")
                klienlist = klienRepository.getKlien()
                Log.d("DropdownData", "Klien List: $klienlist")
            } catch (e: Exception) {
                Log.e("DropdownData", "Error fetching data: ${e.message}")
            }
        }
    }

    private fun loadAcaraData() {
        viewModelScope.launch {
            try {
                val acara = acaraRepository.getAcaraById(_id_acara)
                uiState = InsertAcaraUiState(insertUiEvent = acara.toInsertUiEvent())
                Log.d("AcaraData", "Acara loaded: $acara")
            } catch (e: Exception) {
                Log.e("AcaraData", "Error loading acara data: ${e.message}")
            }
        }
    }

    fun updateInsertAcaraState(insertUiEvent: InsertAcaraUiEvent) {
        uiState = InsertAcaraUiState(insertUiEvent = insertUiEvent)
    }

    suspend fun updateAcara() {
        viewModelScope.launch {
            try {
                Log.d("Retrofit", "Data dikirim: ${uiState.insertUiEvent.toAcara()}")
                val response = acaraRepository.updateAcara(_id_acara, uiState.insertUiEvent.toAcara())
                Log.d("Retrofit", "Response: $response")
            } catch (e: Exception) {
                e.printStackTrace()
                Log.e("Retrofit", "Error: ${e.message}")
            }
        }
    }
}