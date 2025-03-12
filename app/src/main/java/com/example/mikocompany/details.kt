package com.example.mikocompany

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mikocompany.ui.theme.backgroundS
import com.example.mikocompany.ui.theme.containerP
import com.example.mikocompany.ui.theme.containerS
import com.example.mikocompany.ui.theme.primary
import com.example.mikocompany.ui.theme.secondary
import com.example.mikocompany.ui.theme.zk

// for accent block backing
@Composable
fun MikoBox(
    width : Int,
    height : Int
){

}

// for editable fields
@Composable
fun MikoTextField(
    value : TextFieldValue
){

}

// for non-editable fields
@Composable
fun MikoReadOnlyTextField(
    value : TextFieldValue
){

}

// for titles
@Composable
fun MikoTitle(
    value : String
){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = value,
            modifier = Modifier,
            color = primary,
            fontFamily = zk,
            fontSize = 50.sp,
            softWrap = true
        )
    }
}

// for text
@Composable
fun MikoText(
    value : String
){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
    ) {
        Text(
            text = value,
            modifier = Modifier,
            color = secondary,
            fontFamily = zk,
            fontSize = 25.sp,
            softWrap = true
        )
    }
}

// for accent buttons
@Composable
fun MikoButton(
    onClick: () -> Unit,
    icon : ImageVector? = null,
    text : String? = null,
    color : Color
){
    Button(
        onClick = onClick,
        modifier = Modifier
            .padding(vertical = 5.dp)
            .padding(horizontal = 15.dp),
        colors = ButtonDefaults.buttonColors(containerS)
    ) {
        if (icon != null && text == null){
            Icon(
                imageVector = icon,
                contentDescription = "icon in button"
            )
        }
        else if (icon == null && text != null){
            Text(
                text = text,
                modifier = Modifier,
                color = color,
                fontFamily = zk,
                fontSize = 25.sp
            )
        }
        else{
            Log.d("button", "ЛИБО ИКОНКА, ЛИБО ТЕКСТ!!!!!!!!")
        }
    }
}

// for hidden buttons
@Composable
fun MikoTextButton(
    onClick: () -> Unit
){

}

// for the introductory form
@Composable
fun MikoInfoDialog(

){

}

// for the data interaction form
@Composable
fun MikoDialog(

){

}

// for popup menu
@Composable
fun MikoDropDownMenu(

){

}

// to sign the application
@Composable
fun MikoName(){
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(
            buildAnnotatedString {
                withStyle(style = SpanStyle(color = primary)) {
                    append("М")
                }
                withStyle(style = SpanStyle(color = containerS)) {
                    append("и")
                }
                withStyle(style = SpanStyle(color = containerP)) {
                    append("к")
                }
                withStyle(style = SpanStyle(color = secondary)) {
                    append("о")
                }
            },
            modifier = Modifier,
            fontFamily = zk,
            fontSize = 65.sp
        )
    }
}
