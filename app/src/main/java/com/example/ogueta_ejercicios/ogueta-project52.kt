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
fun Project52(navController: NavController) {
    Column(modifier = Modifier.padding(20.dp)) {
        Text(
            text = "Project 52: Introduce the amount of triangles you want to enter and the value of their base and height.", textAlign = TextAlign.Center, color = Color.Green,
            fontWeight = FontWeight.Bold
        )
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {

        var triangles by remember { mutableStateOf("") }
        var base by remember { mutableStateOf("") }
        var height by remember { mutableStateOf("") }
        var outcome by remember { mutableStateOf("") }
        var outcome2 by remember { mutableStateOf("") }

        var number by remember { mutableStateOf(1) }
        var areaHigher12 by remember { mutableStateOf(0) }
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
            value = base,
            onValueChange = { base = it },
            label = {
                Text("Base of triangle $number")
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            singleLine = true
        )

        OutlinedTextField(
            value = height,
            onValueChange = { height = it },
            label = {
                Text("Height of triangle $number")
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
                    val area = ((base.toInt()*height.toInt().toDouble()) / 2)
                    if (area.toDouble() > 12){
                        areaHigher12+=1
                    }
                    outcome="The area of triangle $number (base: $base and height: $height) is $area"
                    base= ""
                    height= ""
                }
                number+=1
                if(number>triangles.toInt()){

                    outcome2= "Amount of triangles with an area greater than 12: $areaHigher12"
                    triangles = ""
                    areaHigher12=0
                    number=1
                    isInputEnabled = true

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
                    navController.navigate("ogueta-project51")
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
                    navController.navigate("ogueta-project53")
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



