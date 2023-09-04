package com.example.lab_5.Pantallas.Conciertos

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.DragInteraction
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.InspectableModifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.lab5mariavillafuerte.Pantallas.Conciertos.model.Evento_2
import com.example.lab5mariavillafuerte.ui.theme.Lab5MariaVillafuerteTheme


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Concierto(){
    val total_eventos_1 = remember {
        mutableStateListOf(
            Evento_2(
                "Evento 1",
                "Descripcion 1",
                "https://www.guatemala.com/fotos/2020/03/Jardines-para-eventos-en-Guatemala.jpg",
            ),
            Evento_2(
                "Evento 2",
                "Descripcion 2",
                "https://blog.dushow-spain.com/hubfs/Header%20Image%20-%20CON%20Logo/discurso%20apertura%20eventos.jpg"
            ),
            Evento_2(
                "Evento 3",
                "Descripcion 3",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ5wCfNYTJm1udCGwKE-i7qHVWXGING2GQcYg&usqp=CAU"
            ),
            Evento_2(
                "Evento 4",
                "Descripcion 4",
                "https://eventoslatam.com/wordpress/wp-content/uploads/2023/07/publi-igloolab-1-633x380@2x.jpg"
            ),
        )
    }
    val total_eventos_2 = remember {
        mutableStateListOf(
            Evento_2(
                "Evento 3",
                "Descripcion 3",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ5wCfNYTJm1udCGwKE-i7qHVWXGING2GQcYg&usqp=CAU"
            ),
            Evento_2(
                "Evento 1",
                "Descripcion 1",
                "https://www.guatemala.com/fotos/2020/03/Jardines-para-eventos-en-Guatemala.jpg",
            ),
        )
    }
    Column() {
        TopAppBar(
            //windowInsets = AppBarDefaults.topAppBarWindowInsets,
            modifier = Modifier.padding(start = 30.dp)
                .background(Color.Gray),
            title = { Text("Todo Eventos") },
            actions = {
                // RowScope here, so these icons will be placed horizontally
                IconButton(onClick = { /* doSomething() */ }) {
                    Icon(Icons.Filled.Menu, contentDescription = "Localized description")
                }
            }
        )
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
        ) {
            item(span = { GridItemSpan(maxLineSpan) }){
                Text(text = "Your Favorites", fontSize = 18.sp,
                    modifier = Modifier.padding(start = 20.dp, bottom = 5.dp))
            }
            items(total_eventos_1.size) { event ->
                Cards_de_evento(total_eventos_1[event])
            }
            item(span = { GridItemSpan(maxLineSpan) }){
                Text(text = "All concerts", fontSize = 18.sp,
                    modifier = Modifier.padding(start = 20.dp, bottom = 5.dp))
            }
            items(total_eventos_2.size) { event ->
                Cards_de_evento(total_eventos_2[event])
            }
        }
    }
}

@Composable
fun Cards_de_evento(event: Evento_2){
    Card(colors = CardDefaults.cardColors(Color.Cyan),
        modifier = Modifier
            .height(200.dp)
            .clip(RoundedCornerShape(6.dp))
            .padding(15.dp)){
        AsyncImage(
            model = event.link_foto,
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(6.dp))
        )
        Column(Modifier.align(Alignment.Start)){
            Text(text = event.Titulo_Lugar, fontSize = 20.sp)
            Text(text = event.Detalles_evento)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Concierto_Preview() {
    Lab5MariaVillafuerteTheme {
        Concierto()
    }
}