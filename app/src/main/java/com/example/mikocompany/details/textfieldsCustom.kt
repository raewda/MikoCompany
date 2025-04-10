package com.example.mikocompany.details

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mikocompany.ui.theme.backgroundS
import com.example.mikocompany.ui.theme.containerS
import com.example.mikocompany.ui.theme.lightContainerS
import com.example.mikocompany.ui.theme.secondary
import com.example.mikocompany.ui.theme.zk

// for editable fields
@Composable
fun MikoTextField(
    value : MutableState<TextFieldValue>,
    placeHol : String,
    keyType : KeyboardType? = KeyboardType.Unspecified
){
    OutlinedTextField(
        value = value.value,
        onValueChange = {
                new -> value.value = new
        },
        modifier = Modifier,
        enabled = true,
        readOnly = false,
        singleLine = true,
        textStyle = TextStyle(
            fontFamily = zk,
            fontSize = 24.sp,
            color = backgroundS
        ),
        placeholder = { Text(placeHol,
            color = backgroundS,
            fontFamily = zk,
            fontSize = 24.sp,) },
        colors = TextFieldDefaults.colors(
            cursorColor = secondary,
            focusedContainerColor = containerS,
            unfocusedContainerColor = lightContainerS,
            focusedIndicatorColor = backgroundS,
            unfocusedIndicatorColor = secondary
        ),
        shape = RoundedCornerShape(12.dp),
        keyboardOptions = KeyboardOptions(keyboardType = keyType!!)
    )
}

// for non-editable fields
@Composable
fun MikoReadOnlyTextField(
    value : MutableState<TextFieldValue>
){
    OutlinedTextField(
        value = value.value,
        onValueChange = {},
        modifier = Modifier,
        enabled = true,
        readOnly = true,
        singleLine = true,
        textStyle = TextStyle(
            fontFamily = zk,
            fontSize = 24.sp,
            color = backgroundS
        ),
        colors = TextFieldDefaults.colors(
            cursorColor = secondary,
            focusedContainerColor = containerS,
            unfocusedContainerColor = containerS,
            focusedIndicatorColor = backgroundS,
            unfocusedIndicatorColor = backgroundS
        ),
        shape = RoundedCornerShape(12.dp)
    )
}

// for large text
@Composable
fun MikoLargeTextField(
    value : MutableState<TextFieldValue>,
    placeHol : String
){
    OutlinedTextField(
        value = value.value,
        onValueChange = {
                new -> value.value = new
        },
        modifier = Modifier,
        enabled = true,
        readOnly = false,
        singleLine = false,
        textStyle = TextStyle(
            fontFamily = zk,
            fontSize = 24.sp,
            color = backgroundS
        ),
        placeholder = { Text(placeHol,
            color = backgroundS,
            fontFamily = zk,
            fontSize = 24.sp,) },
        colors = TextFieldDefaults.colors(
            cursorColor = secondary,
            focusedContainerColor = containerS,
            unfocusedContainerColor = lightContainerS,
            focusedIndicatorColor = backgroundS,
            unfocusedIndicatorColor = secondary
        ),
        shape = RoundedCornerShape(12.dp)
    )
}

// for digital-text
@Composable
fun MikoDigitalTextField(
    value : MutableState<TextFieldValue>,
    placeHol : String,
    keyType : KeyboardType? = KeyboardType.Unspecified
){
    OutlinedTextField(
        value = value.value,
        onValueChange = {
                new -> value.value = new
        },
        modifier = Modifier
            .height(54.dp),
        enabled = true,
        readOnly = false,
        singleLine = true,
        textStyle = TextStyle(
            fontFamily = zk,
            fontSize = 18.sp,
            color = backgroundS
        ),
        placeholder = { Text(placeHol,
            color = backgroundS,
            fontFamily = zk,
            fontSize = 18.sp,) },
        colors = TextFieldDefaults.colors(
            cursorColor = secondary,
            focusedContainerColor = containerS,
            unfocusedContainerColor = lightContainerS,
            focusedIndicatorColor = backgroundS,
            unfocusedIndicatorColor = secondary
        ),
        shape = RoundedCornerShape(12.dp),
        keyboardOptions = KeyboardOptions(keyboardType = keyType!!)
    )
}