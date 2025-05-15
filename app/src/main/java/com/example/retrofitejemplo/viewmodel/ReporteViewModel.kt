package com.example.retrofitejemplo.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofitejemplo.model.Reporte
import com.example.retrofitejemplo.network.RetrofitClient
import kotlinx.coroutines.launch
import androidx.compose.runtime.*

class ReporteViewModel : ViewModel() {
    var reportes by mutableStateOf<List<Reporte>>(emptyList())
        private set

    init {
        viewModelScope.launch {
            try {
                val respuesta = RetrofitClient.api.getReportes()
                println("✔ Se obtuvieron ${respuesta.size} reportes")
                reportes = respuesta
            } catch (e: Exception) {
                println("❌ Error: ${e.message}")
                e.printStackTrace()
            }
        }
    }
}
