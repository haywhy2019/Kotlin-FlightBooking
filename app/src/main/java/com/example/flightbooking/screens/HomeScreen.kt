package com.example.flightbooking.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.flightbooking.R
import com.example.flightbooking.components.CustomButton
import com.example.flightbooking.ui.theme.PrimaryColor2

@SuppressLint("ResourceAsColor")
@Composable
fun HomeScreen(navController: NavController){
    Column(verticalArrangement = Arrangement.SpaceBetween,
//        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(horizontal = 16.dp
        )) {
        Image(painter = painterResource(id = R.drawable.on_board_img), contentDescription = "",
            contentScale = ContentScale.FillWidth,
            modifier = Modifier.fillMaxWidth().padding(vertical = 16.dp)

            )
        Column(horizontalAlignment = Alignment.Start) {
            Text(text = "Explore the world anytime,", style = MaterialTheme.typography.headlineSmall.copy())
            Text(text = "Book Flights and Hotel\nwith  just a button",style = MaterialTheme.typography.headlineMedium.copy(
                color = PrimaryColor2,
                fontWeight = FontWeight.Bold
            ))
        }
       Row {
           Box(modifier=Modifier.height(80.dp) .background(Color.White)
               .fillMaxWidth(0.5F),contentAlignment = Alignment.Center) {
               Text(text="Sign Up",modifier= Modifier

               )
           }
Box(modifier= Modifier
    .fillMaxWidth(1F)
    .background(PrimaryColor2, shape = RoundedCornerShape(topStartPercent = 70)).height(80.dp)
    ,
    contentAlignment = Alignment.Center
    ){
    Text(text = "Login"
        , textAlign = TextAlign.Center, style=MaterialTheme.typography.titleMedium.copy(
            color = Color.White
        ))
}


       }
    }
   


}