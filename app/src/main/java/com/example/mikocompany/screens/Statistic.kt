package com.example.mikocompany.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.navigation.NavHostController
import com.example.mikocompany.details.MikoNavigation

@Composable
fun Statistic(
    navController : NavHostController,
    statistic : MutableState<Boolean>
){
    MikoNavigation(
        navController
    ) {

    }
}