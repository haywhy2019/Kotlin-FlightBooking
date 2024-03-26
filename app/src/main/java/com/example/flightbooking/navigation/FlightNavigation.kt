package com.example.flightbooking.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.flightbooking.screens.BookingScreen
import com.example.flightbooking.screens.HomeScreen
import com.example.flightbooking.screens.LoginScreen
import com.example.flightbooking.screens.OnBoardScreen
import com.example.flightbooking.screens.SignUpScreen

@Composable
fun FlightNavigation(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = FlightScreens.HomeScreen.name) {
        composable(FlightScreens.BookingScreen.name) { BookingScreen() }
        composable(FlightScreens.HomeScreen.name) { HomeScreen(navController) }
        composable(FlightScreens.OnboardScreen.name) { OnBoardScreen(navController) }
        composable(FlightScreens.SignUpScreen.name) { SignUpScreen(navController) }
        composable(FlightScreens.LoginScreen.name) { LoginScreen(navController) }

        // Add more destinations similarly.
    }
}