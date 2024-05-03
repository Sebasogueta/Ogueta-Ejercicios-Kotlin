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
import kotlin.Array

@OptIn(ExperimentalMaterial3Api::class)
@Composable

fun Project146(navController: NavController) {
    Column(modifier = Modifier.padding(20.dp)) {
        Text(
            text = "Project 146: Throw 5 dices",
            textAlign = TextAlign.Center,
            color = Color.Green,
            fontWeight = FontWeight.Bold
        )
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {

        var outcome by remember { mutableStateOf("") }

        Button(
            onClick = {
                outcome=""
                var dices: Array<Dice4> = arrayOf(Dice4(), Dice4(), Dice4(), Dice4(), Dice4())
                var num=1
                for(dice in dices)
                    dice.throwDice()
                for(dice in dices) {
                    outcome += "$num : ${dice.print()}\n"
                    num++
                }

            },
            modifier = Modifier.padding(10.dp)
        ) {
            Text(text = "Run program")
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
                navController.navigate("ogueta-project145")
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
                navController.navigate("ogueta-project147")
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

class Dice4 (var value: Int = 1){
    fun throwDice() {
        value = ((Math.random() * 6) + 1).toInt()
    }
    fun print(): String {
        return "Dice value: $value"
    }
}



