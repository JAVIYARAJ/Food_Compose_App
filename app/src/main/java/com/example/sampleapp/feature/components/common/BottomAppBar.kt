package com.example.sampleapp.feature.components.common

import android.util.Log
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Restaurant
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.sampleapp.core.AppUtil
import com.example.sampleapp.navigation.AppRoute

sealed class BottomAppBarItem(val route: AppRoute, val icon: ImageVector, val label: String) {
    data object Home : BottomAppBarItem(route = AppRoute.HomeScreenRoute, icon = Icons.Default.Home, label = "Home")
    data object Search : BottomAppBarItem(route = AppRoute.SearchRoute, icon = Icons.Default.Search, label = "Search")
    data object Restaurant : BottomAppBarItem(route = AppRoute.RestaurantRoute, icon = Icons.Default.Restaurant, label = "Restaurant")
    data object Profile : BottomAppBarItem(route = AppRoute.ProfileRoute, icon = Icons.Default.Person, label = "Profile")
}

@Composable
fun BottomAppBar(modifier: Modifier = Modifier, onIconTap: (BottomAppBarItem) -> Unit, navController: NavController) {

    val bottomItems = listOf(BottomAppBarItem.Home, BottomAppBarItem.Search, BottomAppBarItem.Restaurant, BottomAppBarItem.Profile)

    /*this widget recompose when navigation happen or pop back happen*/
    val backStack by navController.currentBackStackEntryAsState()
    val currentRoute = backStack?.destination?.route

    NavigationBar(
        modifier = Modifier.clip(RoundedCornerShape(20.dp)),
        containerColor = Color.Black
    ) {
        bottomItems.forEach { item ->
            val isSelected=AppUtil.getBottomRoutes(currentRoute)==item.route
            NavigationBarItem(
                selected = isSelected,
                onClick = {
                    onIconTap.invoke(item)
                },
                icon = {
                    Icon(item.icon, contentDescription = "", tint = Color.White)
                },
                label = { Text(text = item.label, color = Color.White) },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color.Gray,
                    selectedTextColor = Color.White,
                    unselectedTextColor = Color.White,
                    unselectedIconColor = Color.White,
                    indicatorColor =if(isSelected) Color.Gray else Color.White,
                ),
                modifier = Modifier.clip(RoundedCornerShape(50.dp))
            )
        }
    }


}