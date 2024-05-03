package com.example.ogueta_ejercicios

import android.widget.Toast
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun Project70(navController: NavController) {
    presentation(navController)

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun presentation(navController: NavController) {
    Column(modifier = Modifier.padding(20.dp)) {
        Text(
            text = "Project 70: Enter 2 whole numbers",
            textAlign = TextAlign.Center,
            color = Color.Green,
            fontWeight = FontWeight.Bold
        )
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {

        var num1 by remember { mutableStateOf("") }
        var num2 by remember { mutableStateOf("") }
        var outcome by remember { mutableStateOf("") }
        var theEnd by remember { mutableStateOf(false) }


        OutlinedTextField(
            value = num1,
            onValueChange = { num1 = it },
            label = {
                Text("Number 1")
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            singleLine = true
        )

        OutlinedTextField(
            value = num2,
            onValueChange = { num2 = it },
            label = {
                Text("Number 2")
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            singleLine = true
        )

        Button(
            onClick = {

                val sum= sumNumbers(num1.toInt(), num2.toInt())
                num1=""
                num2=""
                outcome = "The sum is: $sum"
                theEnd = true
            },
            modifier = Modifier.padding(10.dp)
        ) {
            Text(text = "Check")
        }

        Text(
            text = outcome,
            modifier = Modifier.padding(10.dp)
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Button(
                onClick = {
                    navController.navigate("ogueta-project69")
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
                    navController.navigate("ogueta-project71")
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
        if(theEnd){
            end()
            theEnd=false
        }
    }

}

private fun sumNumbers(num1: Int, num2: Int): Int {
    return num1+num2
}

@Composable
private fun end() {
    val context = LocalContext.current
    Toast.makeText(context, "This is the end of the program", Toast.LENGTH_SHORT).show()
}




