package com.example.mikocompany.details

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.example.mikocompany.dcl.NavRouts.Companion.routsAll
import com.example.mikocompany.ui.theme.backgroundS
import com.example.mikocompany.ui.theme.lightContainerS
import com.example.mikocompany.ui.theme.primary
import com.example.mikocompany.ui.theme.secondary
import kotlinx.coroutines.launch

@Composable
fun MikoNavigation(
    navController : NavHostController,
    content : @Composable () -> Unit
){
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    val navBackStackEntry = navController.currentBackStackEntryFlow.collectAsState(initial = null).value
    val currentRoute = navBackStackEntry?.destination?.route

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet(
                drawerContainerColor = Color.Transparent
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxHeight()
                        .verticalScroll(rememberScrollState())
                ) {
                    for (i in routsAll.indices){
                        MikoButton(
                            onClick = {
                                navController.navigate(routsAll.get(index = i).name)
                            },
                            text = routsAll.get(index = i).translate,
                            color =
                                if (currentRoute == routsAll.get(index = i).name){
                                    lightContainerS
                                }
                                else{
                                    backgroundS
                                }
                        )
                    }
                }
            }
        },
    ) {
        Scaffold(
            modifier = Modifier
                .fillMaxHeight(),
            containerColor = Color.Transparent,
            bottomBar = {
                BottomAppBar(
                    actions = {
                        Row(
                            modifier = Modifier
                                .fillMaxSize(),
                            horizontalArrangement = Arrangement.SpaceAround
                        ) {
                            MikoButton(
                                onClick = {
                                    scope.launch {
                                        drawerState.apply {
                                            if (isClosed) open() else close()
                                        }
                                    }
                                },
                                icon = Icons.Filled.Menu,
                                color = secondary
                            )

                            MikoTextButton(
                                onClick = {
                                    navController.navigate("warehouse")
                                },
                                text = "склад",
                                color =
                                    if (currentRoute == "warehouse"){
                                        primary
                                    }
                                    else{
                                        secondary
                                    }
                            )

                            MikoTextButton(
                                onClick = {
                                    navController.navigate("profile")
                                },
                                text = "профиль",
                                color =
                                if (currentRoute == "profile"){
                                    primary
                                }
                                else{
                                    secondary
                                }
                            )
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth(),
                    containerColor = backgroundS
                )
            }
        ){ innerPadding ->
            Column(
                modifier = Modifier
                    .padding(innerPadding)
            ) {
                content
            }
        }
    }

}
