package com.example.lab_5.Pantallas.Mi_Perfil

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.KeyboardArrowUp
import androidx.compose.material.icons.rounded.Lock
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.lab5mariavillafuerte.Greeting
import com.example.lab5mariavillafuerte.ui.theme.Lab5MariaVillafuerteTheme
import com.example.lab5mariavillafuerte.R


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Profile() {
    Column(
        Modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center
    ) {
        //Box1
        //Fondo del usauario
        val Fondo_de_usuario = rememberAsyncImagePainter("https://i.pinimg.com/474x/c8/dd/94/c8dd942262e94973aab440bbbe462dc9.jpg")
        Box (
            Modifier
                .fillMaxWidth()
                .height(260.dp)
                .background(Color.Cyan)

        ){
            //Image, Fondo del usauario
            Image(
                painter = Fondo_de_usuario,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxSize()
            )
            val profile_null = rememberAsyncImagePainter("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS-kvDMFGIUOvSxdN4wetKCEXcYyk3I5WfvGQ&usqp=CAU")
            //Foto usiario
            Image(
                painter = profile_null,
                contentDescription = stringResource(id = R.string.Nombre_usuario),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .padding(bottom = 60.dp)
                    .size(140.dp)
                    .clip(CircleShape)
                    .align(Alignment.BottomCenter)

            )
            //Text, Nombre_usuario
            Text(
                stringResource(R.string.Nombre_usuario),
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    fontSize = 25.sp,
                ),
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(20.dp)
            )
        }
        Row(
            Modifier
                .padding(30.dp)
                .fillMaxWidth()
                .height(40.dp),
                //.background(Color.Cyan),
           // horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically

        ) {
            //Icon, persona_filled
            Icon(Icons.Rounded.Person, contentDescription = null, modifier = Modifier
                .padding(end = 0.dp))
            //Text, Edit_Profile
            Text(
                stringResource(R.string.Edit_Profile),
                modifier = Modifier.padding(start = 30.dp, end = 170.dp),
            )
            //Icon, Triangulo

            Icon(
                Icons.Rounded.KeyboardArrowUp, contentDescription = null,
                modifier = Modifier)
        }
        Divider(thickness = 1.dp, color = Color.Black)
        //Row
        Row(
            Modifier
                .padding(start = 30.dp, end = 30.dp, top = 30.dp)
                .fillMaxWidth()
                .height(40.dp),
            verticalAlignment = Alignment.CenterVertically

        ) {
            //Icon, lock
            Icon(Icons.Rounded.Lock, contentDescription = null)
            //Text, Reset_Password

            Text(
                stringResource(R.string.Reset_Password),
                modifier = Modifier
                    .padding(start = 30.dp, end = 135.dp),
                textAlign = TextAlign.Center
                ,
            )
            //Icon, Triangulo
            Icon(
                Icons.Rounded.KeyboardArrowUp,
                contentDescription = null,
                modifier = Modifier,)
        }
        //Row
        Row(
            Modifier
                .padding(30.dp)
                .fillMaxWidth()
                .height(40.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            //Icon, persona_white
            Icon(
                Icons.Rounded.Notifications,
                contentDescription = null,
                //verticalArrangement =
            )

            //Text, Notification
            Text(
                stringResource(R.string.Notification),
                modifier = Modifier.padding(start = 30.dp, end = 150.dp),
            )
            //Icon, Bar

            val checkedState = remember { mutableStateOf(true) }
            Switch(
                checked = checkedState.value,
                onCheckedChange = { checkedState.value = it },
                modifier = Modifier
                    .padding(0.dp),

            )
        }
        Divider(thickness = 1.dp, color = Color.Black)
        //Row
        Row(
            Modifier
                .padding(30.dp)
                .fillMaxWidth()
                .height(40.dp),

            verticalAlignment = Alignment.CenterVertically

        ) {
            //Icon, Star
            Icon(Icons.Rounded.Star, contentDescription = null)
            //Text, Favorite

            Text(
                stringResource(R.string.Favorite),
                modifier = Modifier.padding(start = 30.dp, end = 200.dp),
            )

            //Icon, Triangulo
            Icon(
                Icons.Rounded.KeyboardArrowUp,
                contentDescription = null,
                modifier = Modifier

            )
        }
        Divider(thickness = 1.dp, color = Color.Black)
    }
}

@Preview(showBackground = true)
@Composable
fun Profile_Preview() {
    Lab5MariaVillafuerteTheme {
        Profile()
    }
}