package com.example.mikocompany.details

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.sp
import com.example.mikocompany.ui.theme.containerP
import com.example.mikocompany.ui.theme.containerS
import com.example.mikocompany.ui.theme.primary
import com.example.mikocompany.ui.theme.secondary
import com.example.mikocompany.ui.theme.zk

// for design modules
@Composable
fun MikoBackCard(
    modifier: Modifier = Modifier,
    color: Color,
    content: @Composable () -> Unit
){
    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(color)
    ) {
        content()
    }
}

// to sign the application
@Composable
fun MikoName(){
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(
            buildAnnotatedString {
                withStyle(style = SpanStyle(color = primary)) {
                    append("М")
                }
                withStyle(style = SpanStyle(color = containerS)) {
                    append("и")
                }
                withStyle(style = SpanStyle(color = containerP)) {
                    append("к")
                }
                withStyle(style = SpanStyle(color = secondary)) {
                    append("о")
                }
            },
            modifier = Modifier,
            fontFamily = zk,
            fontSize = 65.sp
        )
    }
}
