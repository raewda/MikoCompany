package com.example.mikocompany.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.mikocompany.MikoBackCard
import com.example.mikocompany.MikoButton
import com.example.mikocompany.MikoDialog
import com.example.mikocompany.MikoDropDownMenu
import com.example.mikocompany.MikoReadOnlyTextField
import com.example.mikocompany.MikoSecondaryText
import com.example.mikocompany.MikoText
import com.example.mikocompany.MikoTextField
import com.example.mikocompany.MikoTitle
import com.example.mikocompany.ui.theme.backgroundP
import com.example.mikocompany.ui.theme.backgroundS
import com.example.mikocompany.ui.theme.lightContainerS

@Composable
fun Warehouse(
    navController : NavHostController,
    warehouse : MutableState<Boolean>
){

    val pick = remember { mutableStateOf("") }
    val openMenu = remember { mutableStateOf(false) }
    val openDialog = remember { mutableStateOf(false) }
    val warehouseNameRO = remember { mutableStateOf(TextFieldValue("название склада")) }
    val warehouseName = remember { mutableStateOf(TextFieldValue("")) }


    val ddmlist = listOf("oneoneoneoneoneoneoneoneoneoneoneoneoneoneoneoneoneoneoneone")
    val category_count_summ = remember { mutableStateOf(0) }
    val acceptance_count_summ = remember { mutableStateOf(0) }
    val order_count_summ = remember { mutableStateOf(0) }

    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        containerColor = backgroundP
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            MikoTitle(
                "склад"
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround,
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
                        openDialog.value = true
                    },
                    icon = Icons.Default.Add,
                    color = backgroundS,
                    modifier = Modifier
                        .height(60.dp)
                )

                if (openDialog.value){
                    MikoDialog(
                        openDialog = openDialog,
                        width = 400,
                        height = 350,
                        color = lightContainerS
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .verticalScroll(rememberScrollState()),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.SpaceAround
                        ) {
                            MikoText(
                                "добавить склад"
                            )

                            Column(
                                modifier = Modifier
                                    .fillMaxWidth(0.8F),
                                verticalArrangement = Arrangement.spacedBy(10.dp)
                            ) {
                                MikoReadOnlyTextField(
                                    warehouseNameRO
                                )
                                MikoTextField(
                                    warehouseName,
                                    placeHol = "ввести название"
                                )
                            }

                            MikoButton(
                                onClick = {
                                    openDialog.value = false
                                },
                                text = "добавить",
                                color = backgroundS
                            )
                        }
                    }
                }
            }

            MikoBackCard(
                color = lightContainerS,
                modifier = Modifier
                    .fillMaxWidth(0.88F)
                    .clickable {
                        navController.navigate("category")
                    }
            ) {
                MikoSecondaryText(
                    "категории"
                )
                MikoText(
                    "общее количество категорий на складе:"
                )
                MikoText(
                    value = category_count_summ.value.toString()
                )

            }

            MikoBackCard(
                color = lightContainerS,
                modifier = Modifier
                    .fillMaxWidth(0.88F)
                    .clickable {
                        navController.navigate("acceptance")
                    }
            ) {
                MikoSecondaryText(
                    "поставки"
                )
                MikoText(
                    "все принятые поставки:"
                )
                MikoText(
                    value = acceptance_count_summ.value.toString()
                )
            }

            MikoBackCard(
                color = lightContainerS,
                modifier = Modifier
                    .fillMaxWidth(0.88F)
                    .clickable {
                        navController.navigate("order")
                    }
            ) {
                MikoSecondaryText(
                    "заказы"
                )
                MikoText(
                    "выполненные заказы:"
                )
                MikoText(
                    value = order_count_summ.value.toString()
                )
            }
        }
    }
}