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
fun Project57(navController: NavController) {
    Column(modifier = Modifier.padding(20.dp)) {
        Text(
            text = "Project 57: Enter the amount of coordinates and the value of each one (x, y)",
            textAlign = TextAlign.Center,
            color = Color.Green,
            fontWeight = FontWeight.Bold
        )
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {


        var coords by remember { mutableStateOf("") }
        var x by remember { mutableStateOf("") }
        var y by remember { mutableStateOf("") }
        var outcome by remember { mutableStateOf("") }
        var number by remember { mutableStateOf(1) }
        var isInputEnabled by remember { mutableStateOf(true) }


        var firstQ by remember { mutableStateOf(0) }
        var secondQ by remember { mutableStateOf(0) }
        var thirdQ by remember { mutableStateOf(0) }
        var fourthQ by remember { mutableStateOf(0) }

        OutlinedTextField(
            value = coords,
            onValueChange = { coords = it },
            label = {
                Text("Coordinates")
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            singleLine = true,
            enabled = isInputEnabled
        )

        OutlinedTextField(
            value = x,
            onValueChange = { x = it },
            label = {
                Text("Coordinate X")
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            singleLine = true
        )

        OutlinedTextField(
            value = y,
            onValueChange = { y = it },
            label = {
                Text("Coordinate Y")
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            singleLine = true
        )


        Button(
            onClick = {
                outcome = ""
                isInputEnabled = false
                if (number <= coords.toInt()) {

                    if (x.toInt() > 0 && y.toInt() > 0) {
                        firstQ++
                    } else if (x.toInt() < 0 && y.toInt() > 0) {
                        secondQ++
                    } else if (x.toInt() < 0 && y.toInt() < 0) {
                        thirdQ++
                    } else if (x.toInt() > 0 && y.toInt() < 0) {
                        fourthQ++
                    }
                    x = ""
                    y = ""
                    number++
                }
                if (number > coords.toInt()) {
                    outcome =
                        "Coordinates in the first quadrant: $firstQ \nCoordinates in the second quadrant: $secondQ \nCoordinates in the third quadrant: $thirdQ \n Coordinates in the fourth quadrant: $fourthQ"
                    firstQ = 0
                    secondQ = 0
                    thirdQ = 0
                    fourthQ = 0
                    number = 1
                    isInputEnabled = true
                    coords = ""
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
                    navController.navigate("ogueta-project56")
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
                    navController.navigate("ogueta-project58")
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



