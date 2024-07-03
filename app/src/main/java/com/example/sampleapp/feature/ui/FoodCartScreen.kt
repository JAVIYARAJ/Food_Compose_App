package com.example.sampleapp.feature.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeightIn
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.sampleapp.R
import com.example.sampleapp.feature.components.common.DishPriceIndicatorWidget
import com.example.sampleapp.feature.components.common.ElevatedButtonWidget
import com.example.sampleapp.feature.components.common.MenuIcon
import com.example.sampleapp.ui.theme.backgroundColor

@Composable
fun PaymentScreen(modifier: Modifier = Modifier, navController: NavController) {

    Scaffold(
        topBar = {
            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .statusBarsPadding()
                    .padding(all = 10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                MenuIcon(menuIcon = R.drawable.ic_back_icon, contentDescription = "back_icon", onClick = {
                    navController.popBackStack()
                })
                Text(
                    text = "Your cart food",
                    style = TextStyle(color = Color.Black, fontSize = 18.sp),
                    modifier = Modifier.weight(0.5f),
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold
                )
                MenuIcon(menuIcon = R.drawable.ic_more_icon, contentDescription = "notification_icon", onClick = {

                })
            }
        },
        bottomBar = {
            BottomAppBar(
                containerColor = Color.White,
                tonalElevation = 10.dp,
                modifier = Modifier
                    .clip(RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp))
                    .fillMaxHeight(0.4f) // Set the height to fit content
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    CartPromoCodeWidget()
                    Spacer(modifier = Modifier.height(20.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 20.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Text(text = "Item total:", style = TextStyle(fontSize = 18.sp, color = Color.Gray))
                        Text(text = "$20", style = TextStyle(fontSize = 20.sp, color = Color.Gray))
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 20.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Text(text = "Delivery:", style = TextStyle(fontSize = 18.sp, color = Color.Gray))
                        Text(text = "Free", style = TextStyle(fontSize = 20.sp, color = Color.Gray))
                    }

                    Spacer(modifier = Modifier.height(20.dp))
                    ElevatedCard(
                        shape = RoundedCornerShape(20.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 20.dp, end = 20.dp, bottom = 20.dp),
                        colors = CardDefaults.cardColors(containerColor = Color.Black)
                    ) {
                        Text(
                            text = "Place Order",
                            style = TextStyle(color = Color.White),
                            modifier = Modifier
                                .padding(horizontal = 30.dp, vertical = 15.dp)
                                .fillMaxWidth(),
                            textAlign = TextAlign.Center,
                            fontSize = 20.sp
                        )
                    }
                }
            }
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .padding(padding)
                .then(Modifier.padding(horizontal = 10.dp))
                .fillMaxSize()
        ) {
            items(10) {
                CartDishItemWidget()
            }
        }

    }
}

@Preview
@Composable
fun PaymentScreenPreview(modifier: Modifier = Modifier) {

    Scaffold(
        topBar = {
            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .statusBarsPadding()
                    .padding(all = 10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                MenuIcon(menuIcon = R.drawable.ic_back_icon, contentDescription = "back_icon", onClick = {
                    // navController.popBackStack()
                })
                Text(
                    text = "Your cart food",
                    style = TextStyle(color = Color.Black, fontSize = 18.sp),
                    modifier = Modifier.weight(0.5f),
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold
                )
                MenuIcon(menuIcon = R.drawable.ic_more_icon, contentDescription = "notification_icon", onClick = {

                })
            }
        },
        bottomBar = {
            BottomAppBar(
                containerColor = Color.White,
                tonalElevation = 10.dp,
                modifier = Modifier
                    .clip(RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp))
                    .fillMaxHeight(0.4f) // Set the height to fit content
            ) {
                Column {
                    CartPromoCodeWidget(modifier = Modifier.padding(10.dp))
                    Spacer(modifier = Modifier.height(20.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 20.dp),
                        horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Text(text = "Item total:", style = TextStyle(fontSize = 18.sp, color = Color.Gray))
                        Text(text = "$20", style = TextStyle(fontSize = 20.sp, color = Color.Gray))

                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 20.dp),
                        horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Text(text = "Delivery:", style = TextStyle(fontSize = 18.sp, color = Color.Gray))
                        Text(text = "Free", style = TextStyle(fontSize = 20.sp, color = Color.Gray))

                    }

                    Spacer(modifier = Modifier.height(20.dp))
                    ElevatedCard(
                        shape = RoundedCornerShape(20.dp), modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 20.dp, end = 20.dp, bottom = 20.dp), colors = CardDefaults.cardColors(containerColor = Color.Black)
                    ) {
                        Text(
                            text = "Place Order",
                            style = TextStyle(color = Color.White),
                            modifier = Modifier
                                .padding(horizontal = 30.dp, vertical = 15.dp)
                                .fillMaxWidth(),
                            textAlign = TextAlign.Center,
                            fontSize = 20.sp
                        )
                    }
                }
            }

        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .padding(padding)
                .then(Modifier.padding(horizontal = 10.dp))
                .fillMaxSize()
        ) {
            items(10) {
                CartDishItemWidget()
            }
        }

    }
}

