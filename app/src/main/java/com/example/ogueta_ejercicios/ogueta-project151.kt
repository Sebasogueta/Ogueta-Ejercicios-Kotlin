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

fun Project151(navController: NavController) {
    Column(modifier = Modifier.padding(20.dp)) {
        Text(
            text = "Project 151: Insert a sentence",
            textAlign = TextAlign.Center,
            color = Color.Green,
            fontWeight = FontWeight.Bold
        )
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {

        var inputString by remember { mutableStateOf("") }
        var outcome by remember { mutableStateOf("") }


        OutlinedTextField(
            value = inputString,
            onValueChange = { inputString = it },
            label = {
                Text("A sentence:")
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            singleLine = true,
        )

        Button(
            onClick = {
                outcome="Original String:\n"
                outcome+="$inputString\n"

                val result1 = filter(inputString) {
                    it == 'a' || it == 'e' || it == 'i' || it == 'o' || it == 'u' ||
                        it == 'A' || it == 'E' || it == 'I' || it == 'O' || it == 'U'
                }
                outcome+="\nOnly vowels\n"
                outcome+="$result1\n"

                var result2 = filter(inputString) {
                    it in 'a'..'z'
                }
                outcome+="\nOnly lowercase characters\n"
                outcome+="$result2\n"

                var result3 = filter(inputString) {
                    it !in 'a'..'z' && it !in 'A'..'Z'
                }
                outcome+="\nOnly non-alphabetic characters\n"
                outcome+="$result3\n"
                inputString=""
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
                navController.navigate("ogueta-project149")
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
                navController.navigate("ogueta-project153")
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

fun filter(string: String, fn: (Char) -> Boolean): String
{
    val str = StringBuilder()
    for(ele in string)
        if (fn(ele))
            str.append(ele)
    return str.toString()

}


