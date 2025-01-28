package com.example.a6129.repository

import com.example.a6129.models.Client

interface ClientRepo {
    suspend fun getKlien(): List<Client>
    suspend fun insertKlien(klien: Client)
    suspend fun updateKlien(id_klien: String, klien: Client)
    suspend fun deleteKlien(id_klien: String)
    suspend fun getKlienById(id_klien: String): Client
}