@Preview
@Composable
fun CartDishItemWidget(modifier: Modifier = Modifier) {
    Surface(
        shape = RoundedCornerShape(10.dp), color = Color.White, modifier = Modifier
            .fillMaxWidth()
            .height(120.dp)
            .padding(5.dp)
    ) {
        Row(modifier = Modifier.padding(10.dp)) {
            Surface(
                color = Color.Gray.copy(alpha = 0.2f),
                shape = RoundedCornerShape(15.dp),
                modifier = Modifier.size(100.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_burger_dish_icon), contentDescription = "",
                    contentScale = ContentScale.FillBounds, modifier = Modifier.padding(10.dp)
                )
            }
            Spacer(modifier = Modifier.width(10.dp))
            Column(verticalArrangement = Arrangement.Center, modifier = Modifier.fillMaxSize()) {
                Text(text = "Original Sushi", style = TextStyle(fontSize = 20.sp, fontFamily = FontFamily.SansSerif))
                Spacer(modifier = Modifier.height(10.dp))
                Row {
                    DishPriceIndicatorWidget(dishPrice = 10.0)
                    Spacer(modifier = Modifier.weight(1f))
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Surface(
                            modifier = Modifier.size(25.dp),
                            border = BorderStroke(1.5.dp, color = Color.Gray),
                            shape = RoundedCornerShape(10.dp)
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.ic_minus_icon),
                                contentDescription = "minus",
                                colorFilter = ColorFilter.tint(color = Color.Gray),
                                modifier = Modifier
                                    .size(20.dp)
                                    .padding(3.dp),
                                contentScale = ContentScale.Crop
                            )

                        }
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(text = "5", style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold))
                        Spacer(modifier = Modifier.width(8.dp))
                        Image(
                            painter = painterResource(id = R.drawable.ic_plus_icon),
                            contentDescription = "plush",
                            colorFilter = ColorFilter.tint(color = Color.Gray),
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.size(20.dp)
                        )
                    }
                }
            }
        }
    }
}


@Preview
@Composable
fun CartPromoCodeWidget(modifier: Modifier = Modifier) {

    val promoCodeValue = remember {
        mutableStateOf("")
    }

    Surface(
        modifier = modifier
            .height(65.dp)
            .fillMaxWidth()
            .padding(horizontal = 10.dp), shape = RoundedCornerShape(10.dp), color = Color.White
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 10.dp), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center
        ) {
            TextField(
                value = promoCodeValue.value,
                onValueChange = {
                    promoCodeValue.value = it
                },
                maxLines = 1,
                modifier = Modifier
                    .weight(1f)
                    .fillMaxSize()
                    .background(color = Color.Transparent),
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = Color.Transparent,
                    focusedContainerColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                ),
                minLines = 1,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text
                ),
                leadingIcon = {
                    Image(
                        painter = painterResource(id = R.drawable.ic_coupon_icon),
                        contentDescription = "promoCode",
                        modifier = Modifier
                            .size(35.dp)
                            .weight(0.3f),
                        contentScale = ContentScale.Fit,
                        colorFilter = ColorFilter.tint(color = Color.Gray)
                    )
                },
                placeholder = {
                    Text(text = "Promo code", style = TextStyle(fontFamily = FontFamily.Serif), fontSize = 18.sp, color = Color.Gray)
                })
            ElevatedButtonWidget(title = "Apply", buttonColor = Color.Black, radius = 10.dp, modifier = Modifier.weight(0.7f), fontSize = 16.sp)
        }
    }
}
