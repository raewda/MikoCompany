package com.example.mikocompany

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextOverflow
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
import java.util.Calendar


// for design modules
@Composable
fun MikoBackCard(
    modifier: Modifier = Modifier,
    color: Color,
    content: @Composable () -> Unit
){
    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(color)
    ) {
        content()
    }
}

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

// for subtitle
@Composable
fun MikoSecondaryText(
    value : String
){
    Column(
        modifier = Modifier
            .padding(horizontal = 20.dp)
    ) {
        Text(
            text = value,
            modifier = Modifier,
            color = secondary,
            fontFamily = zk,
            fontSize = 35.sp,
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
    color : Color,
    modifier: Modifier = Modifier
){
    Button(
        onClick = onClick,
        modifier = modifier
            .padding(vertical = 5.dp)
            .padding(horizontal = 15.dp),
        colors = ButtonDefaults.buttonColors(containerS),
        shape = RoundedCornerShape(12.dp)
    ) {
        if (icon != null && text == null){
            Icon(
                imageVector = icon,
                contentDescription = "icon in button",
                tint = color
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
                .size(width = width.dp, height = height.dp)
                .verticalScroll(rememberScrollState()),
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
    openDialog : MutableState<Boolean>,
    width : Int,
    height : Int,
    color: Color,
    content : @Composable () -> Unit
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
            content()
        }
    }
}

// for popup menu
@Composable
fun MikoDropDownMenu(
    openMenu : MutableState<Boolean>,
    textButton : String,
    ddmlist : List<String>,
    pick : MutableState<String>
//    ddmlist : State<String>
){
    Box(
        modifier = Modifier
            .padding(horizontal = 15.dp)
    ){
        Button(
            modifier = Modifier,
            onClick = {
                openMenu.value = true
            },
            colors = ButtonDefaults.buttonColors(containerS),
            shape = RoundedCornerShape(12.dp)
        ) {
            Text(
                text = textButton,
                fontFamily = zk,
                color = backgroundS,
                fontSize = 25.sp,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }

        if (openMenu.value){
            DropdownMenu(
                modifier = Modifier
                    .background(containerS),
                expanded = openMenu.value,
                onDismissRequest = { openMenu.value = false }
            ) {
                for (i in ddmlist.indices){
                    DropdownMenuItem(
                        text = { Text(
                            text = ddmlist.get(index = i),
                            fontFamily = zk,
                            color = backgroundS,
                            fontSize = 25.sp
                        ) },
                        onClick = {
                            pick.value = ddmlist.get(index = i)
                            openMenu.value = false
                        }
                    )
                }
            }
        }
    }
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
