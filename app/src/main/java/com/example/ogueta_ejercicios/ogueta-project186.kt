package com.example.ogueta_ejercicios

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Project186(navController: NavController) {
    Column(modifier = Modifier.padding(20.dp)) {
        Text(
            text = "Project 186: ",
            textAlign = TextAlign.Center,
            color = Color.Green,
            fontWeight = FontWeight.Bold
        )
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {

        val agenda by remember { mutableStateOf(mutableMapOf<Date, String>()) }
        var day by remember { mutableStateOf("") }
        var month by remember { mutableStateOf("") }
        var year by remember { mutableStateOf("") }
        var activity by remember { mutableStateOf("") }
        var outcome by remember { mutableStateOf("") }

        OutlinedTextField(
            value = day,
            onValueChange = { day = it },
            label = {
                Text("Day:")
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            singleLine = true,
        )

        OutlinedTextField(
            value = month,
            onValueChange = { month = it },
            label = {
                Text("Month:")
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            singleLine = true,
        )

        OutlinedTextField(
            value = year,
            onValueChange = { year = it },
            label = {
                Text("Year:")
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            singleLine = true,
        )

        OutlinedTextField(
            value = activity,
            onValueChange = { activity = it },
            label = {
                Text("Activity:")
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            singleLine = true
        )

        Row (modifier = Modifier.padding(8.dp)){

            Button(
                onClick = {
                    outcome = ""
                    agenda[Date(day.toInt(), month.toInt(), year.toInt())] = activity
                    day=""
                    month=""
                    year=""
                    activity=""
                },
                modifier = Modifier.weight(1f)
            ) {
                Text(text = "Add activity")
            }

            Button(
                onClick = {
                    outcome = print(agenda)
                },
                modifier = Modifier.weight(1f)
            ) {
                Text(text = "Show activity")
            }

        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Spacer(modifier = Modifier.weight(1f))
            Button(
                onClick = {
                    outcome = checkDate(agenda, day.toInt(), month.toInt(), year.toInt())
                    day = ""
                    month = ""
                    year = ""
                },
                modifier = Modifier
                    .padding(8.dp)
                    .weight(2f)
            ) {
                Text(text = "Check activity")
            }
            Spacer(modifier = Modifier.weight(1f))
        }

        Text(
            text = outcome,
            modifier = Modifier.padding(10.dp)
        )
        navigation(navController)
    }
}


@Composable
private fun navigation(navController: NavController) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Button(
            onClick = {
                navController.navigate("ogueta-project180")
            },
            modifier = Modifier
                .padding(8.dp)
                .weight(1f)
        ) {
            Text(text = "Previous")
        }
        Spacer(modifier = Modifier.weight(1f))
        Button(
            onClick = {
                navController.navigate("ogueta-project189")
            },
            modifier = Modifier
                .padding(8.dp)
                .weight(1f)
        ) {
            Text(text = "Next")
        }
    }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {

        Spacer(modifier = Modifier.weight(1f))
        Button(
            onClick = {
                navController.navigate("ogueta-mainmenu")
            },
            modifier = Modifier
                .padding(8.dp)
                .weight(2f)
        ) {
            Text(text = "Main Menu")
        }
        Spacer(modifier = Modifier.weight(1f))

    }
}

data class Date(val day: Int, val month: Int, val year: Int)

fun print(agenda: MutableMap<Date, String>): String {
    var text = ""
    for((date, activity) in agenda) {
        text+=("Date ${date.day}/${date.month}/${date.year}\n")
        text+=("Activities: $activity\n")
    }
    text+="\n"
    return text
}

fun checkDate(agenda: MutableMap<Date, String>, day: Int, month: Int, year: Int): String {
    val date = Date(day, month, year)
    return if (date in agenda)
        "Activity: ${agenda[date]}"
    else
        "There are no activities registered for that date"
}
