package com.example.a6129.repository

import com.example.a6129.models.Client

interface ClientRepo {
    suspend fun getKlien(): List<Client>
    suspend fun insertKlien(klien: Client)
    suspend fun updateKlien(id_klien: String, klien: Client)
    suspend fun deleteKlien(id_klien: String)
    suspend fun getKlienById(id_klien: String): Client
}

class NetworkClientRepository(
    private val clientService: ClientService) : ClientRepo {

    override suspend fun insertKlien(klien: Client) {
        clientService.insertKlien(klien)
    }

    override suspend fun updateKlien(id_klien: String, klien: Client) {
        clientService.updateKlien(id_klien, klien)
    }

    override suspend fun deleteKlien(id_klien: String) {
        try {
            val response = clientService.deleteKlien(id_klien)
            if (!response.isSuccessful) {
                throw Exception("Failed to delete klien. HTTP Status code: ${response.code()}")
            } else {
                response.message()
                println(response.message())
            }
        } catch (e: Exception) {
            throw e
        }
    }

    override suspend fun getKlien(): List<Client> = clientService.getKlien()

    override suspend fun getKlienById(id_klien: String): Client {
        try {
            return clientService.getKlienById(id_klien)
        } catch (e: Exception) {
            throw Exception("Failed to fetch client with ID: $id_klien. Network error occurred.", e)
        }
    }
}