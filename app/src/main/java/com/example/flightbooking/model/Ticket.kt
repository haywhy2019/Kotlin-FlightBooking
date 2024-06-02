package com.example.flightbooking.model

class Ticket(
    var userId: String,
    var departure: String,
    var arrival: String,
    var destinationDate: String,
    var arrivalDate: String,
    var type: String
) {
    fun toMap(): MutableMap<String, Any> {
        return mutableMapOf(
            "user_id" to this.userId,
            "departure" to this.departure,
            "arrival" to this.arrival,
            "destinationDate" to this.destinationDate,
            "arrivalDate" to this.arrivalDate,
            "type" to this.type

        )
    }
}