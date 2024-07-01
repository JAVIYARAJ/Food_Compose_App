package com.example.sampleapp.feature.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.ScrollableDefaults
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.sampleapp.R
import com.example.sampleapp.feature.components.common.DishPriceIndicatorWidget
import com.example.sampleapp.feature.components.common.DishRatingWidget
import com.example.sampleapp.feature.components.common.MenuIcon
import com.example.sampleapp.ui.theme.selectedItemColor

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun DishDetailScreen(modifier: Modifier = Modifier,navController: NavController) {

    val dishCounter = remember {
        mutableIntStateOf(0)
    }

    fun increaseCounter(isMinus: Boolean = false) {
        if (isMinus && dishCounter.intValue != 0) {
            dishCounter.intValue -= dishCounter.intValue
        } else {
            dishCounter.intValue += dishCounter.intValue
        }
    }

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
                    text = "Detail",
                    style = TextStyle(color = Color.Black, fontSize = 18.sp),
                    modifier = Modifier.weight(0.5f),
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold
                )
                MenuIcon(menuIcon = R.drawable.ic_like_icon, contentDescription = "notification_icon", onClick = {

                })
            }
        },
        bottomBar = {
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp)
                    .padding(15.dp), color = Color.White, shape = RoundedCornerShape(10.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp), verticalAlignment = Alignment.CenterVertically
                ) {
                    Column {
                        DishPriceIndicatorWidget(dishPrice = 50.0)
                        Text(text = "Total Price", style = TextStyle(fontSize = 18.sp, color = Color.Black))
                    }
                    Spacer(modifier = Modifier.weight(1f))
                    ElevatedCard(shape = RoundedCornerShape(20.dp), colors = CardDefaults.cardColors(containerColor = Color.Black)) {
                        Text(
                            text = "Place Order",
                            style = TextStyle(color = Color.White),
                            modifier = Modifier.padding(horizontal = 30.dp, vertical = 15.dp)
                        )
                    }
                }
            }
        }
    ) { padding ->


        val count = remember {
            mutableIntStateOf(0)
        }

        LazyColumn(
            flingBehavior = ScrollableDefaults.flingBehavior(),
            modifier = Modifier
                .padding(padding)
                .then(Modifier.padding(horizontal = 15.dp))
        ) {
            item {
                Box(contentAlignment = Alignment.Center) {

                    Surface(
                        Modifier
                            .fillMaxWidth()
                            .height(230.dp), shape = RoundedCornerShape(60.dp),
                        color = Color.Blue.copy(alpha = 0.4f)
                    ) {

                    }
                    Image(
                        painter = painterResource(id = R.drawable.ic_burger_dish_icon), contentDescription = "burger_icon",
                        Modifier
                            .fillMaxWidth()
                            .height(200.dp), contentScale = ContentScale.Fit
                    )
                }
            }
            item {
                Spacer(modifier = Modifier.height(20.dp))
            }

            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 10.dp)
                ) {
                    Text(
                        text = "Original Sushi",
                        style = TextStyle(color = Color.Black, fontSize = 22.sp),
                        modifier = Modifier.weight(1f),
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily.Serif
                    )

                    DishRatingWidget()
                }

            }
            item {
                Spacer(modifier = Modifier.height(10.dp))
            }

            item {
                FlowRow {
                    DishItemWidget(item = "Coca Cola", itemIcon = R.drawable.ic_coca_cola_icon)
                    DishItemWidget(item = "Frens Fries")
                    DishItemWidget(item = "Aallu Tiki Burger", itemIcon = R.drawable.ic_burger_dish_icon)
                    DishItemWidget(item = "Mac Puff Spicy")
                }
            }

            item {
                Spacer(modifier = Modifier.height(10.dp))
            }

            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 10.dp), verticalAlignment = Alignment.CenterVertically
                ) {
                    DishPriceIndicatorWidget(dishPrice = 24.0, fontSize = 25.sp)
                    Spacer(modifier = Modifier.weight(1f))
                    DishItemCounterWidget(onClick = {flag->
                        if(flag){
                            count.intValue++
                        }else{
                            if(count.intValue!=0){
                            count.intValue--
                            }
                        }
                    }, dishCount = count.intValue)
                }

            }

            item {
                Spacer(modifier = Modifier.height(10.dp))
            }


            item {
                Text(text = "About Sushi", style = TextStyle(fontSize = 18.sp, color = Color.Black, fontWeight = FontWeight.Bold))
            }

            item {
                Spacer(modifier = Modifier.height(10.dp))

            }

            item {
                Text(
                    text = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.\n" +
                            "\n", style = TextStyle(fontSize = 14.sp, color = Color.Gray, fontWeight = FontWeight.Normal)
                )
            }


        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Preview(showSystemUi = true)
