@file:Suppress("PLUGIN_IS_NOT_ENABLED")

package com.example.sampleapp.navigation

import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalFocusManager
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.sampleapp.feature.ui.DashboardScreen
import com.example.sampleapp.feature.ui.DishDetailScreen
import com.example.sampleapp.feature.ui.HomeScreen
import com.example.sampleapp.feature.ui.PaymentScreen
import com.example.sampleapp.feature.ui.ProfileScreen
import com.example.sampleapp.feature.ui.RestaurantScreen
import com.example.sampleapp.feature.ui.SearchScreen
import com.example.sampleapp.feature.ui.WelcomeScreen
import kotlinx.serialization.Serializable

@Composable
fun MainNavGraph(modifier: Modifier = Modifier, controller: NavHostController) {

    /*pointerInput for telling device where i perform something touch event*/
    /*detectTapGestures for telling device when i perform something*/
    val focusManager= LocalFocusManager.current

    NavHost(navController = controller, startDestination = AppRoute.WelcomeScreenRoute, modifier = Modifier.pointerInput(key1 = Unit){
        detectTapGestures(onTap = {
            focusManager.clearFocus()
        })
    }) {

        composable<AppRoute.WelcomeScreenRoute> {
            WelcomeScreen(navController = controller)

        }

        composable<AppRoute.DashboardRoute> {
            DashboardScreen(mainController = controller)
        }
        composable<AppRoute.FoodDetailScreenRoute> {
            DishDetailScreen(navController = controller)
        }

        composable<AppRoute.CartScreenRoute> {
            PaymentScreen(navController = controller)
        }
    }
}

@Composable
fun HomeNavGraph(modifier: Modifier = Modifier, homeController: NavHostController, mainNavController: NavHostController) {
    NavHost(navController = homeController, startDestination = AppRoute.HomeScreenRoute) {
        composable<AppRoute.HomeScreenRoute> {
            HomeScreen(navController = mainNavController)
        }
        composable<AppRoute.SearchRoute> {
            SearchScreen()
        }
        composable<AppRoute.RestaurantRoute> {
            RestaurantScreen()
        }

        composable<AppRoute.ProfileRoute> {
            ProfileScreen()
        }
    }
}


sealed class AppRoute() {
    @Serializable
    data object SplashScreenRoute : AppRoute()

    @Serializable
    data object WelcomeScreenRoute : AppRoute()

    @Serializable
    data object DashboardRoute : AppRoute()

    @Serializable
    data object SearchRoute : AppRoute()

    @Serializable
    data object RestaurantRoute:AppRoute()

    @Serializable
    data object ProfileRoute:AppRoute()

    @Serializable
    data object HomeScreenRoute : AppRoute()

    @Serializable
    data object CartScreenRoute : AppRoute()
    @Serializable
    data object FoodDetailScreenRoute : AppRoute()

}
