package com.example.mikocompany.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.mikocompany.details.MikoBottomBar

@Composable
fun Category(
    navController : NavHostController,
    category : MutableState<Boolean>
){
    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        bottomBar = {
            MikoBottomBar(navController)
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
        ) {

        }
    }
}