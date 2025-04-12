package com.example.mikocompany.details

import androidx.compose.foundation.background
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
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.example.mikocompany.dcl.NavRouts.Companion.routsAll
import com.example.mikocompany.ui.theme.backgroundS
import com.example.mikocompany.ui.theme.secondary
import kotlinx.coroutines.launch

@Composable
fun MikoBurgerMenu(
    navController : NavHostController
){
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

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
                            color = backgroundS
                        )
                    }
                }
            }
        },
    ) {
        Scaffold(
            floatingActionButton = {
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
            },
            modifier = Modifier
                .fillMaxHeight(),
            containerColor = Color.Transparent
        ){ contentPadding ->
            Column(
                modifier = Modifier
                    .padding(contentPadding)
            ) {

            }
        }
    }

}

@Composable
fun MikoBottomBar(
    navController : NavHostController
){
    BottomAppBar(
        actions = {
            Row(
                modifier = Modifier
                    .fillMaxSize(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {

                MikoBurgerMenu(
                    navController
                )

                MikoTextButton(
                    onClick = { },
                    text = "warehouse",
                    color = secondary
                    )

                MikoTextButton(
                    onClick = { },
                    text = "profile",
                    color = secondary
                )
            }
        },
        modifier = Modifier
            .fillMaxWidth(),
        containerColor = backgroundS
    )
}