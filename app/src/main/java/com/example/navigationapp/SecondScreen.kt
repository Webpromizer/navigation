package com.example.navigationapp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SecondScreen(name: String, age: String, navigationToFirstScreen:(String)->Unit, navigationToThirdScreen:()->Unit){
    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {
        Text(
            text = "Welcome! ${name}. You are ${age} years old ",
            fontSize = 24.sp)
        Spacer(modifier = Modifier.height(10.dp))
        Row(modifier = Modifier.padding(end = 10.dp)) {
            Button(
                onClick = {
                    navigationToFirstScreen(name)
                    navigationToFirstScreen(age)
                }
            ) {
                Text(text = "Go to the FirstScreen")
            }
            Button(
                onClick ={
                    navigationToThirdScreen()
                }
            ) {
                Text(text = "Go to the ThirdScreen")
            }
        }

    }
}



