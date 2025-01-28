package com.example.a6129.ui.viewmodel.client

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.a6129.models.Event
import com.example.a6129.repository.EventRepo
import kotlinx.coroutines.launch

class EventDetailVM(
    savedStateHandle: SavedStateHandle,
    private val acaraRepository: EventRepo
) : ViewModel() {
    private val id_acara: String = checkNotNull(savedStateHandle[DestinasiInsertAcara.ID_ACARA])

    var detailAcaraUiState: DetailAcaraUiState by mutableStateOf(DetailAcaraUiState())
        private set

    init {
        getAcaraById()
    }

    fun getAcaraById() {
        viewModelScope.launch {
            detailAcaraUiState = detailAcaraUiState.copy(isLoading = true) // Indicate loading state
            try {
                val result = acaraRepository.getAcaraById(id_acara)
                detailAcaraUiState = DetailAcaraUiState(
                    detailAcaraUiEvent = result.toDetailAcaraUiEvent(),
                    isLoading = false,
                    isError = false,
                    errorMessage = ""
                )
            } catch (e: Exception) {
                detailAcaraUiState = DetailAcaraUiState(
                    isLoading = false,
                    isError = true,
                    errorMessage = e.message ?: "Unknown error occurred"
                )
            }
        }
    }
}

data class DetailAcaraUiState(
    val detailAcaraUiEvent: AcaraUiEvent = AcaraUiEvent(),
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val errorMessage: String = ""
) {
    val isUiAcaraEmpty: Boolean
        get() = detailAcaraUiEvent == AcaraUiEvent()

    val isUiAcaraNotEmpty: Boolean
        get() = detailAcaraUiEvent != AcaraUiEvent()
}

data class AcaraUiEvent(
    val id_acara: String = "",
    val nama_acara: String = "",
    val deskripsi_acara: String = "",
    val tanggal_mulai: String = "",
    val tanggal_berakhir: String = "",
    val id_lokasi: String = "",
    val id_klien: String = "",
    val status_acara: String = ""
)

fun Event.toDetailAcaraUiEvent(): AcaraUiEvent {
    return AcaraUiEvent(
        id_acara = id_acara,
        nama_acara = nama_acara,
        deskripsi_acara = deskripsi_acara,
        tanggal_mulai = tanggal_mulai,
        tanggal_berakhir = tanggal_berakhir,
        id_lokasi = id_lokasi,
        id_klien = id_klien,
        status_acara = status_acara
    )
}