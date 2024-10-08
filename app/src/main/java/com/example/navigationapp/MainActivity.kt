package com.example.navigationapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.navigationapp.ui.theme.NavigationAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NavigationAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(modifier = Modifier.padding(innerPadding)) {
                        MyApp()
                    }
                }
            }
        }
    }
}

@Composable
fun MyApp() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "firstscreen") {
        composable(route = "firstscreen") {
            FirstScreen { name, age ->
                navController.navigate("secondscreen/$name/$age")
            }
        }

        composable(route = "secondscreen/{name}/{age}") { backStackEntry ->
            val name = backStackEntry.arguments?.getString("name") ?: "no name"
            val age = backStackEntry.arguments?.getString("age")?.toIntOrNull() ?: 20

            SecondScreen(
                name = name,
                age = age,
                navigationToFirstScreen = { navController.navigate("firstscreen") },
                navigationToThirdScreen = { navController.navigate("thirdscreen/$name/$age") }
            )
        }

        composable(route = "thirdscreen/{name}/{age}") { backStackEntry ->
            val name = backStackEntry.arguments?.getString("name") ?: "no name"
            val age = backStackEntry.arguments?.getString("age")?.toIntOrNull() ?: 20

            ThirdScreen(
                navigationToSecondScreen = { navController.navigate("secondscreen/$name/${age.toString()}") }
            )
        }
    }
}
