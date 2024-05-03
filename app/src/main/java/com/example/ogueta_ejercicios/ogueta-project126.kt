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

fun Project126(navController: NavController) {
    Column(modifier = Modifier.padding(20.dp)) {
        Text(
            text = "Project 126: Introduce the name and the salary of 2 employees.",
            textAlign = TextAlign.Center,
            color = Color.Green,
            fontWeight = FontWeight.Bold
        )
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {

        val employeeList = remember { mutableListOf<Employee>() }
        var employeeName by remember { mutableStateOf("") }
        var employeeSalary by remember { mutableStateOf("") }
        var numbers by remember { mutableStateOf(1) }
        var outcome by remember { mutableStateOf("") }


        OutlinedTextField(
            value = employeeName,
            onValueChange = { employeeName = it },
            label = {
                Text("Employee $numbers: Name:")
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            singleLine = true,
        )

        OutlinedTextField(
            value = employeeSalary,
            onValueChange = { employeeSalary = it },
            label = {
                Text("Employee $numbers: Salary")
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            singleLine = true
        )

        Button(
            onClick = {
                outcome=""
                if(numbers <=2){
                    val newEmployee = Employee(employeeName, employeeSalary.toDouble())
                    employeeList.add(newEmployee)
                    numbers++
                }

                if(numbers > 2){
                    for(e in employeeList){
                        outcome+= "${e.showEmployee()} \n"
                    }
                    employeeList.clear()
                    numbers=1
                }

                employeeName=""
                employeeSalary=""
            },
            modifier = Modifier.padding(10.dp)
        ) {
            Text(text = "Add Employee")
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
                navController.navigate("ogueta-project124")
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
                navController.navigate("ogueta-project127")
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

class Employee(var name: String, salary: Double) {
    var salary: Double = 0.0
        set(value) {
            if (value < 0)
                field = 0.0
            else
                field = value
        }
    init {
        this.salary = salary
    }
    fun showEmployee(): String {
        return "$name has a salary of $salary"
    }
}