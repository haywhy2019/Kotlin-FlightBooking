package com.example.flightbooking.screens.TicketScreen

import android.content.ContentValues
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateMapOf

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshots.SnapshotStateMap
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.launch

class TicketScreenViewModel : ViewModel() {

    private val user = Firebase.auth.currentUser?.uid
    private val db = FirebaseFirestore.getInstance()

    var isLoading by mutableStateOf(false)

    var tickets2 by mutableStateOf("")
    var arrivalDate by mutableStateOf("")
    var departureDate by mutableStateOf("")
    var arrivalPort by mutableStateOf("")
    var departurePort by mutableStateOf("")
    var ticketType by mutableStateOf("")

    fun tickets() = viewModelScope.launch {
        isLoading = true
        db.collection("tickets")
            .whereEqualTo("user_id", user)
            .get()
            .addOnSuccessListener { documents ->

                for (document in documents) {
                    ticketType = document.data["type"].toString()
                  arrivalDate  = document.data["arrivalDate"].toString()
                    departureDate  = document.data["destinationDate"].toString()
                    arrivalPort  = document.data["arrival"].toString()
                    departurePort  = document.data["departure"].toString()

                }
            }
            .addOnFailureListener { exception ->
                Log.w(ContentValues.TAG, "Error getting documents: ", exception)
            }.addOnCompleteListener{
                isLoading = false
            }
    }

    fun deleteTicket() = viewModelScope.launch {
        isLoading = true
        db.collection("tickets")
            .whereEqualTo("user_id", user)
            .get()
            .addOnSuccessListener { documents ->
                for (document in documents) {
                    document.reference.delete()
                    arrivalPort = ""
                    arrivalDate = ""
                    departureDate = ""
                    departurePort = ""
                }
            }
            .addOnFailureListener { exception ->
                Log.d("delete", "Error getting documents: ", exception)
            }.addOnCompleteListener{
                isLoading = false
            }
    }

}