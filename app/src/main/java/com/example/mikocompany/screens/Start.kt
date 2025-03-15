package com.example.mikocompany.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.mikocompany.MikoButton
import com.example.mikocompany.MikoName
import com.example.mikocompany.MikoText
import com.example.mikocompany.R
import com.example.mikocompany.ui.theme.backgroundP
import com.example.mikocompany.ui.theme.backgroundS

@Composable
fun Start(
    navController: NavHostController,
    start : MutableState<Boolean>
){
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
            verticalArrangement = Arrangement.SpaceAround
        ) {
            Column {
                Image(
                    painter = painterResource(R.drawable.logo),
                    contentDescription = "logo",
                    modifier = Modifier
                        .size(300.dp)
                )

                MikoText(
                    "RAEWDA PRODUCTION"
                )
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth(0.6F)
            ) {
                MikoButton(
                    onClick = {
                        navController.navigate("authorization")
                    },
                    text = "авторизация",
                    color = backgroundS,
                    modifier = Modifier.fillMaxWidth()
                )

                MikoButton(
                    onClick = {
                        navController.navigate("registration")
                    },
                    text = "регистрация",
                    color = backgroundS,
                    modifier = Modifier.fillMaxWidth()
                )

                MikoButton(
                    onClick = {
                        navController.navigate("applicationInfo")
                    },
                    text = "о приложении",
                    color = backgroundS,
                    modifier = Modifier.fillMaxWidth()
                )
            }

            MikoName()
        }
    }
}



//// создание поключения, получение VM
//val ViewModel = ViewModelProvider(LocalActivity.current as ComponentActivity)[StartViewModel::class.java]
//// получение стейта
//val vmstate = ViewModel.company_description.collectAsState()

//LaunchedEffect(Unit) {
//    // отображение изменений с VM
//    ViewModel.LoadCompanyDescription()
//}
