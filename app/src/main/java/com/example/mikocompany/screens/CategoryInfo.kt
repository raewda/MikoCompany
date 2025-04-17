package com.example.mikocompany.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
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
import com.example.mikocompany.details.MikoBackCard
import com.example.mikocompany.details.MikoButton
import com.example.mikocompany.details.MikoDialog
import com.example.mikocompany.details.MikoDigitalTextField
import com.example.mikocompany.details.MikoLargeTextField
import com.example.mikocompany.details.MikoSecondaryText
import com.example.mikocompany.details.MikoText
import com.example.mikocompany.details.MikoTextButton
import com.example.mikocompany.details.MikoTextField
import com.example.mikocompany.ui.theme.backgroundP
import com.example.mikocompany.ui.theme.backgroundS
import com.example.mikocompany.ui.theme.lightContainerS
import com.example.mikocompany.ui.theme.secondary

@Composable
fun CategoryInfo(
    navController : NavHostController,
    categoryInfo : MutableState<Boolean>
){
    val name = remember { mutableStateOf(TextFieldValue("jopa")) }
    val description = remember { mutableStateOf(TextFieldValue("")) }
    val price = remember { mutableStateOf(TextFieldValue("")) }
    val count = remember { mutableStateOf(TextFieldValue("")) }
    val supplier = remember { mutableStateOf(TextFieldValue("")) }
    val openDialog = remember { mutableStateOf(false) }

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
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            Card(
                modifier = Modifier
                    .fillMaxWidth(),
                shape = RoundedCornerShape(0, 0, 20, 20),
                colors = CardDefaults.cardColors(lightContainerS)
            ) {
                Row (
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Column(
                        modifier = Modifier,
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
                        horizontalAlignment = Alignment.End
                    ) {
                        IconButton(
                            onClick = {
                                openDialog.value = true
                            }
                        ) {
                            Icon(
                                Icons.Default.Edit,
                                contentDescription = "edit",
                                tint = backgroundS
                            )
                        }
                    }
                }

                Column(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    MikoSecondaryText(
                        "название категории"
                    )
                }
            }

            Column(
                modifier = Modifier,
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                MikoText(
                    "склад:"
                )

                MikoBackCard(
                    modifier = Modifier
                        .padding(horizontal = 15.dp),
                    color = lightContainerS
                ) {
                    MikoText(
                        "склад №1"
                    )
                }
            }

            Column(
                modifier = Modifier,
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                MikoText(
                    "описание категории:"
                )

                MikoBackCard(
                    modifier = Modifier
                        .padding(horizontal = 15.dp),
                    color = lightContainerS
                ) {
                    MikoText(
                        "описание"
                    )
                }
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Column {
                    MikoText(
                        "цена/шт:"
                    )
                    MikoBackCard(
                        modifier = Modifier
                            .padding(horizontal = 15.dp),
                        color = lightContainerS
                    ) {
                        MikoText(
                            "100 ₽"
                        )
                    }
                }
                Column {
                    MikoText(
                        "количество:"
                    )
                    MikoBackCard(
                        modifier = Modifier
                            .padding(horizontal = 15.dp),
                        color = lightContainerS
                    ) {
                        MikoText(
                            "100 шт"
                        )
                    }
                }
            }


            Column(
                modifier = Modifier,
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                MikoText(
                    "поставщик:"
                )

                MikoBackCard(
                    modifier = Modifier
                        .padding(horizontal = 15.dp),
                    color = lightContainerS
                ) {
                    MikoText(
                        value =
                        (if (supplier.value.text.isNotEmpty()){
                            supplier.value
                        } else{
                            "нет информации"
                        }).toString()
                    )
                }
            }

            if (openDialog.value){
                MikoDialog(
                    openDialog,
                    400,
                    650,
                    lightContainerS
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .verticalScroll(rememberScrollState())
                            .padding(horizontal = 10.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.spacedBy(15.dp)
                    ) {
                        MikoSecondaryText(
                            "изменить категорию"
                        )

                        Column {
                            MikoText(
                                "название:"
                            )

                            MikoTextField(
                                name,
                                name.value.text
                            )
                        }

                        Column {
                            MikoText(
                                "описание:"
                            )

                            MikoLargeTextField(
                                description,
                                description.value.text
                            )
                        }

                        Row(
                            modifier = Modifier
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            MikoText(
                                "цена/шт:"
                            )

                            MikoDigitalTextField(
                                price,
                                price.value.text
                            )
                        }

                        Row(
                            modifier = Modifier
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            MikoText(
                                "количество:"
                            )

                            MikoDigitalTextField(
                                count,
                                count.value.text
                            )
                        }

                        Column {
                            MikoText(
                                "поставщик:"
                            )

                            MikoLargeTextField(
                                supplier,
                                supplier.value.text
                            )
                        }

                        MikoButton(
                            onClick = {
                                openDialog.value = false
                            },
                            text = "сохранить",
                            color = backgroundS
                        )
                    }
                }
            }
        }
    }
}