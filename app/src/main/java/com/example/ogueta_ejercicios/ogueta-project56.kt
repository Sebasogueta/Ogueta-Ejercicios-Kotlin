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
fun Project56(navController: NavController) {
    Column(modifier = Modifier.padding(20.dp)) {
        Text(
            text = "Project 56: Introduce the amount of triangles and the value of each of their sides.", textAlign = TextAlign.Center, color = Color.Green,
            fontWeight = FontWeight.Bold
        )
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {

        var triangles by remember { mutableStateOf("") }
        var side1 by remember { mutableStateOf("") }
        var side2 by remember { mutableStateOf("") }
        var side3 by remember { mutableStateOf("") }

        var outcome by remember { mutableStateOf("") }
        var outcome2 by remember { mutableStateOf("") }

        var number by remember { mutableStateOf(1) }
        var equilateral by remember { mutableStateOf(0) }
        var scalene by remember { mutableStateOf(0) }
        var isosceles by remember { mutableStateOf(0) }

        var isInputEnabled by remember { mutableStateOf(true) }



        OutlinedTextField(
            value = triangles,
            onValueChange = { triangles = it },
            label = {
                Text("Amount of triangles")
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            singleLine = true,
            enabled = isInputEnabled
        )

        OutlinedTextField(
            value = side1,
            onValueChange = { side1 = it },
            label = {
                Text("Side 1 of triangle $number")
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            singleLine = true
        )

        OutlinedTextField(
            value = side2,
            onValueChange = { side2 = it },
            label = {
                Text("Side 2 of triangle $number")
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            singleLine = true
        )

        OutlinedTextField(
            value = side3,
            onValueChange = { side3 = it },
            label = {
                Text("Side 3 of triangle $number")
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            singleLine = true
        )

        Button(
            onClick = {
                outcome=""
                outcome2=""
                isInputEnabled = false
                if(number<=triangles.toInt()){
                    if (side1 == side2 && side1 == side3) {
                        outcome="The triangle $number is equilateral."
                        equilateral++
                    } else
                        if (side1 == side2 || side1 == side3 || side2 == side3) {
                            outcome="The triangle $number is isosceles."
                            isosceles++
                        } else {
                            outcome="The triangle $number is scalene."
                            scalene++
                        }
                    side1= ""
                    side2= ""
                    side3=""
                }
                number+=1
                if(number>triangles.toInt()){

                    outcome2= "Equilateral triangles: $equilateral \nIsosceles triangles: $isosceles \nScalene triangles: $scalene"
                    triangles = ""
                    number=1
                    isInputEnabled = true
                    equilateral=0
                    isosceles=0
                    scalene=0

                }

            },
            modifier = Modifier.padding(10.dp)
        ) {
            Text(text = "Enter")
        }

        Text(
            text = "$outcome\n$outcome2",
            modifier = Modifier.padding(10.dp)
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Button(
                onClick = {
                    navController.navigate("ogueta-project55")
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
                    navController.navigate("ogueta-project57")
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



