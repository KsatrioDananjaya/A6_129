package com.example.a6129.models

import kotlinx.serialization.Serializable

@Serializable
data class Event(
    val id_acara: String,
    val nama_acara: String,
    val deskripsi_acara: String,
    val tanggal_mulai: String,
    val tanggal_berakhir: String,
    val id_lokasi: String,
    val id_klien: String,
    val status_acara: String
)
