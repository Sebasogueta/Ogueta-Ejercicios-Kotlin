package com.example.ogueta_ejercicios

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
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

@Composable

fun Project189(navController: NavController) {
    Column(modifier = Modifier.padding(20.dp)) {
        Text(
            text = "Project 189: Bingo",
            textAlign = TextAlign.Center,
            color = Color.Green,
            fontWeight = FontWeight.Bold
        )
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {

        val bingoCard by remember { mutableStateOf(mutableSetOf<Int>()) }
        val bingoCage by remember { mutableStateOf(mutableSetOf<Int>()) }
        var outcome by remember { mutableStateOf("") }

        Button(
            onClick = {
                bingoCard.clear()
                bingoCage.clear()
                outcome=""
                generateCard(bingoCard)
                outcome+="Bingo card generated\n"
                outcome+=(bingoCard)

                generateCage(bingoCage)
                outcome+="\nBingo cage numbers:\n"
                outcome+="$bingoCage\n"
                outcome+=checkWin(bingoCard, bingoCage)


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
                navController.navigate("ogueta-project186")
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
                navController.navigate("ogueta-project191")
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
fun generateCard(card: MutableSet<Int>) {
    do {
        val value = ((Math.random() * 50) + 1).toInt()
        card.add(value)

    } while (card.size!=6)
}

fun generateCage(cage: MutableSet<Int>) {
    do {
        val value = ((Math.random() * 50) + 1).toInt()
        cage.add(value)
    } while (cage.size!=50)
}

fun checkWin(card: MutableSet<Int>, cage: MutableSet<Int>): String {
    var hits = 0
    var cantBalls = 0
    var tries = 0
    for(ball in cage) {
        cantBalls++
        if (ball in card) {
            hits++
            if (hits == 6) {
                tries = cantBalls
                break
            }
        }
    }
    return "$tries balls were drawn until the bingo card won.\n"
}
