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

fun Project143(navController: NavController) {
    Column(modifier = Modifier.padding(20.dp)) {
        Text(
            text = "Project 143: Insert side of a square, then 2 sides of a rectangle",
            textAlign = TextAlign.Center,
            color = Color.Green,
            fontWeight = FontWeight.Bold
        )
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {

        var side1 by remember { mutableStateOf("") }
        var side2 by remember { mutableStateOf("") }
        var numbers by remember { mutableStateOf(1) }
        var outcome by remember { mutableStateOf("") }
        var showInput by remember { mutableStateOf(false) }


        OutlinedTextField(
            value = side1,
            onValueChange = { side1 = it },
            label = {
                Text("Figure $numbers: Side:")
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            singleLine = true,
        )

        OutlinedTextField(
            value = side2,
            onValueChange = { side2 = it },
            label = {
                Text("Figure $numbers: Side 2:")
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            singleLine = true,
            enabled = showInput
        )



        Button(
            onClick = {
                outcome=""
                if(numbers ==1){
                    val square1 = Square(side1.toInt())
                    numbers++
                    outcome= "${square1.resultTitle()}\n"
                    outcome+= "Square perimeter: ${square1.calculatePerimeter()}\n"
                    outcome+= "Square area: ${square1.calculateArea()}"
                    showInput=true
                }
                else if(numbers ==2){
                    val rectangle1 = Rectangle(side1.toInt(),side2.toInt())
                    outcome= "${rectangle1.resultTitle()}\n"
                    outcome+= "Rectangle perimeter: ${rectangle1.calculatePerimeter()}\n"
                    outcome+= "Rectangle area: ${rectangle1.calculateArea()}"
                    numbers=1
                    showInput=false
                }

                side1=""
                side2=""

            },
            modifier = Modifier.padding(10.dp)
        ) {
            Text(text = "Add Figure")
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
                navController.navigate("ogueta-project142")
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
                navController.navigate("ogueta-project145")
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

interface Figure {
    fun calculateArea(): Int
    fun calculatePerimeter(): Int
    fun resultTitle(): String {
        return "Figure Data"
    }
}

class Square(val side: Int): Figure {

    override fun calculateArea(): Int {
        return side * side
    }

    override fun calculatePerimeter(): Int {
        return side * 4
    }
}

class Rectangle(val higherSide:Int, val lowerSide: Int): Figure {

    override fun calculateArea(): Int {
        return higherSide * lowerSide
    }

    override fun calculatePerimeter(): Int {
        return (higherSide * 2) + (lowerSide * 2)
    }
}



