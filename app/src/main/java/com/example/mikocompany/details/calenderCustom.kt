package com.example.mikocompany.details

import androidx.compose.foundation.layout.size
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDefaults
import androidx.compose.material3.DatePickerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.mikocompany.ui.theme.backgroundS
import com.example.mikocompany.ui.theme.containerS
import com.example.mikocompany.ui.theme.secondary

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun MikoCalender(
    datePickerState : MutableState<DatePickerState>
){
    DatePicker(
        state = datePickerState.value,
        modifier = Modifier,
        title = {
            DatePickerDefaults.DatePickerTitle(
                displayMode = datePickerState.value.displayMode,
                modifier = Modifier
            )
        },
        headline = {
            DatePickerDefaults.DatePickerHeadline(
                selectedDateMillis = datePickerState.value.selectedDateMillis,
                displayMode = datePickerState.value.displayMode,
                modifier = Modifier,
                dateFormatter = DatePickerDefaults.dateFormatter()
            )
        },
        showModeToggle = true,
        colors = DatePickerDefaults.colors(
            selectedDayContainerColor = containerS,
            selectedDayContentColor = backgroundS,
            selectedYearContentColor = backgroundS,
            selectedYearContainerColor = containerS,
            navigationContentColor = secondary,
            yearContentColor = containerS,
            todayContentColor = secondary,
            todayDateBorderColor = secondary,
            dividerColor = containerS,
            currentYearContentColor = secondary,
            titleContentColor = secondary,
            headlineContentColor = secondary,
            subheadContentColor = containerS,
            dateTextFieldColors = TextFieldDefaults.colors(
                focusedContainerColor = Color.Transparent,
                focusedIndicatorColor = secondary,
                unfocusedIndicatorColor = containerS,
                focusedTextColor = secondary,
                unfocusedTextColor = containerS,
                focusedLabelColor = secondary,
                unfocusedLabelColor = containerS,
                unfocusedContainerColor = Color.Transparent
            )
        )
    )
}