package com.example.flightbooking.screens

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.draw.scale
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.flightbooking.R
import com.example.flightbooking.components.CustomInput
import com.example.flightbooking.ui.theme.PrimaryColor2

@Composable
fun SignUpScreen(navController: NavController){
    var email by remember {
        mutableStateOf("")
    }
    Column(modifier = Modifier
        .fillMaxSize()
        .paint(
            painterResource(id = R.drawable.sign_up),
            contentScale = ContentScale.FillWidth
        )
    ) {

     Column() {
         Text(text= "Sign Up",
             style= MaterialTheme.typography.headlineMedium
             .copy(color = Color.White,
                 textAlign = TextAlign.Center), modifier = Modifier
                 .fillMaxWidth()
                 .padding(vertical = 40.dp))

    CustomInput(text = email,
        onTextChange = {if(email.isNotEmpty()) email = it},
        label = "Email",
        placeHolder = "Email"
        ) {

    }
     }
    }

}
