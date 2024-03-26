package com.example.flightbooking.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

var inputStyle: Modifier = Modifier.fillMaxWidth()
@Composable
fun CustomInput(text: String,
                onTextChange: (String) -> Unit,
                modifier: Modifier = Modifier,
                label: String,
                maxLines: Int = 1,
                placeHolder: String = "",
                icon: ImageVector = Icons.Default.Email,

                ){

    TextField(
        value = text,
        onValueChange = onTextChange,
        modifier=modifier.fillMaxWidth().padding(
            horizontal = 20.dp,
            vertical = 20.dp
        ),
//        label = {Text(text=label)},
        maxLines=maxLines,
        placeholder= {Text(text=placeHolder,
            style= MaterialTheme.typography.labelLarge
                .copy(
                    color = Color.White
                )
            )},
        leadingIcon = {
            Icon(imageVector = icon, contentDescription = "",
            tint = Color.White
        )
        },
        colors =  TextFieldDefaults.colors(
            focusedTextColor = Color.Black,
            unfocusedTextColor = Color.White,
            unfocusedContainerColor = Color.Transparent,
            unfocusedIndicatorColor = Color.White,
            unfocusedPlaceholderColor = Color.White


        ),


    )

}

