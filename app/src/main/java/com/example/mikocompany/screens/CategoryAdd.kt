package com.example.mikocompany.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.mikocompany.details.MikoBackCard
import com.example.mikocompany.details.MikoButton
import com.example.mikocompany.details.MikoDigitalTextField
import com.example.mikocompany.details.MikoLargeTextField
import com.example.mikocompany.details.MikoSecondaryText
import com.example.mikocompany.details.MikoText
import com.example.mikocompany.details.MikoTextButton
import com.example.mikocompany.details.MikoTextField
import com.example.mikocompany.ui.theme.backgroundP
import com.example.mikocompany.ui.theme.backgroundS
import com.example.mikocompany.ui.theme.lightContainerS

@Composable
fun CategoryAdd(
    navController : NavHostController,
    categoryAdd : MutableState<Boolean>
){
    val warehouseName = remember { mutableStateOf("склад №1") }
    val name = remember { mutableStateOf(TextFieldValue("")) }
    val description = remember { mutableStateOf(TextFieldValue("")) }
    val supplier = remember { mutableStateOf(TextFieldValue("")) }
    val price = remember { mutableStateOf(TextFieldValue("")) }
    val count = remember { mutableStateOf(TextFieldValue("")) }

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
        ){
            Card(
                modifier = Modifier
                    .fillMaxWidth(),
                shape = RoundedCornerShape(0, 0, 20, 20),
                colors = CardDefaults.cardColors(lightContainerS)
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
                        color = backgroundS
                    )
                }

                Column(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    MikoSecondaryText(
                        "добавить категорию"
                    )
                }
            }

            MikoText(
                warehouseName.value
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth(0.9F),
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                Column(
                    modifier = Modifier,
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    MikoBackCard(
                        color = lightContainerS,
                        modifier = Modifier
                            .width(280.dp)
                            .fillMaxWidth()
                    ) {
                        MikoText(
                            "название категории:"
                        )
                    }
                    MikoTextField(
                        name,
                        "ввести название"
                    )
                }

                Column(
                    modifier = Modifier,
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    MikoBackCard(
                        color = lightContainerS,
                        modifier = Modifier
                            .width(280.dp)
                            .fillMaxWidth()
                    ) {
                        MikoText(
                            "описание категории:"
                        )
                    }

                    MikoLargeTextField(
                        description,
                        "ввести описание категории"
                    )
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    MikoBackCard(
                        color = lightContainerS,
                        modifier = Modifier
                            .width(170.dp)
                            .height(55.dp)
                            .fillMaxWidth()
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxSize(),
                            verticalArrangement = Arrangement.Center
                        ) {
                            MikoText(
                                "цена/шт:"
                            )
                        }
                    }
                    Column(
                        modifier = Modifier
                            .fillMaxWidth(0.4F)
                    ) {
                        MikoDigitalTextField(
                            price,
                            "0 ₽",
                            KeyboardType.Number
                        )
                    }
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    MikoBackCard(
                        color = lightContainerS,
                        modifier = Modifier
                            .width(170.dp)
                            .height(55.dp)
                            .fillMaxWidth()
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxSize(),
                            verticalArrangement = Arrangement.Center
                        ) {
                            MikoText(
                                "количество:"
                            )
                        }
                    }
                    Column(
                        modifier = Modifier
                            .fillMaxWidth(0.4F)
                    ) {
                        MikoDigitalTextField(
                            count,
                            "0 шт",
                            KeyboardType.Number
                        )
                    }
                }


                Column(
                    modifier = Modifier,
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    MikoText(
                        "поставщик:"
                    )
                    MikoTextField(
                        supplier,
                        "ввести данные о поставщике"
                    )
                }
            }
            MikoButton(
                onClick = {
                    navController.navigateUp()
                },
                text = "добавить категорию",
                color = backgroundS,
                modifier = Modifier
                    .padding(bottom = 50.dp)
            )

        }
    }
}
