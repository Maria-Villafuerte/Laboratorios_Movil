package com.example.lab_5.Pantallas.Detalle.View

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.DateRange
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lab5mariavillafuerte.Greeting
import com.example.lab5mariavillafuerte.ui.theme.Lab5MariaVillafuerteTheme
import com.example.lab_5.Pantallas.Detalle.model.Evento
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Detalle() {
    val Evento_Prueba = Evento("Concierto de Madonna","Plaza Central","13/08/2023","17:30","Última presentación de Madonna","Madonna Louise Ciccone, conocida simplemente como Madonna, es una cantante, bailarina, compositora, actriz, empresaria e icono estadounidense. Madonna pasó su infancia en Bay City y en 1978 se mudó a la ciudad de Nueva York para realizar una carrera de danza contemporánea.")
    Column(
        Modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center
    ) {
        Box (
            Modifier
                .fillMaxWidth()
                .background(Color.Cyan)
                .height(250.dp)

        ){

        }

        //Título_evento
        Text(
            Evento_Prueba.Titulo_evento,
            modifier = Modifier
                .padding(top = 15.dp,start = 30.dp),
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp,
            ),
        )
        // Lugar_evento
        Text(
            Evento_Prueba.Lugar_evento,
            modifier = Modifier
                .padding(bottom = 15.dp, start = 30.dp),)
        //Row
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 30.dp,bottom = 30.dp),

        ) {
            //Ícono, horario
            Icon(
                Icons.Rounded.DateRange, contentDescription = null,
                modifier = Modifier)//Fecha_evento
            Text(
                Evento_Prueba.Fecha_evento,
                modifier = Modifier
                    .padding(start = 30.dp))
            //Hora_evento
            Text(
                Evento_Prueba.Hora_evento,
                modifier = Modifier
                    .padding(start = 130.dp)
            )


        }
        //About_evento
        Text(
            Evento_Prueba.About_evento,
            modifier = Modifier
                .padding(bottom = 15.dp,start = 30.dp),
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
            ),)
        //Escrito_de_about_evento
        Text(
            Evento_Prueba.Escrito_de_about_evento,
            modifier = Modifier
                .padding(bottom = 70.dp,start = 30.dp, end = 40.dp),
            style = TextStyle(
                fontSize = 15.sp,
                textAlign = TextAlign.Justify,
            ),)
        //Row
        Row(
            modifier = Modifier
                .padding(bottom = 15.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,

        ) {
            //Botton
            Button(
                modifier = Modifier
                    .padding(start = 30.dp,end = 15.dp)
                    .weight(1f),
                onClick = {
                }
            )
            {
                Text(text = "Favorite")
            }
            //Botton
            Button(
                modifier = Modifier
                    .padding(start = 15.dp, end = 30.dp)
                    .weight(1f),
                onClick = {
                }
            )
            {
                Text(text = "Buy")
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun Detalle_Preview() {
    Lab5MariaVillafuerteTheme {
        Detalle()
    }
}