package com.example.a6129.dependenciesinjection

import com.example.a6129.repository.ClientRepo
import com.example.a6129.repository.EventRepo
import com.example.a6129.repository.LokasiRepo
import com.example.a6129.repository.NetworkClientRepository
import com.example.a6129.repository.NetworkEventRepository
import com.example.a6129.repository.NetworkLokasiRepository
import com.example.a6129.repository.NetworkVendorRepository
import com.example.a6129.repository.VendorRepo
import com.example.a6129.service.ClientService
import com.example.a6129.service.EventService
import com.example.a6129.service.LokasiService
import com.example.a6129.service.VendorService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

interface AppContainer {
    val vendorRepository : VendorRepo
    val lokasiRepository: LokasiRepo
    val klienRepository: ClientRepo
    val acaraRepository: EventRepo
}

class ContainerApp : AppContainer {
    private val baseUrl = "http://10.0.2.2:8090/umyTI/"
    private val json = Json { ignoreUnknownKeys = true}
    private val retrofit: Retrofit = Retrofit.Builder()

        .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
        .baseUrl(baseUrl)
        .build()

    private val acaraService: EventService by lazy {
        retrofit.create(EventService::class.java)
    }
    override val acaraRepository: EventRepo by lazy {
        NetworkEventRepository (acaraService)
    }
    private val lokasiService: LokasiService by lazy {
        retrofit.create(LokasiService::class.java)
    }

    override val lokasiRepository: LokasiRepo by lazy {
        NetworkLokasiRepository (lokasiService)
    }
    private val klienService: ClientService by lazy {
        retrofit.create(ClientService::class.java)
    }
    override val klienRepository: ClientRepo by lazy {
        NetworkClientRepository (klienService)
    }

    private val vendorService: VendorService by lazy {
        retrofit.create(VendorService::class.java)
    }
    override val vendorRepository: VendorRepo by lazy {
        NetworkVendorRepository (vendorService)
    }
}