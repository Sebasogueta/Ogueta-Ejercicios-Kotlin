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
import androidx.compose.runtime.mutableStateListOf
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
fun Project103(navController: NavController) {
    Column(modifier = Modifier.padding(20.dp)) {
        Text(
            text = "Project 103: Enter 8 numbers",
            textAlign = TextAlign.Center,
            color = Color.Green,
            fontWeight = FontWeight.Bold
        )
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {

        var numArray by remember { mutableStateOf(IntArray(8)) }
        var enteredNum by remember { mutableStateOf("") }
        var numbers by remember { mutableStateOf(1) }
        var outcome by remember { mutableStateOf("") }


        OutlinedTextField(
            value = enteredNum,
            onValueChange = { enteredNum = it },
            label = {
                Text("Number $numbers:")
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            singleLine = true
        )


        Button(
            onClick = {

                if (numbers <= 8) {
                    numArray[numbers - 1] = enteredNum.toInt()
                    numbers++
                }
                if (numbers > 8) {
                    numbers = 1
                    val sumArray = sumElements(numArray)
                    val sumPlus36 = sumElements36(numArray)
                    val countPlus50 = countElements50(numArray)
                    outcome = "The sum of every number of the array is: $sumArray \nThe sum of every number higher than 36 is: $sumPlus36 \n The amount of numbers higher than 50 is: $countPlus50"
                   numArray.fill(0) // clears evey number of the array and asigns 0 to every cell
                }
                enteredNum = ""

            },
            modifier = Modifier.padding(10.dp)
        ) {
            Text(text = "Check")
        }

        Text(
            text = outcome,
            modifier = Modifier.padding(10.dp)
        )
        navigation(navController)
    }
}

private fun countElements50(numArray: IntArray): Int {

    var count = 0
    for (i in numArray.indices) {
        if (numArray[i] > 50) {
            count++
        }
    }
    return count

}

private fun sumElements36(numArray: IntArray): Int {

    var sum = 0
    for (i in numArray.indices) {
        if (numArray[i] > 36) {
            sum += numArray[i]
        }
    }
    return sum

}

private fun sumElements(numArray: IntArray): Int {

    var sum = 0
    for (i in numArray.indices) {
        sum += numArray[i]
    }
    return sum

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
                navController.navigate("ogueta-project97")
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
                navController.navigate("ogueta-project104")
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



