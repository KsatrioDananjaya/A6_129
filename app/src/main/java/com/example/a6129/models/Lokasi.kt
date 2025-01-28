package com.example.a6129.models

import kotlinx.serialization.Serializable

@Serializable
data class Lokasi(
    val id_lokasi: String,
    val nama_lokasi: String,
    val alamat_lokasi: String,
    val kapasitas: String
)