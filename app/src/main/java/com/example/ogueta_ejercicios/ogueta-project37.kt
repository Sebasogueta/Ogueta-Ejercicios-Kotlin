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
fun Project37(navController: NavController) {
    Column(modifier = Modifier.padding(20.dp)) {
        Text(
            text = "Project 37: Enter the amount of employees and the salary of each one (between $100 and $500)", textAlign = TextAlign.Center, color = Color.Green,
            fontWeight = FontWeight.Bold
        )
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {

        var employees by remember { mutableStateOf("") }
        var salary by remember { mutableStateOf("") }
        var outcome by remember { mutableStateOf("") }
        var number by remember { mutableStateOf(1) }
        var sumSalary by remember { mutableStateOf(0) }
        var salaryLower300 by remember { mutableStateOf(0) }
        var salaryHigher300 by remember { mutableStateOf(0) }
        var isInputEnabled by remember { mutableStateOf(true) }



        OutlinedTextField(
            value = employees,
            onValueChange = { employees = it },
            label = {
                Text("Number of employees")
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            singleLine = true,
            enabled = isInputEnabled
        )

        OutlinedTextField(
            value = salary,
            onValueChange = { salary = it },
            label = {
                Text("Salary of person $number (between $100 and $500")
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            singleLine = true
        )

        Button(
            onClick = {
                outcome=""
                isInputEnabled = false
                if(number<=employees.toInt()){
                    sumSalary+=salary.toInt()
                    if(salary.toInt()>300){
                        salaryHigher300+=1
                    }
                    else{
                        salaryLower300+=1
                    }
                    salary = ""
                }
                number+=1
                if(number>employees.toInt()){

                    outcome= "Employees with a salary between $100 and $300: $salaryLower300 \nEmployees with a salary higher than $300: $salaryHigher300 \nThe company spends $$sumSalary in salaries."
                    number=1
                    sumSalary=0
                    salaryHigher300=0
                    salaryLower300=0
                    isInputEnabled = true

                }

            },
            modifier = Modifier.padding(10.dp)
        ) {
            Text(text = "Enter")
        }

        Text(
            text = outcome,
            modifier = Modifier.padding(10.dp)
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Button(
                onClick = {
                    navController.navigate("ogueta-project36")
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
                    navController.navigate("ogueta-project38")
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
}



