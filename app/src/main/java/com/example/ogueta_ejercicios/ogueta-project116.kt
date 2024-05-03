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

fun Project116(navController: NavController) {
    Column(modifier = Modifier.padding(20.dp)) {
        Text(
            text = "Project 116: Enter 5 points (x and y)",
            textAlign = TextAlign.Center,
            color = Color.Green,
            fontWeight = FontWeight.Bold
        )
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {

        val pointsList = remember { mutableListOf<Point>() }
        var pointX by remember { mutableStateOf("") }
        var pointY by remember { mutableStateOf("") }
        var numbers by remember { mutableStateOf(1) }
        var outcome by remember { mutableStateOf("") }


        OutlinedTextField(
            value = pointX,
            onValueChange = { pointX = it },
            label = {
                Text("Point $numbers: X: ")
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            singleLine = true,
        )

        OutlinedTextField(
            value = pointY,
            onValueChange = { pointY = it },
            label = {
                Text("Point $numbers: Y: ")
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            singleLine = true
        )

        Button(
            onClick = {
                outcome=""
                if(numbers <=5){
                    pointsList.add(Point(pointX.toInt(), pointY.toInt()))
                    numbers++
                }

                if(numbers > 5){
                    for(e in pointsList){
                        outcome+= "The coordenate ${e.x}, ${e.y} it is located in ${e.returnQuadrant()} \n"
                    }
                    pointsList.clear()
                    numbers=1
                }

                pointX=""
                pointY=""
            },
            modifier = Modifier.padding(10.dp)
        ) {
            Text(text = "Add Point")
        }

        Text(
            text = outcome,
            modifier = Modifier.padding(10.dp)
        )
        navigation(navController)
    }
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
                navController.navigate("ogueta-project115")
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
                navController.navigate("ogueta-project118")
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

class Point (val x: Int, val y: Int){

    fun returnQuadrant() =
        when {
        x > 0 && y > 0 -> "the First quadrant"
        x < 0 && y > 0 -> "the Second quadrant"
        x < 0 && y < 0 -> "the Third quadrant"
        x > 0 && y < 0 -> "the Fourth quadrant"
        else -> "an axis"
    }
}
