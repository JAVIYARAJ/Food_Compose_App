package com.example.sampleapp.feature.components.common

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.sampleapp.R
import com.example.sampleapp.navigation.AppRoute

sealed class BottomAppBarItem(val route: AppRoute, val icon: Int, val label: String) {
    data object Home : BottomAppBarItem(route = AppRoute.HomeScreenRoute, icon = R.drawable.ic_home_icon, label = "Home")
    data object Search : BottomAppBarItem(route = AppRoute.SearchRoute, icon = R.drawable.ic_search_menu_icon, label = "Search")
    data object Restaurant : BottomAppBarItem(route = AppRoute.RestaurantRoute, icon = R.drawable.ic_restaurant_icon, label = "Restaurant")
    data object Profile : BottomAppBarItem(route = AppRoute.ProfileRoute, icon = R.drawable.ic_profile_icon, label = "Profile")
}

@Composable
fun BottomAppBar(modifier: Modifier = Modifier, onIconTap: (BottomAppBarItem) -> Unit,navController: NavController) {

    val bottomItems = listOf(BottomAppBarItem.Home, BottomAppBarItem.Search, BottomAppBarItem.Restaurant,BottomAppBarItem.Profile)

    /*val systemBars = WindowInsets.systemBars
    val bottomPadding = systemBars.asPaddingValues().calculateBottomPadding()*/

    val backStack by navController.currentBackStackEntryAsState()
    val currentRoute=backStack?.destination?.route

    NavigationBar(
        containerColor = Color.White,
        modifier = modifier.clip(RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp))
    ) {
        bottomItems.forEach { item ->
            NavigationBarItem(
                selected = false,
                onClick = {
                    onIconTap.invoke(item)
                },
                icon = { Image(painter = painterResource(id = item.icon), contentDescription = "", modifier = Modifier
                    .size(25.dp)
                    .clip(
                        RoundedCornerShape(50.dp)
                    )) },
                label = { Text(text = item.label) },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color.Transparent,
                    selectedTextColor = Color.Black,
                    unselectedTextColor = Color.Gray,
                    unselectedIconColor = Color.Transparent,
                    indicatorColor = Color.Transparent,
                ),
                modifier = Modifier.clip(RoundedCornerShape(20.dp))
            )
        }
    }
}