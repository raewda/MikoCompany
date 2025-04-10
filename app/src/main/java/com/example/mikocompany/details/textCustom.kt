package com.example.mikocompany.details

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mikocompany.ui.theme.primary
import com.example.mikocompany.ui.theme.secondary
import com.example.mikocompany.ui.theme.zk

// for titles
@Composable
fun MikoTitle(
    value : String
){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = value,
            modifier = Modifier,
            color = primary,
            fontFamily = zk,
            fontSize = 50.sp,
            softWrap = true
        )
    }
}

// for text
@Composable
fun MikoText(
    value : String
){
    Column(
        modifier = Modifier
            .padding(horizontal = 20.dp)
    ) {
        Text(
            text = value,
            modifier = Modifier,
            color = secondary,
            fontFamily = zk,
            fontSize = 25.sp,
            softWrap = true
        )
    }
}

// for subtitle
@Composable
fun MikoSecondaryText(
    value : String
){
    Column(
        modifier = Modifier
            .padding(horizontal = 20.dp)
    ) {
        Text(
            text = value,
            modifier = Modifier,
            color = secondary,
            fontFamily = zk,
            fontSize = 35.sp,
            softWrap = true
        )
    }
}