package com.example.mikocompany.screens

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CalendarLocale
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDefaults
import androidx.compose.material3.DatePickerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.mikocompany.MikoButton
import com.example.mikocompany.MikoDropDownMenu
import com.example.mikocompany.MikoText
import com.example.mikocompany.MikoTextButton
import com.example.mikocompany.MikoTextField
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
            verticalArrangement = Arrangement.SpaceAround
        ) {
            MikoText(
                "добавить приёмку"
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth(0.8F),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                MikoText(
                    warehouseName.value
                )

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
                        subheadContentColor = containerS
                    )
                    )

                MikoText(
                    "позиции:"
                )

                MikoTextButton(
                    onClick = {
                        acceptances.add(acceptanceFilling(mutableStateOf("one"), mutableIntStateOf(4)))
                    },
                    "добавить позицию",
                    secondary
                )


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

                        Log.d("ghvghhvbjdvkfkvdfj", ddmlist.toString())

                        LaunchedEffect(
                            count.value
                        ) {
                            if (count.value.text.isNotEmpty()){
                                item.count.value = count.value.text.toInt()
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
            }

            MikoButton(
                onClick = {

                },
                text = "добавить",
                color = backgroundS
            )
        }
    }
}

data class acceptanceFilling(
    val category : MutableState<String>,
    val count : MutableState<Int>
){

}