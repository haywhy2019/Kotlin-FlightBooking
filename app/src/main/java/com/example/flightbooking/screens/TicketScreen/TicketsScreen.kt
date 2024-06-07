package com.example.flightbooking.screens.TicketScreen

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.flightbooking.R
import com.example.flightbooking.components.CustomButton
import com.example.flightbooking.components.FlightLocation
import com.example.flightbooking.navigation.BottomNavigation
import com.example.flightbooking.navigation.FlightScreens
import com.example.flightbooking.screens.HomeScreen.LogOutDialog
import com.example.flightbooking.ui.theme.PrimaryColor
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

@Composable
fun TicketScreen(navController: NavController,
                 viewModel: TicketScreenViewModel = hiltViewModel()
                 ){
    val state = rememberScrollState()
    val cancelBooking = remember { mutableStateOf(false) }
    viewModel.tickets()

   val doc = viewModel.tickets2

    val arrival = viewModel.arrivalPort
    val arrivalDate = viewModel.arrivalDate
    val departure = viewModel.departurePort
    val departureDate = viewModel.departurePort
    val type = viewModel.ticketType



    Firebase.auth.currentUser?.let { Log.d("id", it.uid) }
    Scaffold (
        bottomBar = { BottomNavigation(navController) },
    ) { paddingValues ->
        Column(
            modifier =
            Modifier
                .padding(paddingValues)
                .fillMaxHeight()
                .fillMaxWidth()
                .verticalScroll(state)
                .background(
                    color = Color.White,
                    shape = RoundedCornerShape(bottomStartPercent = 9, bottomEndPercent = 9)
                ),
            verticalArrangement = Arrangement.Center
        ) {

            CancelBookingDialog(cancelBooking = cancelBooking, navController = navController, viewModel)
if(viewModel.isLoading) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {
        LinearProgressIndicator()
    }
}
            else if(arrival.isEmpty() and !viewModel.isLoading ) {
                Text("No Ticket found", style = MaterialTheme.typography.titleMedium
                    .copy(
                        textAlign = TextAlign.Center,
                        color = PrimaryColor
                    ),
                    modifier =  Modifier.fillMaxWidth()
                )
            }
            else {
                Card(
                    modifier = Modifier.padding(horizontal = 20.dp)
                ) {
                    Image(painter = painterResource(id = R.drawable.ticket_img), contentDescription = "",
                        contentScale = ContentScale.FillWidth,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(120.dp)
//                        .padding(vertical = 16.dp)
                    )
                    Column (
                        modifier = Modifier

                            .padding(vertical = 16.dp)

                    ) {
                        Text("Your trip is Booked!!!", style =  MaterialTheme.typography.titleLarge.copy(
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.Bold
                        ), modifier = Modifier.fillMaxWidth())

                        Text("Confirmation Code: LORSVF", style =  MaterialTheme.typography.titleMedium.copy(
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.Light
                        ), modifier = Modifier.fillMaxWidth())
                    }


                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp)
                            .padding(horizontal = 20.dp)
                            .border(
                                width = 1.dp,
                                color = PrimaryColor,
                                shape = RoundedCornerShape(10.dp)
                            ),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        FlightLocation(countryAb = departure, country = departureDate, onClick = {})
                        Icon(
                            painter = painterResource(id = R.drawable.destarrow),
                            contentDescription = ""
                        )
                        FlightLocation(countryAb = arrival, country = arrivalDate, onClick = {})
                    }

                    CustomButton(onClick = { cancelBooking.value = true }, text = "Cancel Booking",
                        modifier = Modifier

                            .padding(vertical = 5.dp)
                    )
                }
            }


        }

    }

}


@Composable
fun CancelBookingDialog(cancelBooking: MutableState<Boolean>, navController: NavController, viewModel: TicketScreenViewModel = hiltViewModel()) {
    if (cancelBooking.value) {
        Dialog(onDismissRequest = { cancelBooking.value = false }) {
            Card {
                Text(
                    text = "Do you want to cancel booking", style = TextStyle(
                        textAlign = TextAlign.Center
                    ), modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp)
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Text(text = "Confirm", modifier = Modifier.clickable(onClick =
                    {
                        viewModel.deleteTicket()
                        cancelBooking.value = false

//                        }
                    }


                    ))
                    Text(text = "Cancel", modifier = Modifier.clickable(onClick =
                    { cancelBooking.value = false }


                    ))
                }
            }
        }
    }
}
