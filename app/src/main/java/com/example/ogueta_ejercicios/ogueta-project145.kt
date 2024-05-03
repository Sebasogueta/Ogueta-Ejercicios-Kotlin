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

fun Project145(navController: NavController) {
    Column(modifier = Modifier.padding(20.dp)) {
        Text(
            text = "Project 145: Insert 3 articles",
            textAlign = TextAlign.Center,
            color = Color.Green,
            fontWeight = FontWeight.Bold
        )
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {

        var articlesList by remember { mutableStateOf(mutableListOf<Article>()) }
        var code by remember { mutableStateOf("") }
        var desc by remember { mutableStateOf("") }
        var price by remember { mutableStateOf("") }
        var numbers by remember { mutableStateOf(1) }
        var outcome by remember { mutableStateOf("") }


        OutlinedTextField(
            value = code,
            onValueChange = { code = it },
            label = {
                Text("Article $numbers: Code:")
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            singleLine = true,
        )

        OutlinedTextField(
            value = desc,
            onValueChange = { desc = it },
            label = {
                Text("Article $numbers: Description: ")
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            singleLine = true
        )

        OutlinedTextField(
            value = price,
            onValueChange = { price = it },
            label = {
                Text("Article $numbers: Price: ")
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            singleLine = true
        )


        Button(
            onClick = {
                outcome=""
                if(numbers <= 3){
                    articlesList.add(Article(code.toInt(), desc, price.toFloat()))
                    numbers++
                }
                if(numbers >3){
                    val articlesArray = Array<Article>(3) { Article (0, "", 0f)}
                    for(i in 0 until articlesList.size){
                        articlesArray[i] = articlesList[i]
                    }
                    outcome="Actual prices list: \n"
                    outcome+="${show(articlesArray)}\n"
                    increasePrice(articlesArray)
                    outcome+="\nPrice list with an increase of 10%\n"
                    outcome+="${show(articlesArray)}\n"
                    numbers=1
                }

                code=""
                desc=""
                price=""

            },
            modifier = Modifier.padding(10.dp)
        ) {
            Text(text = "Add Article")
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
                navController.navigate("ogueta-project143")
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
                navController.navigate("ogueta-project146")
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

data class Article(val code: Int, val description: String, var price: Float)

    fun show(articles: Array<Article>): String {
        val stringBuilder = StringBuilder()
        for (article in articles)
            stringBuilder.append("Code: ${article.code} - Description: ${article.description} Price: ${article.price}\n")
        return stringBuilder.toString()
    }

    fun increasePrice(articles: Array<Article>) {
        for (article in articles) {
            val newPrice = article.price + (article.price * 0.10f)
            article.price = newPrice
        }

    }



