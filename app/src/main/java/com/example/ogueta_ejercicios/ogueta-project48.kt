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
fun Project48(navController: NavController) {
    Column(modifier = Modifier.padding(20.dp)) {
        Text(
            text = "Project 48: Enter 10 whole numbers", textAlign = TextAlign.Center, color = Color.Green,
            fontWeight = FontWeight.Bold
        )
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {

        var num1 by remember { mutableStateOf("") }
        var outcome by remember { mutableStateOf("") }
        var number by remember { mutableStateOf(1) }
        var sum by remember { mutableStateOf(0) }
        var average by remember { mutableStateOf(0.0) }


        OutlinedTextField(
            value = num1,
            onValueChange = { num1 = it },
            label = {
                Text("Number $number")
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            singleLine = true
        )



        Button(
            onClick = {
                outcome=""
                if(number<=10){
                    sum+=num1.toInt()
                    num1 = ""
                }
                number+=1
                if(number>10){
                    average= sum.toDouble() / 10
                    outcome= "The sum is $sum, and the average is $average."
                    number=1
                    sum=0

                }

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
                    navController.navigate("ogueta-project47")
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
                    navController.navigate("ogueta-project49")
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
}



