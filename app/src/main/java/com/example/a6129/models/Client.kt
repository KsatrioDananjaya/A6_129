package com.example.a6129.models

import kotlinx.serialization.Serializable

@Serializable
data class Client (
    val id_klien: String,
    val nama_klien: String,
    val kontak_klien: String,
)
