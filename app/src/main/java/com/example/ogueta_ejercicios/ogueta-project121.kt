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

fun Project121(navController: NavController) {
    Column(modifier = Modifier.padding(20.dp)) {
        Text(
            text = "Project 121: Enter the name and seniority of 3 members of a club",
            textAlign = TextAlign.Center,
            color = Color.Green,
            fontWeight = FontWeight.Bold
        )
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {

        val memberList = remember { mutableListOf<Member>() }
        var memberName by remember { mutableStateOf("") }
        var memberSeniority by remember { mutableStateOf("") }
        val club = remember { Club() }
        var numbers by remember { mutableStateOf(1) }
        var outcome by remember { mutableStateOf("") }


        OutlinedTextField(
            value = memberName,
            onValueChange = { memberName = it },
            label = {
                Text("Member $numbers: Name: ")
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            singleLine = true,
        )

        OutlinedTextField(
            value = memberSeniority,
            onValueChange = { memberSeniority = it },
            label = {
                Text("Member $numbers: Seniority: ")
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            singleLine = true
        )

        Button(
            onClick = {
                outcome=""
                if(numbers <=3){
                    memberList.add(Member(memberName, memberSeniority.toInt()))
                    numbers++
                }
                if(numbers > 3){
                    club.addMembers(memberList)
                    outcome=club.highestSeniority()

                    memberList.clear()
                    club.clearMembers()
                    numbers=1
                }

                memberName=""
                memberSeniority=""
            },
            modifier = Modifier.padding(10.dp)
        ) {
            Text(text = "Add Member")
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
                navController.navigate("ogueta-project118")
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
                navController.navigate("ogueta-project124")
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

class Member(val name: String, val seniority: Int) {

    fun showMember(): String {
        return "$name has a seniority of $seniority"
    }
}

class Club {

    val members: MutableList<Member> = mutableListOf()

    fun addMembers(newMembers: MutableList<Member>) {
        members.addAll(newMembers)
    }

    fun clearMembers() {
        members.clear()
    }


    fun highestSeniority(): String {
        var text= ""
        for (member in members) {
            text+=member.showMember()+"\n"
        }
        text+="Member with the highest seniority: "
        var memberHighestSeniority = members[0]
        for (i in 1 until members.size) {
            if (members[i].seniority > memberHighestSeniority.seniority) {
                memberHighestSeniority = members[i]
            }
        }
        text+="${memberHighestSeniority.name}"
        return text
    }
}



