package com.example.sampleapp.core

import com.example.sampleapp.navigation.AppRoute

class AppUtil {

    companion object {
        private val mainRootRoutePath="com.example.sampleapp.navigation"

        fun getBottomRoutes(route:String?):AppRoute?{
            return when(route){
                "${mainRootRoutePath}.AppRoute.HomeScreenRoute"->AppRoute.HomeScreenRoute
                "${mainRootRoutePath}.AppRoute.SearchRoute"->AppRoute.SearchRoute
                "${mainRootRoutePath}.AppRoute.RestaurantRoute"->AppRoute.RestaurantRoute
                "${mainRootRoutePath}.AppRoute.ProfileRoute"->AppRoute.ProfileRoute
                else->null
            }
        }
    }



}