package com.example.flightbooking.screens

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.draw.scale
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.navigation.NavController
import com.example.flightbooking.R
import com.example.flightbooking.components.CustomButton
import com.example.flightbooking.components.CustomInput
import com.example.flightbooking.ui.theme.PrimaryColor
import com.example.flightbooking.ui.theme.PrimaryColor2

@Composable
fun SignUpScreen(navController: NavController) {
    val state = rememberScrollState()
    LaunchedEffect(Unit) { state.animateScrollTo(100) }
    var email by remember {
        mutableStateOf("")
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
//            .background(color = Color.White)
//            .paint(
//                painterResource(id = R.drawable.sign_up),
//                contentScale = ContentScale.FillWidth
//            )
    ) {

        Column(
            modifier = Modifier
                .weight(3F)
                .verticalScroll(state)
                .padding(bottom = 10.dp)
                .background(
                    color = PrimaryColor,
                    shape =
                    RoundedCornerShape(bottomStartPercent = 13, bottomEndPercent = 13)
                )
        ) {
            Text(
                text = "Sign Up",
                style = MaterialTheme.typography.headlineMedium
                    .copy(
                        color = Color.White,
                        textAlign = TextAlign.Center
                    ), modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 40.dp)
            )

            CustomInput(
                text = email,
                onTextChange = { if (email.isNotEmpty()) email = it },
                label = "Name",
                placeHolder = "Name"
            )

            CustomInput(
                text = email,
                onTextChange = { if (email.isNotEmpty()) email = it },
                label = "Email",
                placeHolder = "Email"
            )


            CustomInput(
                text = email,
                onTextChange = { if (email.isNotEmpty()) email = it },
                label = "Phone number",
                placeHolder = "Phone Number"
            )


            CustomInput(
                text = email,
                onTextChange = { if (email.isNotEmpty()) email = it },
                label = "Password",
                placeHolder = "Password"
            )


            CustomInput(
                text = email,
                onTextChange = { if (email.isNotEmpty()) email = it },
                label = "Confirm Password",
                placeHolder = "Confirm Password"
            )

            CustomInput(
                text = email,
                onTextChange = { if (email.isNotEmpty()) email = it },
                label = "Confirm Password",
                placeHolder = "Confirm Password"

            )

            Box(modifier = Modifier.padding(10.dp))
        }
        Column(
            modifier = Modifier
                .background(color = Color.White)
                .fillMaxWidth()
                .weight(1F)
                .padding(vertical = 25.dp),
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            CustomButton(onClick = { /*TODO*/ },
                text = "Create Account",
                outline = true
            )
            Text(text="Already have an account ? Sign in",
                style=MaterialTheme.typography.labelMedium.copy(
                    color = Color.Gray
                )
                )
        }
    }

}
