package com.example.a6129.repository

import com.example.a6129.models.Lokasi

interface LokasiRepo {
    suspend fun getLokasi(): List<Lokasi>
    suspend fun insertLokasi(lokasi: Lokasi)
    suspend fun updateLokasi(id_lokasi: String, lokasi: Lokasi)
    suspend fun deleteLokasi(id_lokasi: String)
    suspend fun getLokasiById(id_lokasi: String): Lokasi
}