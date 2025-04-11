package com.example.mikocompany.details

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mikocompany.ui.theme.backgroundS
import com.example.mikocompany.ui.theme.containerS
import com.example.mikocompany.ui.theme.zk

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

// for mini popup menu
@Composable
fun MikoMiniDropDownMenu(
    openMenu : MutableState<Boolean>,
    textButton : String,
    ddmlist : List<String>,
    pick : MutableState<String>
//    ddmlist : State<String>
){
    Box(
        modifier = Modifier
            .padding(horizontal = 10.dp)
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