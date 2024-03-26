package com.example.flightbooking.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.flightbooking.R
import com.example.flightbooking.components.CustomButton
import com.example.flightbooking.components.CustomInput
import com.example.flightbooking.ui.theme.PrimaryColor

@Composable
fun LoginScreen(navController: NavController) {
    var email by remember {
        mutableStateOf("")
    }
 Column(modifier = Modifier
     .background(
         color = PrimaryColor
     )
     .fillMaxWidth()
     .fillMaxHeight()
 ) {
     Row(
         verticalAlignment = Alignment.CenterVertically,
         horizontalArrangement = Arrangement.Center,
         modifier = Modifier
             .fillMaxWidth()
             .height(300.dp)
             .background(
                 color = Color.White, shape =
                 RoundedCornerShape(bottomStartPercent = 100, bottomEndPercent = 100)
             )


     ){

             Image(painter = painterResource(id = R.drawable.logo), contentDescription = "",

             )}
Column(
    horizontalAlignment = Alignment.CenterHorizontally

){
    CustomInput(
        text = email,
        onTextChange = { if (email.isNotEmpty()) email = it },
        label = "Name",
        placeHolder = "Email"
    )

    CustomInput(
        text = email,
        onTextChange = { if (email.isNotEmpty()) email = it },
        label = "Name",
        placeHolder = "Password"
    )

    CustomButton(onClick = { /*TODO*/ }, text = "Login",
        color = Color.White,
        textColor = PrimaryColor
    )

    Text(text="Forgotten password ? click here",
        style = MaterialTheme.typography.labelLarge.copy(
            color =  Color.White
        ),
        modifier = Modifier.padding(vertical = 20.dp)
        )

}

     }


}