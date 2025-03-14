package com.example.mikocompany

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.mikocompany.ui.theme.backgroundS
import com.example.mikocompany.ui.theme.containerP
import com.example.mikocompany.ui.theme.containerS
import com.example.mikocompany.ui.theme.lightContainerS
import com.example.mikocompany.ui.theme.primary
import com.example.mikocompany.ui.theme.secondary
import com.example.mikocompany.ui.theme.zk

// for editable fields
@Composable
fun MikoTextField(
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
        )
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
        )
    )
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
    onClick: () -> Unit,
    text: String,
    color: Color
){
    TextButton(
        onClick = onClick,
        modifier = Modifier
    ) {
        Text(
            text = text,
            modifier = Modifier,
            fontFamily = zk,
            fontSize = 25.sp,
            color = color
        )
    }
}

// for the introductory form
@Composable
fun MikoInfoDialog(
    openDialog : MutableState<Boolean>,
    width : Int,
    height : Int,
    color: Color,
    textColor: Color
//    vmstate : State<String>
){
    Dialog(
        onDismissRequest = {
            openDialog.value = false
        }
    ){
        Card(
            modifier = Modifier
                .size(width = width.dp, height = height.dp),
            colors = CardDefaults.cardColors(color)
        ) {
            Text(
                text = "сюда стейт",
                modifier = Modifier
                    .padding(horizontal = 15.dp),
                color = textColor,
                fontFamily = zk,
                fontSize = 25.sp,
                softWrap = true
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 15.dp)
                    .padding(vertical = 7.dp),
                horizontalAlignment = Alignment.End
            ) {
                Button(
                    onClick = {
                        openDialog.value = false
                    },
                    modifier = Modifier
                        .padding(vertical = 5.dp)
                        .padding(horizontal = 15.dp),
                    colors = ButtonDefaults.buttonColors(Color.Transparent),
                    shape = CircleShape,
                    border = BorderStroke(
                        width = 2.dp,
                        color = textColor)
                ) {
                    Text(
                        text = "ок",
                        modifier = Modifier,
                        color = textColor,
                        fontFamily = zk,
                        fontSize = 25.sp
                    )
                }
            }
        }
    }
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
