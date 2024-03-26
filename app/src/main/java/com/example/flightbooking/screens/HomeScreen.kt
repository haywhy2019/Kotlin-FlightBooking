package com.example.flightbooking.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.flightbooking.R
import com.example.flightbooking.components.CustomButton
import com.example.flightbooking.components.FlightDate
import com.example.flightbooking.components.FlightLocation
import com.example.flightbooking.navigation.BottomNavigation
import com.example.flightbooking.navigation.FlightScreens
import com.example.flightbooking.navigation.listOfNavItems
import com.example.flightbooking.ui.theme.PrimaryColor
import com.example.flightbooking.ui.theme.PrimaryColor2

@SuppressLint("ResourceAsColor")
@Composable
fun HomeScreen(navController: NavController) {
    val state = rememberScrollState()
    LaunchedEffect(Unit) { state.animateScrollTo(100) }
    val navController1: NavHostController = rememberNavController()
    Scaffold(
        bottomBar = { BottomNavigation() },
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
                )
        ) {
            Column(
                modifier =
                Modifier
                    .height(310.dp)
                    .fillMaxWidth()
                    .background(
                        PrimaryColor,
                        shape = RoundedCornerShape(bottomStartPercent = 9, bottomEndPercent = 9)
                    )
            ) {

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp)

                ) {

                    Image(
                        painter = painterResource(id = R.drawable.logo_white),
                        contentDescription = "",
                        modifier = Modifier
                            .height(60.dp),
                        contentScale = ContentScale.FillHeight
                    )
                }

                Column(
                    modifier = Modifier.padding(
                        horizontal = 16.dp
                    )
                ) {
                    Text(
                        text = "Where are you going today ?",
                        style = MaterialTheme.typography.displaySmall
                            .copy(color = Color.White),
                        modifier = Modifier.padding(
                            end = 80.dp,
                            top = 20.dp,
                            bottom = 20.dp

                        )
                    )
                    Row {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(100.dp)
                                .weight(1f)
                        ) {
                            CustomButton(
                                onClick = { /*TODO*/ }, text = "Round",
                                modifier = Modifier.fillMaxWidth(),
                                color = Color.White,
                                textColor = PrimaryColor


                            )
                        }
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                //                            .height(100.dp)
                                .weight(1f)

                        ) {
                            CustomButton(
                                onClick = { /*TODO*/ }, text = "One way", outline = true,
                                modifier = Modifier.fillMaxWidth(),
                                outlineTextColor = Color.White,
                                outlineBrColor = Color.White
                            )
                        }
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(100.dp)
                                .weight(1f)
                        ) {
                            CustomButton(
                                onClick = { /*TODO*/ }, text = "Multi City", outline = true,
                                modifier = Modifier.fillMaxWidth(),
                                outlineTextColor = Color.White,
                                outlineBrColor = Color.White
                            )

                        }


                    }

                }

            }
            Column(
                modifier = Modifier.padding(
                    horizontal = 16.dp
                )
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 40.dp, vertical = 10.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = "From")
                    Text(text = "To")
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp)
                        .padding(horizontal = 20.dp)
                        .border(
                            width = 1.dp, color = PrimaryColor, shape =
                            RoundedCornerShape(10.dp)
                        ),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    FlightLocation(countryAb = "LON", country = "London, United kingdom")
              Icon(painter = painterResource(id = R.drawable.destarrow), contentDescription = "")
                    FlightLocation("LOS", "Lagos, Nigeria")
                }
Row(
    modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 20.dp, vertical = 30.dp),
    horizontalArrangement = Arrangement.spacedBy(10.dp)

) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .weight(1F)
            .height(120.dp)
            .border(
                width = 1.dp, color = PrimaryColor, shape = RoundedCornerShape(10.dp),

                ),
        contentAlignment = Alignment.Center
    ){FlightDate(title = "Departure" , date = "05 November, 2023")}
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .weight(1F)
            .height(120.dp)
            .border(width = 1.dp, color = PrimaryColor, shape = RoundedCornerShape(10.dp)),
     contentAlignment = Alignment.Center){FlightDate(title = "Departure" , date = "05 November, 2023")}

}
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp),
                    horizontalArrangement = Arrangement.SpaceBetween

                ) {
                    Text(text = "Passenger")
                    VerticalDivider(
                        thickness = 1.dp,
                        color = PrimaryColor,
                        modifier = Modifier.height(100.dp)
                    )
                    Text(text = "Ticket Class")
                    VerticalDivider(
                        thickness = 1.dp,
                        color = PrimaryColor,
                        modifier = Modifier.height(100.dp)
                    )
                    Text(text = "Stops")
                }


                Row (
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxWidth()
                        .padding(vertical = 40.dp)
                ){
                    CustomButton(onClick = { /*TODO*/ }, text = "Continue for hotels")
                }
                //// here
            }



        }


//        NavHost(
//            navController = navController1,
//            startDestination = FlightScreens.HomeScreen.name,
//            modifier = Modifier.padding(paddingValues)
//        ) {
//            composable(FlightScreens.BookingScreen.name) { BookingScreen() }
//            composable(FlightScreens.HomeScreen.name) { HomeScreen(navController) }
//            composable(FlightScreens.OnboardScreen.name) { OnBoardScreen(navController) }
//            composable(FlightScreens.SignUpScreen.name) { SignUpScreen(navController) }
//        }
    }

}

