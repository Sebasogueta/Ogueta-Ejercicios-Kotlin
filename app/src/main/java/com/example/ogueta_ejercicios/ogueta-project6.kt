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
fun Project6(navController: NavController) {
    Column(modifier = Modifier.padding(20.dp)) {
        Text(text = "Project 6: Introduce the side of a square",textAlign = TextAlign.Center,color= Color.Green,
            fontWeight = FontWeight.Bold)
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {

        var side by remember { mutableStateOf("") }
        var outcome by remember { mutableStateOf("") }

        OutlinedTextField (
            value = side,
            onValueChange = { side = it },
            label = {
                Text("Square's side")
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            singleLine = true
        )

        Button(
            onClick = {
                val perimeter = (side.toInt()*4).toString()
                outcome = "The perimeter of the square is $perimeter"
            },
            modifier = Modifier.padding(10.dp)
        ) {
            Text(text = "Calculate Perimeter")
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
                    navController.navigate("ogueta-project5")
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
                    navController.navigate("ogueta-project7")
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
