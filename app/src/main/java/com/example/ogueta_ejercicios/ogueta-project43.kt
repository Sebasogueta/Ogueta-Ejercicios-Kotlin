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
fun Project43(navController: NavController) {
    Column(modifier = Modifier.padding(20.dp)) {
        Text(
            text = "Project 43: Introduce numbers. When you finish enter 0", textAlign = TextAlign.Center, color = Color.Green,
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
        var numSum by remember { mutableStateOf(0) }


        OutlinedTextField(
            value = numValue,
            onValueChange = { numValue = it },
            label = {
                Text("Enter number ${numCount+1}, or introduce 0 to finish")
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            singleLine = true
        )

        Button(
            onClick = {
                outcome=""
                if(numValue.toInt() != 0){
                    numSum+=numValue.toInt()
                    numCount+=1
                }
                if(numValue.toInt() == 0 && numCount != 0){
                    val average = (numSum / numCount).toDouble()
                    outcome= "The average is $average"
                    numCount=0
                    numSum=0
                }
                else if (numCount == 0){
                    outcome="No values where given"
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
                    navController.navigate("ogueta-project42")
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
                    navController.navigate("ogueta-project44")
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


