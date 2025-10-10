package org.example.drangonball.core.navigation

import androidx.compose.runtime.Composable

import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import org.example.drangonball.ui.detail.DetailScreen
import org.example.drangonball.ui.home.HomeScreen

@Composable
fun NavigationNavWrapper(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Home){
        composable<Home>{
            HomeScreen(navigateToDetail = { id ->
                navController.navigate(Detail(id))
            })
        }
        composable<Detail> { navBackStackEntry->
            val detail : Detail = navBackStackEntry.toRoute<Detail>()
            DetailScreen(id= detail.id, navigateBack = {
                navController.popBackStack()
            })
        }
    }
}