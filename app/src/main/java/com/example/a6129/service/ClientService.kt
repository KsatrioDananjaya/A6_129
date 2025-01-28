package com.example.a6129.service

import com.example.a6129.models.Client
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Query

interface ClientService {
    @Headers(
        "Accept: application/json",
        "Content-Type: application/json",
    )
    @GET("bacaklien.php")
    suspend fun getKlien(): List<Client>

    @GET("baca1klien.php/{id_klien}")
    suspend fun getKlienById(@Query("id_klien") id_klien: String): Client

    @POST("insertklien.php")
    suspend fun insertKlien(@Body klien: Client)

    @PUT("editklien.php")
    suspend fun updateKlien(@Query("id_klien")id_klien: String, @Body klien: Client)

    @DELETE("deletek  lien.php/{id_klien}")
    suspend fun deleteKlien(@Query("id_klien")id_klien: String): Response<Void>
}