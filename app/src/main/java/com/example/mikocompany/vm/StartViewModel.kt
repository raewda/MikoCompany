package com.example.mikocompany.vm

import androidx.activity.ComponentActivity
import androidx.activity.compose.LocalActivity
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.text.input.TextFieldValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.flow.MutableStateFlow

//class StartViewModel : ViewModel() {
//    val company_description = MutableStateFlow("")
//
//    fun LoadCompanyDescription(){
//        company_description.value = "jdjfjfj"
//    }
//}

// во вьюхе так:

//// создание поключения, получение VM
//val ViewModel = ViewModelProvider(LocalActivity.current as ComponentActivity)[StartViewModel::class.java]
//// получение стейта
//val vmstate = ViewModel.company_description.collectAsState()

//LaunchedEffect(Unit) {
//    // отображение изменений с VM
//    ViewModel.LoadCompanyDescription()
//}