package com.muhammedhassaan.gallerytask.presentation.navgraph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.muhammedhassaan.gallerytask.presentation.screens.album.AlbumScreen
import com.muhammedhassaan.gallerytask.presentation.screens.home.HomeScreen
import com.muhammedhassaan.gallerytask.presentation.screens.photo.PhotoScreen
import com.muhammedhassaan.gallerytask.presentation.screens.splash.AnimatedSplashScreen

@Composable
fun MainNavGraph(
    navController: NavHostController = rememberNavController(),
    startDestination: String = Screens.Splash.route
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(route = Screens.Splash.route) {
            AnimatedSplashScreen {
                navController.popBackStack()
                navController.navigate(Screens.Home.route)
            }
        }
        composable(route = Screens.Home.route) {
            HomeScreen { albumId, albumName ->
                navController.navigate(Screens.Album.passAlbumIdAndName(albumId, albumName))
            }
        }
        composable(
            route = Screens.Album.route,
            arguments = listOf(
                navArgument("albumId") {
                    type = NavType.StringType
                }, navArgument("albumName") {
                    type = NavType.StringType
                }
            )
        ) {
            AlbumScreen(
                onPhotoClick = { photoUrl ->
                    navController.navigate(Screens.Photo.passPhotoUrl(photoUrl))
                }
            )
        }
        composable(
            route = Screens.Photo.route,
            arguments = listOf(navArgument("photoUrl") {
                type = NavType.StringType
            })
        ) {backStackEntry->
            PhotoScreen()
        }
    }
}