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
import androidx.compose.runtime.MutableState
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

fun Project127(navController: NavController) {
    Column(modifier = Modifier.padding(20.dp)) {
        Text(
            text = "Project 127: Introduce the value of the dice.",
            textAlign = TextAlign.Center,
            color = Color.Green,
            fontWeight = FontWeight.Bold
        )
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {

        var diceNum by remember { mutableStateOf("") }
        var outcome by remember { mutableStateOf("") }


        OutlinedTextField(
            value = diceNum,
            onValueChange = { diceNum = it },
            label = {
                Text("Enter Dice num:")
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            singleLine = true,
        )

        Button(
            onClick = {
                outcome = ""
                val dice = Dice(diceNum.toInt())
                outcome += dice.showDice()
                dice.throwDice()
                outcome += "Dice thrown: " + dice.showDice()

                diceNum = ""
            },

            modifier = Modifier.padding(10.dp)
        ) {
            Text(text = "Run")
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
                navController.navigate("ogueta-project126")
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
                navController.navigate("ogueta-project130")
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

class Dice(valor: Int){

    var value: Int = 1
        private set

    init {
        if (valor in 1..6) {
            this.value = valor
        }
    }

    fun throwDice() {

        value = ((Math.random() * 6) + 1).toInt()
    }
    fun showDice(): String{return "Dice value: $value\n"}
}
