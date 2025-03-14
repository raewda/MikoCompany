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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.navigation.NavHostController
import com.example.mikocompany.MikoButton
import com.example.mikocompany.MikoInfoDialog
import com.example.mikocompany.MikoName
import com.example.mikocompany.MikoReadOnlyTextField
import com.example.mikocompany.MikoText
import com.example.mikocompany.MikoTextButton
import com.example.mikocompany.MikoTextField
import com.example.mikocompany.MikoTitle
import com.example.mikocompany.ui.theme.backgroundP
import com.example.mikocompany.ui.theme.backgroundS
import com.example.mikocompany.ui.theme.containerP
import com.example.mikocompany.ui.theme.containerS
import com.example.mikocompany.ui.theme.secondary

@Composable
fun Start(
    navController: NavHostController,
    start : MutableState<Boolean>
){

    //// создание поключения, получение VM
//val ViewModel = ViewModelProvider(LocalActivity.current as ComponentActivity)[StartViewModel::class.java]
//// получение стейта
//val vmstate = ViewModel.company_description.collectAsState()

//LaunchedEffect(Unit) {
//    // отображение изменений с VM
//    ViewModel.LoadCompanyDescription()
//}

    val test = remember { mutableStateOf(TextFieldValue("")) }
    val test2 = remember { mutableStateOf(TextFieldValue("test2")) }
    val openDialog = remember { mutableStateOf(false) }

    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        containerColor = Color(backgroundP.value)
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding),
            verticalArrangement = Arrangement.SpaceAround
        ) {
            MikoTitle("text")

            MikoText("text text text")

            MikoTextField(test, "hui")

            MikoReadOnlyTextField(test2)

            MikoButton(
                onClick = {
                    openDialog.value = true
                },
                text = "хуй",
                color = backgroundS
            )
            
            MikoTextButton(
                onClick = {},
                text = "jopa",
                color = secondary
            )

            if (openDialog.value){
                MikoInfoDialog(
                    openDialog = openDialog,
                    width = 300,
                    height = 300,
                    color = containerS,
                    textColor = backgroundS
//                vmstate = vmstate
                )
            }

            MikoName()
        }
    }
}