package com.example.retrofitejemplo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.retrofitejemplo.viewmodel.ReporteViewModel
import com.example.retrofitejemplo.ui.theme.RetrofitEjemploTheme
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RetrofitEjemploTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    ReporteList()
                }
            }
        }
    }
}

@Composable
fun ReporteList(viewModel: ReporteViewModel = viewModel()) {
    val reportes = viewModel.reportes

    if (reportes.isEmpty()) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text("No hay reportes disponibles")
        }
    } else {
        LazyColumn(modifier = Modifier.padding(16.dp)) {
            items(reportes) { reporte ->
                Card(modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(text = "📢 ${reporte.title}", style = MaterialTheme.typography.titleMedium)
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(text = reporte.body)
                    }
                }
            }
        }
    }
}
