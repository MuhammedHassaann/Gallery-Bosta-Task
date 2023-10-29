package com.muhammedhassaan.gallerytask.presentation.navgraph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun MainNavGraph(
    navController: NavHostController = rememberNavController(),
    startDestination: String = Screens.Splash.route
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ){
        composable(route = Screens.Splash.route){

        }
        composable(route = Screens.Home.route){

        }
        composable(
            route = Screens.Album.route,
            arguments = listOf(navArgument("albumId"){
                type = NavType.StringType
            })
        ){

        }
        composable(
            route = Screens.Photo.route,
            arguments = listOf(navArgument("photoUrl"){
                type = NavType.StringType
            })
        ){

        }
    }
}