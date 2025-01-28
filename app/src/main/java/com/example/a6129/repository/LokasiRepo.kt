package com.example.a6129.repository

import com.example.a6129.models.Lokasi
import com.example.a6129.service.LokasiService

interface LokasiRepo {
    suspend fun getLokasi(): List<Lokasi>
    suspend fun insertLokasi(lokasi: Lokasi)
    suspend fun updateLokasi(id_lokasi: String, lokasi: Lokasi)
    suspend fun deleteLokasi(id_lokasi: String)
    suspend fun getLokasiById(id_lokasi: String): Lokasi
}

class NetworkLokasiRepository(private val lokasiService: LokasiService)
    : LokasiRepo
{
    override suspend fun getLokasi(): List<Lokasi> = lokasiService.getLokasi()

    override suspend fun insertLokasi(lokasi: Lokasi) {
        lokasiService.insertLokasi(lokasi)
    }

    override suspend fun updateLokasi(id_lokasi: String, lokasi: Lokasi) {
        lokasiService.updateLokasi(id_lokasi, lokasi)    }

    override suspend fun deleteLokasi(id_lokasi: String) {
        try {
            val response = lokasiService.deleteLokasi(id_lokasi)
            if (!response.isSuccessful) {
                throw Exception("Failed to delete lokasi. HTTP Status Code: ${response.code()}")
            }
            else{
                response.message()
                println(response.message())
            }
        } catch (e: Exception) {
            throw e
        }
    }

    override suspend fun getLokasiById(id_lokasi: String): Lokasi {
        return lokasiService.getLokasiById(id_lokasi)
    }
}