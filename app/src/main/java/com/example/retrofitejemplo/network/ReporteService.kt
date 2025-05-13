package com.example.retrofitejemplo.network

import com.example.retrofitejemplo.model.Reporte
import retrofit2.http.GET

interface ReporteService {
    @GET("posts")
    suspend fun getReportes(): List<Reporte>
}
