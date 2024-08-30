package com.example.wishlist

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable


@Composable
fun Navigation(modifier: Modifier = Modifier,navController: NavHostController = rememberNavController() , viewModel: WishViewModel = viewModel()){

    NavHost(navController = navController, startDestination = Screen.HomeScreen.route){
        composable(Screen.HomeScreen.route){
            HomeView(modifier = modifier, navController, viewModel)
        }
        composable(Screen.AddScreen.route){
            addEditViewDetailView(id = 0L, viewModel = viewModel, navController = navController)
        }
    }
}