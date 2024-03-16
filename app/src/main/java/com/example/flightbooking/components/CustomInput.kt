package com.example.flightbooking.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

var inputStyle: Modifier = Modifier.fillMaxWidth()
@Composable
fun CustomInput(text: String,
                onTextChange: (String) -> Unit,
                modifier: Modifier = Modifier,
                label: String,
                maxLines: Int = 1,
                placeHolder: String = "",
                icon: () -> Unit,

                ){

    TextField(
        value = text,
        onValueChange = onTextChange,
        modifier=modifier.fillMaxWidth(),
        label = {Text(text=label)},
        maxLines=maxLines,
        placeholder= {Text(text=placeHolder)},
        leadingIcon = {icon},
        colors =  TextFieldDefaults.colors(
            focusedTextColor = Color.Black,
            unfocusedTextColor = Color.White,
            unfocusedContainerColor = Color.Cyan


        ),


    )

}

