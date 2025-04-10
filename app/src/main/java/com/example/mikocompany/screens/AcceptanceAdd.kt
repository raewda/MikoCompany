package com.example.mikocompany.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CalendarLocale
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDefaults
import androidx.compose.material3.DatePickerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.mikocompany.details.MikoButton
import com.example.mikocompany.details.MikoDialog
import com.example.mikocompany.details.MikoDropDownMenu
import com.example.mikocompany.details.MikoLargeTextField
import com.example.mikocompany.details.MikoSecondaryText
import com.example.mikocompany.details.MikoText
import com.example.mikocompany.details.MikoTextButton
import com.example.mikocompany.details.MikoTextField
import com.example.mikocompany.ui.theme.backgroundP
import com.example.mikocompany.ui.theme.backgroundS
import com.example.mikocompany.ui.theme.containerS
import com.example.mikocompany.ui.theme.lightContainerS
import com.example.mikocompany.ui.theme.primary
import com.example.mikocompany.ui.theme.secondary

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AcceptanceAdd(
    navController : NavHostController,
    acceptanceAdd : MutableState<Boolean>
){
    // передать id склада и взять его название
    val warehouseName = remember { mutableStateOf("склад №1") }

    val datePickerState = remember { mutableStateOf(DatePickerState(locale = CalendarLocale.getDefault())) }

    val ddmlist = listOf("one", "two")

    val acceptances = remember { mutableStateListOf<acceptanceFilling>() }

    val comment = remember { mutableStateOf(TextFieldValue("")) }

    val openDialog = remember { mutableStateOf(false) }

    val all_count = remember { mutableStateOf(0) }

    val all_price = remember { mutableStateOf(0) }

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
            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.Start
            ) {
                MikoTextButton(
                    onClick = {
                        navController.navigateUp()
                    },
                    "назад",
                    color = containerS
                )
            }

            Card(
                modifier = Modifier,
                colors = CardDefaults.cardColors(lightContainerS)
            ) {
                MikoSecondaryText(
                    "добавить приёмку"
                )
            }
            MikoText(
                warehouseName.value
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth(0.8F),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {

                DatePicker(
                    state = datePickerState.value,
                    modifier = Modifier,
                    title = {
                    DatePickerDefaults.DatePickerTitle(
                        displayMode = datePickerState.value.displayMode,
                        modifier = Modifier
                        )
                    },
                    headline = {
                    DatePickerDefaults.DatePickerHeadline(
                        selectedDateMillis = datePickerState.value.selectedDateMillis,
                        displayMode = datePickerState.value.displayMode,
                        modifier = Modifier,
                        dateFormatter = DatePickerDefaults.dateFormatter()
                        )
                    },
                    showModeToggle = true,
                    colors = DatePickerDefaults.colors(
                        selectedDayContainerColor = containerS,
                        selectedDayContentColor = backgroundS,
                        selectedYearContentColor = backgroundS,
                        selectedYearContainerColor = containerS,
                        navigationContentColor = secondary,
                        yearContentColor = containerS,
                        todayContentColor = secondary,
                        todayDateBorderColor = secondary,
                        dividerColor = containerS,
                        currentYearContentColor = secondary,
                        titleContentColor = secondary,
                        headlineContentColor = secondary,
                        subheadContentColor = containerS,
                        dateTextFieldColors = TextFieldDefaults.colors(
                            focusedContainerColor = Color.Transparent,
                            focusedIndicatorColor = secondary,
                            unfocusedIndicatorColor = containerS,
                            focusedTextColor = secondary,
                            unfocusedTextColor = containerS,
                            focusedLabelColor = secondary,
                            unfocusedLabelColor = containerS,
                            unfocusedContainerColor = Color.Transparent
                        )
                    )
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    MikoSecondaryText(
                        "позиции:"
                    )

                    MikoTextButton(
                        onClick = {
                            acceptances.add(acceptanceFilling(mutableStateOf("one"), mutableIntStateOf(4)))
                        },
                        "добавить",
                        secondary
                    )
                }

                Column(
                    modifier = Modifier,
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    acceptances.forEach(){ item ->

                        val count = remember { mutableStateOf(TextFieldValue("")) }
                        val pick = remember { mutableStateOf("") }
                        val openMenu = remember { mutableStateOf(false) }

                        Row(
                            modifier = Modifier,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            MikoDropDownMenu(
                                ddmlist = ddmlist,
                                pick = pick,
                                openMenu = openMenu,
                                textButton =
                                if (pick.value.isNotEmpty()){
                                    pick.value
                                }
                                else {
                                    "выбрать"
                                }
                            )

                            Column(
                                modifier = Modifier
                                    .fillMaxWidth(0.4F)
                            ) {
                                MikoTextField(
                                    count,
                                    "0",
                                    keyType = KeyboardType.Number
                                )
                            }
                        }

                        LaunchedEffect(
                            count.value
                        ) {
                            if (count.value.text.isNotEmpty()){
                                item.count.value = count.value.text.toInt()
                                all_count.value = all_count.value + count.value.text.toInt()
                            }
                        }

                        LaunchedEffect(
                            pick.value
                        ) {
                            if (pick.value != "выбрать"){
                                item.category.value = pick.value
                            }
                        }

                    }
                }

                Column(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.spacedBy(15.dp)
                ) {
                    MikoText(
                        "комментарий:"
                    )
                }
                Column(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    MikoLargeTextField(
                        comment,
                        "ввести комментарий"
                    )
                }
            }

            MikoButton(
                onClick = {
                    openDialog.value = true
                },
                text = "добавить приёмку",
                color = backgroundS,
                modifier = Modifier
                    .padding(bottom = 50.dp)
            )

            if (openDialog.value){
                MikoDialog(
                    openDialog,
                    350,
                    250,
                    lightContainerS
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize(),
                        horizontalAlignment = Alignment.Start,
                        verticalArrangement = Arrangement.Center
                    ) {
                        MikoSecondaryText(
                            value = "объём поставки: "
                        )

                        Card(
                            colors = CardDefaults.cardColors(backgroundS),
                            modifier = Modifier
                                .padding(horizontal = 15.dp)
                        ) {
                            MikoText(
                                value = all_count.value.toString() + " шт"
                            )
                        }

                        MikoSecondaryText(
                            value = "общая стоимость: "
                        )
                        Card(
                            colors = CardDefaults.cardColors(backgroundS),
                            modifier = Modifier
                                .padding(horizontal = 15.dp)
                        ) {
                            MikoText(
                                value = all_price.value.toString() + " ₽"
                            )
                        }

                        Column(
                            modifier = Modifier
                                .fillMaxWidth(),
                            horizontalAlignment = Alignment.End
                        ) {
                            MikoTextButton(
                                onClick = {
                                    navController.navigate("acceptance")
                                },
                                text = "добавить приёмку",
                                color = backgroundS,
                            )
                        }
                    }
                }
            }
        }
    }
}

data class acceptanceFilling(
    val category : MutableState<String>,
    val count : MutableState<Int>
){

}