package com.example.a6129.ui.viewmodel.lokasiviewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.a6129.models.Lokasi
import com.example.a6129.repository.LokasiRepo
import kotlinx.coroutines.launch


object DestinasiUpdateLokasi: DestinasiNavigasi {
    override val route = "update lokasi"
    const val ID_LOKASI = "id_lokasi"
    override val titleRes = "Detail Lokasi"
    val routeWithArg = "$route/{$ID_LOKASI}"
}

class UpdateLokasiViewModel(
    savedStateHandle: SavedStateHandle,
    private val lokasiRepository: LokasiRepo
) : ViewModel() {
    var updatelokasiUIState by mutableStateOf(LokasiUiState())
        private set
    private val _id_lokasi: String = checkNotNull(savedStateHandle[DestinasiUpdateLokasi.ID_LOKASI])

    init{
        viewModelScope.launch {
            updatelokasiUIState = lokasiRepository.getLokasiById(_id_lokasi)
                .toUIStateLokasi()
        }
    }
    fun updateInsertLksState(lokasiUiEvent: LokasiUiEvent) {
        updatelokasiUIState = LokasiUiState(lokasiUiEvent = lokasiUiEvent)
    }

    suspend fun updateLokasi() {
        try {
            lokasiRepository.updateLokasi(
                id_lokasi = _id_lokasi,
                lokasi = updatelokasiUIState.lokasiUiEvent.toLksi()
            )
        } catch (e: Exception) {
            updatelokasiUIState = updatelokasiUIState.copy(error = e.message)
        }
    }
}

fun Lokasi.toUIStateLokasi(): LokasiUiState = LokasiUiState(
    lokasiUiEvent = this.toDetailLokasiUiEvent(),
)