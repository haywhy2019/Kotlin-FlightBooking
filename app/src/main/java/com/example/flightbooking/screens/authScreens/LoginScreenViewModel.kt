package com.example.flightbooking.screens.authScreens

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthException
import com.google.firebase.auth.auth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class LoginScreenViewModel : ViewModel() {
    //    val loadingState = MutableStateFlow(LoadingState.IDLE)
    private val auth: FirebaseAuth = Firebase.auth
    private val _loading = MutableLiveData(false)
    val loading: LiveData<Boolean> = _loading


    fun signInWithEmailAndPassword(email: String, password: String, home: () -> Unit) =
        viewModelScope.launch {
            try {
                auth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            Log.d("FB", "signin good : ${task.result.toString()}")

                            home()
                        } else {
                            Log.d("FB", "signin : ${task.result.toString()}")
                        }
                    }
                    .addOnFailureListener{
                            task -> Log.d("fail", task.message.toString())
                    }
            } catch (ex: Exception) {
                Log.d("FB", "signinwithemain: ${ex.message}")
            }
        }

    fun createUserWithEmailAndPassword(
        email: String,
        password: String,
        name: String,
        phoneNumber: String,
        home: () -> Unit,

    ) = viewModelScope.launch {
      if(_loading.value == false){
          _loading.value = true
          try {
              auth.createUserWithEmailAndPassword(email, password)
                  .addOnCompleteListener {
                          task ->
                      if(task.isSuccessful){
//                          val displayName = task.result.user.email
                       createUser(name,phoneNumber,email)
                          home()
                      }else {
                          Log.d("FB", "crete user: ${task.result.toString()}")
                      }
                      _loading.value = false
                  }.addOnFailureListener{
                      task -> Log.d("fail", task.message.toString())
                  }
          }catch (ex: Exception){
              _loading.value = false
              Log.d("FB", "create with emain: ${ex.message}")
          }

      }
    }

    private fun createUser(name: String, phoneNumber: String, email: String){
        val userId =  auth.currentUser?.uid
        val user = mutableMapOf<String, Any>()
        user["user_id"] = userId.toString()
        user["name"] = name
        user["phoneNumber"] = phoneNumber
        user["email"] = email


        FirebaseFirestore.getInstance()
            .collection("user")
            .add(user)


    }

}