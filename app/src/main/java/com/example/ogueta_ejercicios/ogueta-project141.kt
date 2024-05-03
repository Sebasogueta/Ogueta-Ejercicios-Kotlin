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

fun Project141(navController: NavController) {
    Column(modifier = Modifier.padding(20.dp)) {
        Text(
            text = "Project 141: Introduce a name and a balance twice.",
            textAlign = TextAlign.Center,
            color = Color.Green,
            fontWeight = FontWeight.Bold
        )
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {

        var accountOwner by remember { mutableStateOf("") }
        var accountBalance by remember { mutableStateOf("") }
        var term by remember { mutableStateOf("") }
        var interest by remember { mutableStateOf("") }
        var numbers by remember { mutableStateOf(1) }
        var outcome by remember { mutableStateOf("") }
        var showInput by remember { mutableStateOf(false) }


        OutlinedTextField(
            value = accountOwner,
            onValueChange = { accountOwner = it },
            label = {
                Text("Account $numbers: Owner name:")
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            singleLine = true,
        )

        OutlinedTextField(
            value = accountBalance,
            onValueChange = { accountBalance = it },
            label = {
                Text("Account $numbers: Balance")
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            singleLine = true
        )

        OutlinedTextField(
            value = term,
            onValueChange = { term = it },
            label = {
                Text("Term: ")
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            singleLine = true,
            enabled = showInput
        )

        OutlinedTextField(
            value = interest,
            onValueChange = { interest = it },
            label = {
                Text("Interest: ")
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
                    val savingsAccount = SavingsAccount(accountOwner, accountBalance.toDouble())
                    numbers++
                    outcome= savingsAccount.show()
                    showInput=true
                }
                else if(numbers ==2){
                    val fixedTermDeposit = FixedTermDeposit(accountOwner, accountBalance.toDouble(), term.toInt(), interest.toDouble())
                    numbers++
                    outcome= fixedTermDeposit.show()
                    showInput=false
                    term=""
                    interest=""
                }

                if(numbers > 2){
                    numbers=1
                }

                accountOwner=""
                accountBalance=""
            },
            modifier = Modifier.padding(10.dp)
        ) {
            Text(text = "Add Account")
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
                navController.navigate("ogueta-project139")
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
                navController.navigate("ogueta-project142")
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

abstract class Account(val owner: String, val balance: Double) {
    open fun show():String {
        var text = "Account owner: $owner\n"
        text+= "Balance: $balance\n"
        return text
    }
}
class SavingsAccount(owner: String, balance: Double): Account(owner, balance) {
    override fun show(): String {
        var text = "Savings Account\n"
        text+= super.show()+"\n"
        return text
    }
}

class FixedTermDeposit(owner: String, balance: Double, val term: Int, val interest: Double): Account(owner,
    balance) {
    override fun show(): String {
        var text = "Fixed Term Deposit Account\n"
        text+= "Term in days: $term\n"
        text+= "Interest: $interest\n"
        val earning = balance * interest / 100
        text+= "Interest Amount: $earning\n"
        text+= super.show()
        return text
    }
}