@Composable
fun DishDetailScreen(modifier: Modifier = Modifier) {

    val dishCounter = remember {
        mutableIntStateOf(0)
    }

    fun increaseCounter(isMinus: Boolean = false) {
        if (isMinus && dishCounter.intValue != 0) {
            dishCounter.intValue -= dishCounter.intValue
        } else {
            dishCounter.intValue += dishCounter.intValue
        }
    }

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

                })
                Text(
                    text = "Detail",
                    style = TextStyle(color = Color.Black, fontSize = 18.sp),
                    modifier = Modifier.weight(0.5f),
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold
                )
                MenuIcon(menuIcon = R.drawable.ic_like_icon, contentDescription = "notification_icon", onClick = {

                })
            }
        },
        bottomBar = {
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp)
                    .padding(15.dp), color = Color.White, shape = RoundedCornerShape(10.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp), verticalAlignment = Alignment.CenterVertically
                ) {
                    Column {
                        DishPriceIndicatorWidget(dishPrice = 50.0)
                        Text(text = "Total Price", style = TextStyle(fontSize = 18.sp, color = Color.Black))
                    }
                    Spacer(modifier = Modifier.weight(1f))
                    ElevatedCard(shape = RoundedCornerShape(20.dp), colors = CardDefaults.cardColors(containerColor = Color.Black)) {
                        Text(
                            text = "Place Order",
                            style = TextStyle(color = Color.White),
                            modifier = Modifier.padding(horizontal = 30.dp, vertical = 15.dp)
                        )
                    }
                }
            }
        }
    ) { padding ->
        LazyColumn(
            flingBehavior = ScrollableDefaults.flingBehavior(),
            modifier = Modifier
                .padding(padding)
                .then(Modifier.padding(horizontal = 15.dp))
        ) {
            item {
                Box(contentAlignment = Alignment.Center) {

                    Surface(
                        Modifier
                            .fillMaxWidth()
                            .height(230.dp), shape = RoundedCornerShape(60.dp),
                        color = Color.Blue.copy(alpha = 0.4f)
                    ) {

                    }
                    Image(
                        painter = painterResource(id = R.drawable.ic_burger_dish_icon), contentDescription = "burger_icon",
                        Modifier
                            .fillMaxWidth()
                            .height(200.dp), contentScale = ContentScale.Fit
                    )
                }
            }
            item {
                Spacer(modifier = Modifier.height(20.dp))
            }

            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 10.dp)
                ) {
                    Text(
                        text = "Original Sushi",
                        style = TextStyle(color = Color.Black, fontSize = 22.sp),
                        modifier = Modifier.weight(1f),
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily.Serif
                    )

                    DishRatingWidget()
                }

            }
            item {
                Spacer(modifier = Modifier.height(10.dp))
            }

            item {
                FlowRow {
                    DishItemWidget(item = "Coca Cola", itemIcon = R.drawable.ic_coca_cola_icon)
                    DishItemWidget(item = "Frens Fries")
                    DishItemWidget(item = "Aallu Tiki Burger", itemIcon = R.drawable.ic_burger_dish_icon)
                    DishItemWidget(item = "Mac Puff Spicy")
                }
            }

            item {
                Spacer(modifier = Modifier.height(10.dp))
            }

            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 10.dp), verticalAlignment = Alignment.CenterVertically
                ) {
                    DishPriceIndicatorWidget(dishPrice = 24.0, fontSize = 25.sp)
                    Spacer(modifier = Modifier.weight(1f))
                    DishItemCounterWidget(onClick = {
                        increaseCounter(it)
                    }, dishCount = dishCounter.intValue)
                }

            }

            item {
                Spacer(modifier = Modifier.height(10.dp))
            }


            item {
                Text(text = "About Sushi", style = TextStyle(fontSize = 18.sp, color = Color.Black, fontWeight = FontWeight.Bold))
            }

            item {
                Spacer(modifier = Modifier.height(10.dp))

            }

            item {
                Text(
                    text = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.\n" +
                            "\n", style = TextStyle(fontSize = 14.sp, color = Color.Gray, fontWeight = FontWeight.Normal)
                )
            }


        }
    }
}



@Composable
fun DishItemWidget(modifier: Modifier = Modifier, item: String, itemIcon: Int? = null,isSelected:Boolean=false) {
    Surface(shape = RoundedCornerShape(10.dp), color =if(isSelected) selectedItemColor else Color.White, modifier = Modifier.padding(5.dp)) {
        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(10.dp)) {
            if (itemIcon != null) {
                Image(
                    painter = painterResource(id = itemIcon),
                    contentDescription = "item_icon",
                    contentScale = ContentScale.Fit,
                    modifier = Modifier.size(25.dp)
                )
                Spacer(modifier = Modifier.width(5.dp))
            }
            Text(text = item, style = TextStyle(color = if(isSelected) Color.White else Color.Black))
        }
    }
}

@Composable
fun DishItemCounterWidget(modifier: Modifier = Modifier, onClick: (Boolean) -> Unit, dishCount: Int) {
    Surface(
        border = BorderStroke(width = 1.dp, color = Color.Gray),
        shape = RoundedCornerShape(20.dp)
    ) {
        Row(modifier = Modifier.padding(10.dp), verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = R.drawable.ic_minus_icon),
                contentDescription = "minus",
                modifier = Modifier
                    .size(15.dp).clip(RoundedCornerShape(20.dp))
                    .clickable {
                        onClick.invoke(false)
                    },
                contentScale = ContentScale.Fit
            )

            Spacer(modifier = Modifier.width(10.dp))

            Text(text = dishCount.toString(), style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold))

            Spacer(modifier = Modifier.width(10.dp))

            Image(
                painter = painterResource(id = R.drawable.ic_plus_icon),
                contentDescription = "plus",
                modifier = Modifier
                    .size(15.dp).clip(RoundedCornerShape(20.dp))
                    .clickable {
                        onClick.invoke(true)
                    },
                contentScale = ContentScale.Fit
            )
        }
    }
}

