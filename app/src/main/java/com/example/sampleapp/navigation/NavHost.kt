@file:Suppress("PLUGIN_IS_NOT_ENABLED")

package com.example.sampleapp.navigation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.sampleapp.feature.ui.DishDetailScreen
import com.example.sampleapp.feature.ui.HomeScreen
import com.example.sampleapp.feature.ui.PaymentScreen
import kotlinx.serialization.Serializable

@Composable
fun NavGraph(modifier: Modifier = Modifier,controller: NavHostController) {
    NavHost(navController = controller, startDestination = SplashScreenRoute) {
        composable<SplashScreenRoute>{
            HomeScreen(navController = controller)
        }
        composable<HomeScreenRoute> {
            HomeScreen(navController = controller)
        }
        composable<FoodDetailScreenRoute>{
            DishDetailScreen(navController = controller)
        }

        composable<CartScreenRoute>{
            PaymentScreen(navController = controller)
        }

    }
}

@Serializable
object SplashScreenRoute

@Serializable
object HomeScreenRoute

@Serializable
object CartScreenRoute

@Serializable
object FoodDetailScreenRoute