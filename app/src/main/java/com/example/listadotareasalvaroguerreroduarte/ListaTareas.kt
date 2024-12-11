package com.example.listadotareasalvaroguerreroduarte

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ListaTareas(modifier: Modifier = Modifier) {
    val tareas = remember {
        mutableStateListOf(
            Tarea("Comprar leche", false),
            Tarea("Hacer ejercicio", true),
            Tarea("Estudiar Jetpack Compose", false),
            Tarea("Pagar facturas", false),
            Tarea("Limpiar la casa", true),
            Tarea("Llamar a mamá", false),
            Tarea("Leer un libro", false),
            Tarea("Ir al médico", true),
            Tarea("Preparar presentación", false),
            Tarea("Actualizar CV", false),
            Tarea("Practicar guitarra", true),
            Tarea("Pasear al perro", false),
            Tarea("Comprar regalos", true),
            Tarea("Aprender un idioma", false),
            Tarea("Organizar la semana", true)
        )
    }

    LazyColumn(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(tareas) { tarea ->
            TareaItem(tarea = tarea)
        }
    }
}

@Composable
fun TareaItem(tarea: Tarea) {
    var completada by remember { mutableStateOf(tarea.completada) }
    Card(
        border = BorderStroke(1.dp, Color.Black),
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable {
                completada = !completada
            }
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(8.dp)
        ) {

            Icon(
                imageVector = if (completada) Icons.Default.CheckCircle else Icons.Default.Clear,
                contentDescription = if (completada) "Completada" else "Pendiente",
                tint = if (completada) Color.Green else Color.Red,
                modifier = Modifier.size(24.dp)
            )

            Spacer(modifier = Modifier.width(16.dp))


            Text(
                text = tarea.nombre,
                modifier = Modifier.weight(1f)
            )
        }
    }
}

