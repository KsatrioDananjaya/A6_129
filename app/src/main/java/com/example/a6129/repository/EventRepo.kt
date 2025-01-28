package com.example.a6129.repository

import com.example.a6129.models.Event

interface EventRepo {
    suspend fun getAcara(): List<Event>
    suspend fun insertAcara(acara: Event)
    suspend fun updateAcara(id_acara: String, acara: Event)
    suspend fun deleteAcara(id_acara: String)
    suspend fun getAcaraById(id_acara: String): Event
}