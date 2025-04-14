package com.example.mikocompany.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.mikocompany.dcl.AcceptanceClass
import com.example.mikocompany.details.MikoBackCard
import com.example.mikocompany.details.MikoButton
import com.example.mikocompany.details.MikoDropDownMenu
import com.example.mikocompany.details.MikoNavigation
import com.example.mikocompany.details.MikoText
import com.example.mikocompany.details.MikoTitle
import com.example.mikocompany.ui.theme.backgroundS
import com.example.mikocompany.ui.theme.lightContainerS

@Composable
fun Acceptance(
    navController : NavHostController,
    acceptance : MutableState<Boolean>
){
    val ddmlist = listOf("one", "two")
    val pick = remember { mutableStateOf("") }
    val openMenu = remember { mutableStateOf(false) }
    val dateAcceptance = remember { mutableStateOf("hui") }

    MikoNavigation(
        navController
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            MikoTitle(
                "поставки"
            )

            Row(
                modifier = Modifier,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth(0.65F)
                ) {
                    MikoDropDownMenu(
                        textButton =
                        if (pick.value.isNotEmpty()){
                            pick.value
                        }
                        else {
                            "выбрать склад"
                        },
                        openMenu = openMenu,
                        ddmlist = ddmlist,
                        pick = pick
                    )

                }

                MikoButton(
                    onClick = {
                        navController.navigate("acceptanceAdd")
                    },
                    icon = Icons.Default.Add,
                    color = backgroundS,
                    modifier = Modifier
                        .height(60.dp)
                )

            }

            MikoBackCard(
                color = lightContainerS,
                modifier = Modifier
                    .fillMaxWidth(0.88F)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth(0.4F)
                    ) {
                        MikoText(
                            "дата"
                        )
                    }
                    Column(
                        modifier = Modifier
                            .fillMaxWidth(0.4F)
                    ) {
                        MikoText(
                            "шт"
                        )
                    }
                    Column(
                        modifier = Modifier
                            .fillMaxWidth(0.8F)
                    ) {
                        MikoText(
                            "сумма"
                        )
                    }
                }
            }

            LazyColumn { items(AcceptanceClass.ordersAll){ item ->
                if (item != null){
                    acceptanceColumn(navController, item)
                }
            }
            }
        }
    }
}

@Composable
fun acceptanceColumn(
    navController: NavHostController,
    item : AcceptanceClass
){
    MikoBackCard(
        color = lightContainerS,
        modifier = Modifier
            .fillMaxWidth(0.88F)
            .clickable {
                navController.navigate("filling")
            }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            MikoText(
                item.date
            )
            MikoText(
                item.price.toString()
            )
        }
    }
}

//@Composable
//fun FillingAdd(
//    val fillingMenuOpen = remember { mutableStateOf(false) }
//    val pickFilling = remember { mutableStateOf("") }
//    val ddmlist = listOf("oneoneoneoneoneoneoneoneoneoneoneoneoneoneoneoneoneoneoneone")
//    val count_filling = remember { mutableStateOf(TextFieldValue("")) }
//    val price_filling = remember { mutableStateOf(TextFieldValue(""))}
//){
//    Row {
//        MikoDropDownMenu(
//            fillingMenuOpen,
//            "выбрать",
//            ddmlist,
//            pickFilling
//        )
//
//        MikoTextField(
//            count_filling,
//            "0",
//            keyType = KeyboardType.Number
//        )
//    }
//}