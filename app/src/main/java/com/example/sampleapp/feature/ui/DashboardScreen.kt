package com.example.sampleapp.feature.ui

import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.sampleapp.feature.components.common.BottomAppBar
import com.example.sampleapp.navigation.HomeNavGraph

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun DashboardScreen(modifier: Modifier = Modifier,mainController: NavHostController) {

    val homeController = rememberNavController()

    Scaffold(bottomBar = {
        BottomAppBar(onIconTap = {item->
            homeController.navigate(item.route){
                popUpTo(homeController.graph.startDestinationId) {
                    saveState=true
                }
                launchSingleTop=true
                restoreState=true
            }
        }, navController =homeController)
    }) { HomeNavGraph(homeController = homeController, mainNavController = mainController) }
}