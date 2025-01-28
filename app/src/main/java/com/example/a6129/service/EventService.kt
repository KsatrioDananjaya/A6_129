package com.example.a6129.service

import com.example.a6129.models.Event
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Query

interface EventService {
    @Headers(
        "Accept: application/json",
        "Content-Type: application/json",
    )
    @GET("bacaacara.php")
    suspend fun getAcara(): List<Event>

    @GET("baca1acara.php/{id_acara}")
    suspend fun getAcaraById(@Query("id_acara") id_acara: String): Event

    @POST("insertacara.php")
    suspend fun insertAcara(@Body acara: Event)

    @PUT("editacara.php")
    suspend fun updateAcara(@Query("id_acara")id_acara: String, @Body acara: Event)

    @DELETE("deleteacara.php/{id_acara}")
    suspend fun deleteAcara(@Query("id_acara")id_acara: String): Response<Void>
}