package com.example.mikocompany.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
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
import com.example.mikocompany.MikoButton
import com.example.mikocompany.MikoReadOnlyTextField
import com.example.mikocompany.MikoTextField
import com.example.mikocompany.MikoTitle
import com.example.mikocompany.ui.theme.backgroundP
import com.example.mikocompany.ui.theme.backgroundS

@Composable
fun Authorization(
    navController: NavHostController,
    authorization : MutableState<Boolean>
){
    val loginRO = remember { mutableStateOf(TextFieldValue("логин")) }
    val login = remember { mutableStateOf(TextFieldValue("")) }
    val passwordRO = remember { mutableStateOf(TextFieldValue("пароль")) }
    val password = remember { mutableStateOf(TextFieldValue("")) }

    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        containerColor = backgroundP
    ) { innerPadding ->

        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            MikoTitle(
                "авторизация"
            )

            Column(
                modifier = Modifier
                    .padding(vertical = 20.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                MikoReadOnlyTextField(
                    value = loginRO
                )
                MikoTextField(
                    value = login,
                    "ввести логин"
                )
            }

            Column(
                modifier = Modifier
                    .padding(vertical = 20.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                MikoReadOnlyTextField(
                    value = passwordRO
                )
                MikoTextField(
                    value = password,
                    "ввести пароль"
                )
            }

            MikoButton(
                onClick = {
                    navController.navigate("order")
                },
                text = "ок",
                color = backgroundS
            )
        }
    }
}