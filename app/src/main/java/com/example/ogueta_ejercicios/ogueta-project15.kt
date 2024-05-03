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
fun Project15(navController: NavController) {
    Column(modifier = Modifier.padding(20.dp)) {
        Text(text = "Project 15: Enter two whole numbers",textAlign = TextAlign.Center,color= Color.Green,
            fontWeight = FontWeight.Bold)
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {

        var num by remember { mutableStateOf("") }
        var num2 by remember { mutableStateOf("") }
        var outcome by remember { mutableStateOf("") }
        var highernum by remember { mutableStateOf(0) }

        OutlinedTextField (
            value = num,
            onValueChange = { num = it },
            label = {
                Text("First Number")
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            singleLine = true
        )

        OutlinedTextField (
            value = num2,
            onValueChange = { num2 = it },
            label = {
                Text("Second Number")
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            singleLine = true
        )

        Button(
            onClick = {

                if(num.toInt() > num2.toInt()){

                   highernum = num.toInt()
                }
                else{

                    highernum = num2.toInt()
                }

                outcome="The higher number between $num and $num2 is $highernum"

            },
            modifier = Modifier.padding(10.dp)
        ) {
            Text(text = "Check")
        }

        Text(
            text = outcome,
            modifier = Modifier.padding(10.dp)
        )
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)) {
            Button(
                onClick = {
                    navController.navigate("ogueta-project14")
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
                    navController.navigate("ogueta-project16")
                },
                modifier = Modifier
                    .padding(8.dp)
                    .weight(1f)
            ) {
                Text(text = "Next")
            }
        }
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)) {

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


