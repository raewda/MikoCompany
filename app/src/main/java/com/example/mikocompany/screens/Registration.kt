package com.example.mikocompany.screens

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.mikocompany.details.MikoButton
import com.example.mikocompany.details.MikoInfoDialog
import com.example.mikocompany.details.MikoLargeTextField
import com.example.mikocompany.details.MikoReadOnlyTextField
import com.example.mikocompany.details.MikoTextButton
import com.example.mikocompany.details.MikoTextField
import com.example.mikocompany.details.MikoTitle
import com.example.mikocompany.ui.theme.backgroundP
import com.example.mikocompany.ui.theme.backgroundS
import com.example.mikocompany.ui.theme.containerP
import com.example.mikocompany.ui.theme.containerS
import com.example.mikocompany.ui.theme.primary
import com.example.mikocompany.ui.theme.secondary

@Composable
fun Registration (
    navController: NavHostController,
    registration : MutableState<Boolean>
){
    val loginRO = remember { mutableStateOf(TextFieldValue("логин")) }
    val login = remember { mutableStateOf(TextFieldValue("")) }
    val passwordRO = remember { mutableStateOf(TextFieldValue("пароль")) }
    val password = remember { mutableStateOf(TextFieldValue("")) }
    val nameRO = remember { mutableStateOf(TextFieldValue("название компании")) }
    val name = remember { mutableStateOf(TextFieldValue("")) }
    val emailRO = remember { mutableStateOf(TextFieldValue("email")) }
    val email = remember { mutableStateOf(TextFieldValue("")) }
    val phoneRO = remember { mutableStateOf(TextFieldValue("номер телефона")) }
    val phone = remember { mutableStateOf(TextFieldValue("")) }
    val descriptionRO = remember { mutableStateOf(TextFieldValue("описание компании")) }
    val description = remember { mutableStateOf(TextFieldValue("")) }
    val conditionsRO = remember { mutableStateOf(TextFieldValue("условия компании")) }
    val conditions = remember { mutableStateOf(TextFieldValue("")) }

    var checked by remember { mutableStateOf(false) }
    val context = LocalContext.current

    val openInfoDialog = remember { mutableStateOf(false) }

    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        containerColor = backgroundP
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .fillMaxSize()
                .padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            MikoButton(
                onClick = {
                    openInfoDialog.value = true
                },
                modifier = Modifier
                    .fillMaxWidth(),
                icon = Icons.Default.Info,
                color = backgroundS
            )

            if (openInfoDialog.value){
                MikoInfoDialog(
                    openDialog = openInfoDialog,
                    width = 350,
                    height = 500,
                    textColor = backgroundS,
                    color = containerS
                )
            }

            MikoTitle(
                "регистрация"
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth(0.65F)
            ) {
                Column(
                    modifier = Modifier
                        .padding(vertical = 20.dp),
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    MikoReadOnlyTextField(
                        value = loginRO
                    )
                    MikoTextField(
                        value = login,
                        "ввести логин"
                    )
                }

                Column(
                    modifier = Modifier
                        .padding(vertical = 20.dp),
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    MikoReadOnlyTextField(
                        value = passwordRO
                    )
                    MikoTextField(
                        value = password,
                        "ввести пароль"
                    )
                }

                Column(
                    modifier = Modifier
                        .padding(vertical = 20.dp),
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    MikoReadOnlyTextField(
                        value = nameRO
                    )
                    MikoTextField(
                        value = name,
                        "ввести название"
                    )
                }

                Column(
                    modifier = Modifier
                        .padding(vertical = 20.dp),
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    MikoReadOnlyTextField(
                        value = emailRO
                    )
                    MikoTextField(
                        value = email,
                        "ввести email",
                        keyType = KeyboardType.Email
                    )
                }

                Column(
                    modifier = Modifier
                        .padding(vertical = 20.dp),
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    MikoReadOnlyTextField(
                        value = phoneRO
                    )
                    MikoTextField(
                        value = phone,
                        "ввести номер",
                        keyType = KeyboardType.Phone
                    )
                }

                Column(
                    modifier = Modifier
                        .padding(vertical = 20.dp),
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    MikoReadOnlyTextField(
                        value = descriptionRO
                    )
                    MikoLargeTextField(
                        value = description,
                        placeHol = "ввести описание компании"
                    )
                }

                Column(
                    modifier = Modifier
                        .padding(vertical = 20.dp),
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    MikoReadOnlyTextField(
                        value = conditionsRO
                    )
                    MikoLargeTextField(
                        value = conditions,
                        placeHol = "ввести условия компании"
                    )
                }
            }

            MikoButton(
                onClick = {
                    if (checked
                        && login.value.text.isNotEmpty()
                        && password.value.text.isNotEmpty()
                        && name.value.text.isNotEmpty()
                        && email.value.text.isNotEmpty()
                        && phone.value.text.isNotEmpty()
                        && description.value.text.isNotEmpty()
                        && conditions.value.text.isNotEmpty()
                    ){
                        navController.navigate("order")
                    }
                    else{
                        Toast.makeText(context, "все поля должны быть заполнены", Toast.LENGTH_SHORT).show()
                    }
                },
                text = "ок",
                color = backgroundS
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Checkbox(
                    checked = checked,
                    onCheckedChange = { checked = it },
                    modifier = Modifier,
                    colors = CheckboxDefaults.colors(
                        checkedColor = primary,
                        uncheckedColor = containerP,
                        checkmarkColor = containerP
                    )
                )
                MikoTextButton(
                    onClick = {
                        navController.navigate("applicationInfo")
                    },
                    text = "принять политику конфиденциальности приложения",
                    color = containerS
                )
            }
        }
    }
}