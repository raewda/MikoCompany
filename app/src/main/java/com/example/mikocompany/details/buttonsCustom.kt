package com.example.mikocompany.details

import android.util.Log
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mikocompany.ui.theme.containerP
import com.example.mikocompany.ui.theme.containerS
import com.example.mikocompany.ui.theme.zk

// for accent buttons
@Composable
fun MikoButton(
    onClick: () -> Unit,
    icon : ImageVector? = null,
    text : String? = null,
    color : Color,
    modifier: Modifier = Modifier
){
    Button(
        onClick = onClick,
        modifier = modifier
            .padding(vertical = 5.dp)
            .padding(horizontal = 15.dp),
        colors = ButtonDefaults.buttonColors(containerS),
        shape = RoundedCornerShape(12.dp)
    ) {
        if (icon != null && text == null){
            Icon(
                imageVector = icon,
                contentDescription = "icon in button",
                tint = color
            )
        }
        else if (icon == null && text != null){
            Text(
                text = text,
                modifier = Modifier,
                color = color,
                fontFamily = zk,
                fontSize = 25.sp
            )
        }
        else{
            Log.d("button", "ЛИБО ИКОНКА, ЛИБО ТЕКСТ!!!!!!!!")
        }
    }
}

// for hidden buttons
@Composable
fun MikoTextButton(
    onClick: () -> Unit,
    text: String,
    color: Color
){
    TextButton(
        onClick = onClick,
        modifier = Modifier
    ) {
        Text(
            text = text,
            modifier = Modifier,
            fontFamily = zk,
            fontSize = 25.sp,
            color = color
        )
    }
}
