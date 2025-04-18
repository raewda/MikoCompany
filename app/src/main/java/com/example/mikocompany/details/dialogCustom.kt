package com.example.mikocompany.details

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.mikocompany.ui.theme.zk

// for the introductory form
@Composable
fun MikoInfoDialog(
    openDialog : MutableState<Boolean>,
    width : Int,
    height : Int,
    color: Color,
    textColor: Color,
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
                text = "vmstate",
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