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
import androidx.compose.ui.res.integerArrayResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable

fun Project142(navController: NavController) {
    Column(modifier = Modifier.padding(20.dp)) {
        Text(
            text = "Project 142: Introduce 2 points (X,Y and X,Y,Z).",
            textAlign = TextAlign.Center,
            color = Color.Green,
            fontWeight = FontWeight.Bold
        )
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {

        var pointX by remember { mutableStateOf("") }
        var pointY by remember { mutableStateOf("") }
        var pointZ by remember { mutableStateOf("") }
        var numbers by remember { mutableStateOf(1) }
        var outcome by remember { mutableStateOf("") }
        var showInput by remember { mutableStateOf(false) }


        OutlinedTextField(
            value = pointX,
            onValueChange = { pointX = it },
            label = {
                Text("Point $numbers: X:")
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
                Text("Point $numbers: Y:")
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            singleLine = true
        )

        OutlinedTextField(
            value = pointZ,
            onValueChange = { pointZ = it },
            label = {
                Text("Point $numbers: Z:")
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
                    val pointPlane1 = PointPlane(pointX.toInt(),pointY.toInt())
                    numbers++
                    outcome= pointPlane1.show()
                    showInput=true
                }
                else if(numbers ==2){
                    val pointSpace1 = PointSpace(pointX.toInt(),pointY.toInt(),pointZ.toInt())
                    outcome= pointSpace1.show()
                    numbers=1
                    showInput=false
                }

                pointX=""
                pointY=""
                pointZ=""
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
                navController.navigate("ogueta-project141")
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
                navController.navigate("ogueta-project143")
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

interface Point2 {
    fun show(): String
}
class PointPlane(val x: Int, val y: Int): Point2 {
    override fun show(): String {
        return "Point in the plane: ($x,$y)\n"
    }

}
class PointSpace(val x: Int, val y: Int, val z: Int): Point2 {
    override fun show(): String {
        return "Point in the space: ($x,$y,$z)\n"
    }
}


