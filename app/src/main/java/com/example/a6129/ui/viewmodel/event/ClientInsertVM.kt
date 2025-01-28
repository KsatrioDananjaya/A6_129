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

class ClientInsertVM(
    klienRepository: SavedStateHandle,
    private val kln: ClientRepo
) : ViewModel() {
    var uiState by mutableStateOf(KlienUiState1())
        private set

    fun updateInsertKlnState(klienUiEvent: KlienUiEvent) {
        uiState = KlienUiState1(klienUiEvent = klienUiEvent)
    }

    fun insertKlien() {
        viewModelScope.launch {
            try {
                kln.insertKlien(uiState.klienUiEvent.toKln())
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}

data class KlienUiState1(
    val klienUiEvent: KlienUiEvent = KlienUiEvent(),
    val error: String? = null
)

data class KlienUiEvent(
    val id_klien: String = "",
    val nama_klien: String = "",
    val kontak_klien: String = "",
)

fun KlienUiEvent.toKln(): Client = Client(
    id_klien = id_klien,
    nama_klien = nama_klien,
    kontak_klien = kontak_klien
)

fun Client.toUiStateKln(): KlienUiEvent =  KlienUiEvent(
    id_klien = id_klien,
    nama_klien =  nama_klien,
    kontak_klien = kontak_klien
)