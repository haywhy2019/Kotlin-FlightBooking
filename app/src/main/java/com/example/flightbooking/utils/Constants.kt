package com.example.flightbooking.utils

import com.example.flightbooking.model.Arrival
import com.example.flightbooking.model.Data
import com.example.flightbooking.model.Departure

object Constants {
    const val  BASE_URL ="http://api.aviationstack.com/v1/"
}


val test = listOf(
    Data(
        arrival = Arrival(
            "Wallis Island",
            "WLS",
        ),
        departure = Departure(
            "Nadi International",
            "NAN"
        ),
        flight_date = "2024-04-21",
        flight_status = "scheduled"
    ),
    Data(
        arrival = Arrival(
            "Wallis Island",
            "WLS",
        ),
        departure = Departure(
            "Nadi International",
            "NAN"
        ),
        flight_date = "2024-04-21",
        flight_status = "scheduled"
    ),
    Data(
        arrival = Arrival(
            "Wallis Island",
            "WLS",
        ),
        departure = Departure(
            "Nadi International",
            "NAN"
        ),
        flight_date = "2024-04-21",
        flight_status = "scheduled"
    ),
    Data(
        arrival = Arrival(
            "Wallis Islanded",
            "WLS",
        ),
        departure = Departure(
            "Nadi International",
            "NAN"
        ),
        flight_date = "2024-04-21",
        flight_status = "scheduled"
    )
)
