package com.example.sampleapp.feature.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.sampleapp.R
import com.example.sampleapp.feature.components.common.CustomizedTextField
import com.example.sampleapp.feature.components.common.MenuIcon
import com.example.sampleapp.navigation.AppRoute
import com.example.sampleapp.ui.theme.welcomeColor

@Composable
fun WelcomeScreen(modifier: Modifier = Modifier,navController: NavHostController) {
    Scaffold(
    ) { padding ->

        Column(
            modifier = Modifier
                .padding(padding)
                .background(color = welcomeColor)
                .then(Modifier.padding(horizontal = 20.dp))
                .fillMaxSize()
        ) {
            val welcomeTitle = buildAnnotatedString {
                withStyle(style = SpanStyle(color = Color.White, fontSize = 30.sp, fontFamily = FontFamily.Serif)) {
                    append("Get Your food \n")
                }
                append("\n")
                withStyle(style = SpanStyle(color = Color.White, fontSize = 35.sp, fontWeight = FontWeight.Bold, fontFamily = FontFamily.SansSerif)) {
                    append("Delivery at our \n")
                }
                append("\n")
                withStyle(style = SpanStyle(color = Color.White, fontSize = 30.sp, fontFamily = FontFamily.Serif)) {
                    append("Doorstep")
                }
            }
            Spacer(modifier = Modifier.height(30.dp))
            Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.TopEnd) {
                Image(
                    painter = painterResource(id = R.drawable.ic_drone_icon), contentDescription = "", modifier = Modifier
                        .layoutId("droneImg")
                        .size(150.dp), contentScale = ContentScale.FillBounds
                )
            }
            Text(text = welcomeTitle)
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = "We have 5000+ Review and our customers trusts your food and delivery service.",
                style = TextStyle(color = Color.White, fontSize = 16.sp)
            )

            Spacer(modifier = Modifier.height(20.dp))
            Image(
                painter = painterResource(id = R.drawable.ic_food_boy_icon), contentDescription = "", modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.7f), contentScale = ContentScale.FillBounds
            )
            Spacer(modifier = Modifier.height(40.dp))
            Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.TopEnd) {
                MenuIcon(menuIcon = R.drawable.ic_right_icon, contentDescription ="", onClick = {
                    navController.navigate(AppRoute.DashboardRoute){
                        popUpTo(navController.graph.startDestinationId){
                            saveState=true
                        }
                        launchSingleTop=true
                    }
                })
            }
        }
    }
}