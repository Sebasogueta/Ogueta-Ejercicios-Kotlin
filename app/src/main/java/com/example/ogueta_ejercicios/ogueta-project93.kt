package com.example.ogueta_ejercicios

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun Project93(navController: NavController) {
    presentation(navController)

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun presentation(navController: NavController) {
    Column(modifier = Modifier.padding(20.dp)) {
        Text(
            text = "Project 93: Introduce 2 to 4 numbers",
            textAlign = TextAlign.Center,
            color = Color.Green,
            fontWeight = FontWeight.Bold
        )
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {

        var num1 by remember { mutableStateOf("") }
        var num2 by remember { mutableStateOf("") }
        var num3 by remember { mutableStateOf("") }
        var num4 by remember { mutableStateOf("") }

        var outcome by remember { mutableStateOf("") }


        OutlinedTextField(
            value = num1,
            onValueChange = { num1 = it },
            label = {
                Text("Number 1")
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            singleLine = true
        )

        OutlinedTextField(
            value = num2,
            onValueChange = { num2 = it },
            label = {
                Text("Number 2")
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            singleLine = true
        )

        OutlinedTextField(
            value = num3,
            onValueChange = { num3 = it },
            label = {
                Text("Number 3")
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            singleLine = true
        )
        OutlinedTextField(
            value = num4,
            onValueChange = { num4 = it },
            label = {
                Text("Number 4")
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            singleLine = true
        )

        Button(
            onClick = {

                var nums =0
                var n1 = 0
                var n2 = 0
                var n3 = 0
                var n4 = 0


                if(num1 != ""){
                    n1 = num1.toInt()
                    nums++
                }
                if(num2 != ""){
                    n2 = num2.toInt()
                    nums++
                }
                if(num3 != ""){
                    n3 = num3.toInt()
                    nums++
                }
                if(num4 != ""){
                    n4 = num4.toInt()
                    nums++
                }

                if(nums == 2) {
                    outcome = "The sum of $n1 + $n2 is: ${sumNums(n1, n2)}\n" +
                            "The sum of $n1 + $n2 + $n3 is: ${sumNums(n1, n2)}\n" +
                            "The sum of $n1 + $n2 + $n3 + $num4 is: ${sumNums(n1, n2)}"
                }
                if(nums == 3) {
                    outcome = "The sum of $n1 + $n2 is: ${sumNums(n1, n2)}\n" +
                            "The sum of $n1 + $n2 + $n3 is: ${sumNums(n1, n2, n3)}\n" +
                            "The sum of $n1 + $n2 + $n3 + $num4 is: ${sumNums(n1, n2, n3)}"
                }
                if(nums == 4) {
                    outcome = "The sum of $n1 + $n2 is: ${sumNums(n1, n2)}\n" +
                            "The sum of $n1 + $n2 + $n3 is: ${sumNums(n1, n2, n3)}\n" +
                            "The sum of $n1 + $n2 + $n3 + $num4 is: ${sumNums(n1, n2, n3, n4)}"
                }

                num1 = ""
                num2 = ""
                num3 = ""
                num4 = ""
            },
            modifier = Modifier.padding(10.dp)
        ) {
            Text(text = "Check")
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
                navController.navigate("ogueta-project91")
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
                navController.navigate("ogueta-project95")
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


fun sumNums(v1: Int, v2: Int, v3: Int = 0, v4: Int = 0, v5: Int = 0) = v1 + v2 + v3 + v4 + v5




