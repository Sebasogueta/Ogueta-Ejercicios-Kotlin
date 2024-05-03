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
fun Project108(navController: NavController) {
    Column(modifier = Modifier.padding(20.dp)) {
        Text(
            text = "Project 108: Introduce the size of the array and assign a value to every element",
            textAlign = TextAlign.Center,
            color = Color.Green,
            fontWeight = FontWeight.Bold
        )
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {

        var arraySize by remember { mutableStateOf("") }
        var numValue by remember { mutableStateOf("") }
        var numbers by remember { mutableStateOf(1) }
        var outcome by remember { mutableStateOf("") }
        var numArray by remember { mutableStateOf<IntArray?>(null) } //intArray or null
        var arrayEnter by remember { mutableStateOf(true) }


        OutlinedTextField(
            value = arraySize,
            onValueChange = { arraySize = it },
            label = {
                Text("Array Size: ")
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            singleLine = true,
            enabled = arrayEnter
        )

        OutlinedTextField(
            value = numValue,
            onValueChange = { numValue = it },
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
                if (arraySize.isNotEmpty()) {
                    arrayEnter = false
                    if (numbers <= arraySize.toInt()) {
                        if (numArray == null) {
                            numArray = IntArray(arraySize.toInt())
                        }
                        numArray!![numbers - 1] = numValue.toInt()
                        numbers++
                        numValue = ""
                        if (numbers > arraySize.toInt()) { //if the array is complete
                            val smallest = smallest(numArray!!)
                            val repeated = repeated(numArray!!, smallest!!)
                            outcome = "Array creation completed. The smallest is $smallest and it is repeated $repeated times"
                            arraySize = ""
                            numbers = 1
                            numArray = null
                            arrayEnter = true
                        }
                    }
                } else {
                    outcome = "Please enter the array size first."
                }
            },
            modifier = Modifier.padding(10.dp)
        ) {
            Text(text = "Add Number")
        }

        Text(
            text = outcome,
            modifier = Modifier.padding(10.dp)
        )
        navigation(navController)
    }
}

fun smallest(numArray:IntArray): Int? {

    var smallest: Int? = null
    for (element in numArray) {
        if(smallest==null){
            smallest=element
        }
        else{
            if(smallest>element){
                smallest=element
            }
        }
    }
    return smallest
}

fun repeated(numArray:IntArray, smallest: Int): Int? {

    var countRepeated = -1
    for (element in numArray) {
        if (element == smallest){
            countRepeated++
        }
    }
    return countRepeated
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
                navController.navigate("ogueta-project107")
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
                navController.navigate("ogueta-project111")
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



