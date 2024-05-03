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
fun Project104(navController: NavController) {
    Column(modifier = Modifier.padding(20.dp)) {
        Text(
            text = "Project 104: Enter 4 numbers in each array",
            textAlign = TextAlign.Center,
            color = Color.Green,
            fontWeight = FontWeight.Bold
        )
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {

        var numArray1 by remember { mutableStateOf(IntArray(4)) }
        var numArray2 by remember { mutableStateOf(IntArray(4)) }
        var enteredNum1 by remember { mutableStateOf("") }
        var enteredNum2 by remember { mutableStateOf("") }
        var numbers by remember { mutableStateOf(1) }
        var outcome by remember { mutableStateOf("") }


        OutlinedTextField(
            value = enteredNum1,
            onValueChange = { enteredNum1 = it },
            label = {
                Text("Array 1, number $numbers:")
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            singleLine = true
        )
        OutlinedTextField(
            value = enteredNum2,
            onValueChange = { enteredNum2 = it },
            label = {
                Text("Array 2, number $numbers:")
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            singleLine = true
        )


        Button(
            onClick = {

                if (numbers <= 4) {
                    numArray1[numbers - 1] = enteredNum1.toInt()
                    numArray2[numbers - 1] = enteredNum2.toInt()
                    numbers++
                }
                if (numbers > 4) {
                    numbers = 1
                    val sumArray = sumArrays(numArray1, numArray2)
                    outcome= "The elements of both arrays merged are: "
                    for(i in sumArray.indices) {
                        outcome += "${sumArray[i]}, "
                    }
                   numArray1.fill(0) // clears evey number of the array and asigns 0 to every cell
                   numArray2.fill(0)
                }
                enteredNum1 = ""
                enteredNum2 = ""

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

private fun sumArrays(numArray1: IntArray, numArray2: IntArray): IntArray {
    val sumArray = IntArray(4)
    for(i in sumArray.indices){
        sumArray[i]= numArray1[i]+numArray2[i]
    }
    return sumArray
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
                navController.navigate("ogueta-project103")
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
                navController.navigate("ogueta-project107")
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



