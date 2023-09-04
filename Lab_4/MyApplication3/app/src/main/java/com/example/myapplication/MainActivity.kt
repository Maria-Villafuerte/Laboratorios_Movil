package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                }
            }
        }
    }
}


@Composable
fun Aplicacion_a_usar() {
    Surface(
        modifier = Modifier.fillMaxHeight(),
        color = Color.White
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Textos_de_ingreso()
        }
    }

}

@Composable
//Crea la Card
fun crear_card( title: String,  imageUrl: String){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        val imageUrl = imageUrl
        val painter = rememberAsyncImagePainter(imageUrl)

        Image(
            painter = painter,
            contentDescription = "Logo image",
            modifier = Modifier
                .height(150.dp)
                .width(150.dp)
                .padding(end = 16.dp)
        )
        Text(title)
    }
}


data class card(
    val title: String,
    val imageUrl: String
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Textos_de_ingreso() {

    //Siento que estoy usando mal el remember
    var nombreElemento by remember { mutableStateOf("") }
    var url by remember { mutableStateOf("") }
    val items = remember { mutableStateListOf<card>()}
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        //PARA HACER LO TEXTOS BONITOS
        Spacer(modifier = Modifier.padding(20.dp))
        OutlinedTextField(
            value = nombreElemento,
            label = { Text(text = "Nombre") },
            onValueChange = {
                nombreElemento = it     
                            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            textStyle = LocalTextStyle.current.copy(color = Color.Black) // Texto blanco
        )
        Spacer(modifier = Modifier.padding(2.dp))
        OutlinedTextField(
            value = url,
            label = { Text(text = "URL") },
            onValueChange = { url = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            textStyle = LocalTextStyle.current.copy(color = Color.Black) // Texto blanco
        )
        Spacer(modifier = Modifier.padding(2.dp))
        Button(
            onClick = {
                    items.add(card(nombreElemento, url))
                nombreElemento = "" // Limpiar el campo después de agregar
                url = "" // Limpiar el campo después de agregar
            }
        )
        {
            
            Text(text = "Agregar")
        }

    }
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        //Validación
        items(items) {i  -> // Cambio de acceso a elementos en la lista
            if (i.imageUrl != null && i.title != null) {
                image_tasport(i){ itemToRemove ->
                    items.remove(itemToRemove)
                }
            }

        }
    }
}

@Composable
fun image_tasport(items: card,onDeleteClicked: (card) -> Unit){
    Button(onClick = { onDeleteClicked(items) }) {

    Card(
        modifier = Modifier
            .width(500.dp)
            .padding(5.dp)
            .clip(RoundedCornerShape(20.dp))
            .height(50.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(2.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            val painter = rememberAsyncImagePainter(items.imageUrl)
            Image(
                painter = painter,
                contentDescription = "Logo image",
                modifier = Modifier
                    .height(150.dp)
                    .width(150.dp)
                    .padding(end = 2.dp)
            )
            Text(text = items.title)

            }
        }
    }

}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        Aplicacion_a_usar()
    }

}
