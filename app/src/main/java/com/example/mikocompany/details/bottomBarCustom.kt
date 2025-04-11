package com.example.mikocompany.details

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.BottomAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.mikocompany.ui.theme.backgroundS
import com.example.mikocompany.ui.theme.lightContainerP

@Composable
fun bottomBarCustom(

){
    BottomAppBar(
        actions = {
            Row(
                modifier = Modifier
                    .fillMaxSize(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {

                MikoTextButton(
                    onClick = { },
                    text = "warehouse",
                    color = backgroundS
                    )

                MikoTextButton(
                    onClick = { },
                    text = "profile",
                    color = backgroundS
                )
            }
        },
        modifier = Modifier
            .fillMaxWidth(),
        containerColor = lightContainerP
    )
}