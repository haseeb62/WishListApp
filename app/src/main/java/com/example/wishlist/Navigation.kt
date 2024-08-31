package com.example.wishlist

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument


@Composable
fun Navigation(modifier: Modifier = Modifier,navController: NavHostController = rememberNavController() , viewModel: WishViewModel = viewModel()){

    NavHost(navController = navController, startDestination = Screen.HomeScreen.route){
        composable(Screen.HomeScreen.route){
            HomeView(modifier = modifier, navController, viewModel)
        }
        composable(Screen.AddScreen.route + "/{id}", arguments = listOf(navArgument("id"){
            type = NavType.LongType
            defaultValue = 0L
            nullable = false
        })){
            val id = if(it.arguments != null) it.arguments!!.getLong("id") else 0L
            addEditViewDetailView(id = id, viewModel = viewModel, navController = navController)
        }
    }
}