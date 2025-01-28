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

object DestinasiDetailKlien: DestinasiNavigasi {
    override val route = "detail klien"
    const val ID_KLIEN = "id_klien"
    override val titleRes = "Detail Klien"
    val routeWithArg = "$route/{$ID_KLIEN}"
}

class ClientDetailVM(
    savedStateHandle: SavedStateHandle,
    private val klienRepository: ClientRepo
) : ViewModel() {
    val id_klien: String = checkNotNull(savedStateHandle[DestinasiDetailKlien.ID_KLIEN])

    var detailKlienUiState: DetailKlienUiState by mutableStateOf(DetailKlienUiState())
        private set

    init {
        getKlienById()
    }

    fun getKlienById() {
        viewModelScope.launch {
            detailKlienUiState = DetailKlienUiState(isLoading = true)
            try {
                val result = klienRepository.getKlienById(id_klien)
                detailKlienUiState = DetailKlienUiState(
                    detailKlienUiEvent = result.toDetailKlienUiEvent(),
                    isLoading = false
                )
            } catch (e: Exception) {
                detailKlienUiState = DetailKlienUiState(
                    isLoading = false,
                    isError = true,
                    errorMessage = e.message ?: "Unknown error occurred"
                )
            }
        }
    }
}


data class DetailKlienUiState(
    val detailKlienUiEvent: KlienUiEvent = KlienUiEvent(),
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val errorMessage: String = ""
){
    val isUiKlienEmpty: Boolean
        get() = detailKlienUiEvent == KlienUiEvent()

    val isUiKlienNotEmpty: Boolean
        get() = detailKlienUiEvent != KlienUiEvent()
}

fun Client.toDetailKlienUiEvent(): KlienUiEvent {
    return KlienUiEvent(
        id_klien = id_klien,
        nama_klien = nama_klien ,
        kontak_klien = kontak_klien
    )
}