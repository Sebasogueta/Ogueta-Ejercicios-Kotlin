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
fun Project44(navController: NavController) {
    Column(modifier = Modifier.padding(20.dp)) {
        Text(
            text = "Project 44: Introduce the weight of the pieces. When you're finished, enter 0.", textAlign = TextAlign.Center, color = Color.Green,
            fontWeight = FontWeight.Bold
        )
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {

        var numValue by remember { mutableStateOf("") }
        var outcome by remember { mutableStateOf("") }

        var numCount by remember { mutableStateOf(0) }

        var weightLower98 by remember { mutableStateOf(0) }
        var weight98to102 by remember { mutableStateOf(0) }
        var weightHigher102 by remember { mutableStateOf(0) }


        OutlinedTextField(
            value = numValue,
            onValueChange = { numValue = it },
            label = {
                Text("Enter the weight of piece number ${numCount+1}, or introduce 0 to finish")
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            singleLine = true
        )

        Button(
            onClick = {
                outcome=""
                if(numValue.toDouble() != 0.0) {
                    numCount += 1
                    if (numValue.toDouble() < 9.8) {
                        weightLower98 += 1
                    }
                    else if (numValue.toDouble() >= 9.8 && numValue.toDouble() <= 10.2){
                        weight98to102+=1
                    }
                    else{
                        weightHigher102+=1
                    }

                }
                if(numValue.toDouble() == 0.0){
                    outcome = "Pieces weighing between 9.8kg and 10.2kg: $weight98to102\nPieces weighing less than 9.8kg: $weightLower98\nPieces weighing more than 10.2kg: $weightHigher102"
                    numCount=0
                    weightLower98=0
                    weight98to102=0
                    weightHigher102=0
                }
                numValue=""

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
                    navController.navigate("ogueta-project43")
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
                    navController.navigate("ogueta-project45")
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



