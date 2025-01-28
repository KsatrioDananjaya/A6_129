package com.example.a6129.repository

import com.example.a6129.models.Event
import com.example.a6129.service.EventService

interface EventRepo {
    suspend fun getAcara(): List<Event>
    suspend fun insertAcara(acara: Event)
    suspend fun updateAcara(id_acara: String, acara: Event)
    suspend fun deleteAcara(id_acara: String)
    suspend fun getAcaraById(id_acara: String): Event
}

class NetworkEventRepository(private val eventService: EventService)
    : EventRepo
{

    override suspend fun getAcara(): List<Event> = eventService.getAcara()

    override suspend fun insertAcara(acara: Event) {
        eventService.insertAcara(acara)
        println(acara)
    }

    override suspend fun updateAcara(id_acara: String, acara: Event) {
        eventService.updateAcara(id_acara,acara)
    }

    override suspend fun deleteAcara(id_acara: String) {
        try {
            val response = eventService.deleteAcara(id_acara)
            if (!response.isSuccessful) {
                throw Exception("Failed to delete acara. HTTP Status Code: ${response.code()}")
            }
            else{
                response.message()
                println(response.message())
            }
        } catch (e: Exception) {
            throw e
        }
    }

    override suspend fun getAcaraById(id_acara: String): Event {
        return eventService.getAcaraById(id_acara)
    }
}