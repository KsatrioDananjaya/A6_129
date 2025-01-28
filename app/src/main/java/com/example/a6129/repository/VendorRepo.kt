package com.example.a6129.repository

import com.example.a6129.models.Vendor

interface VendorRepo {
    suspend fun getVendor(): List<Vendor>
    suspend fun insertVendor(vendor: Vendor)
    suspend fun updateVendor(id_vendor: String, vendor: Vendor)
    suspend fun deleteVendor(id_vendor: String)
    suspend fun getVendorById(id_vendor: String): Vendor
}