package com.example.ogueta_ejercicios

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun MainMenu(navController: NavController) {
    Column(modifier = Modifier.padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(text = "Main Menu",textAlign = TextAlign.Center,color= Color.Green,
            fontWeight = FontWeight.Bold)

        Row(modifier = Modifier
            .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center) {
            Button(
                onClick = {
                    navController.navigate("ogueta-project5")
                },
                modifier = Modifier.padding(10.dp)
            ) {
                Text(text = "Project 5")
            }
            Button(
                onClick = {
                    navController.navigate("ogueta-project15")
                },
                modifier = Modifier.padding(10.dp)
            ) {
                Text(text = "Project 15")
            }

        }

        Row(modifier = Modifier
            .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center) {
            Button(
                onClick = {
                    navController.navigate("ogueta-project25")
                },
                modifier = Modifier.padding(10.dp)
            ) {
                Text(text = "Project 25")
            }
            Button(
                onClick = {
                    navController.navigate("ogueta-project35")
                },
                modifier = Modifier.padding(10.dp)
            ) {
                Text(text = "Project 35")
            }
        }

        Row(modifier = Modifier
            .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center) {
            Button(
                onClick = {
                    navController.navigate("ogueta-project45")
                },
                modifier = Modifier.padding(10.dp)
            ) {
                Text(text = "Project 45")
            }
            Button(
                onClick = {
                    navController.navigate("ogueta-project55")
                },
                modifier = Modifier.padding(10.dp)
            ) {
                Text(text = "Project 55")
            }
        }

        Row(modifier = Modifier
            .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center) {
            Button(
                onClick = {
                    navController.navigate("ogueta-project65")
                },
                modifier = Modifier.padding(10.dp)
            ) {
                Text(text = "Project 65")
            }
            Button(
                onClick = {
                    navController.navigate("ogueta-project77")
                },
                modifier = Modifier.padding(10.dp)
            ) {
                Text(text = "Project 77")
            }
        }

        Row(modifier = Modifier
            .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center) {
            Button(
                onClick = {
                    navController.navigate("ogueta-project93")
                },
                modifier = Modifier.padding(10.dp)
            ) {
                Text(text = "Project 93")
            }
            Button(
                onClick = {
                    navController.navigate("ogueta-project111")
                },
                modifier = Modifier.padding(10.dp)
            ) {
                Text(text = "Project 111")
            }
        }

        Row(modifier = Modifier
            .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center) {
            Button(
                onClick = {
                    navController.navigate("ogueta-project130")
                },
                modifier = Modifier.padding(10.dp)
            ) {
                Text(text = "Project 130")
            }
            Button(
                onClick = {
                    navController.navigate("ogueta-project151")
                },
                modifier = Modifier.padding(10.dp)
            ) {
                Text(text = "Project 151")
            }
        }

        Row(modifier = Modifier
            .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center) {
            Button(
                onClick = {
                    navController.navigate("ogueta-project168")
                },
                modifier = Modifier.padding(10.dp)
            ) {
                Text(text = "Project 168")
            }
            Button(
                onClick = {
                    navController.navigate("ogueta-project186")
                },
                modifier = Modifier.padding(10.dp)
            ) {
                Text(text = "Project 186")
            }
        }



    }
}

