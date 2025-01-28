package com.example.a6129.models

import kotlinx.serialization.Serializable

@Serializable
data class Vendor (
    val id_vendor: String,
    val nama_vendor: String,
    val jenis_vendor: String,
    val kontak_vendor: String
)
