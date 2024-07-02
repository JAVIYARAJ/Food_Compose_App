package com.example.sampleapp.feature.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.sampleapp.feature.components.common.LoadingWidget
import kotlinx.coroutines.delay

@Composable
fun RestaurantScreen(modifier: Modifier = Modifier) {

    val isLoading= remember {
        mutableStateOf(true)
    }

    LaunchedEffect(key1 = Unit) {
        delay(1000)
        isLoading.value=false
    }

    if(isLoading.value){
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
            if(isLoading.value){
            LoadingWidget()
            }else{
                Text(text = "Restaurant")
            }
        }
    }else {

    }
}