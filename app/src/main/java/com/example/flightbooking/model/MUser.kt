package com.example.flightbooking.model

data class MUser(
    val userId: String,
    val name: String,
    val phoneNumber: String,
    val email: String,


    ) {
      fun toMap(): MutableMap<String, Any> {
          return mutableMapOf(
              "user_id" to this.userId,
              "name" to this.name,
              "phone number" to this.phoneNumber,
              "email" to this.email,

          )
      }
}
