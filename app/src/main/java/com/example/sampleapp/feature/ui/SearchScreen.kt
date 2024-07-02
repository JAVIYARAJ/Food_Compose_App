package com.example.sampleapp.feature.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sampleapp.R
import com.example.sampleapp.feature.components.common.CustomizedTextField
import com.example.sampleapp.feature.components.common.DishPriceIndicatorWidget
import com.example.sampleapp.feature.components.common.LoadingWidget
import kotlinx.coroutines.delay

@OptIn(ExperimentalLayoutApi::class)
@Preview(showSystemUi = true)
@Composable
fun SearchScreen(modifier: Modifier = Modifier) {

    val isLoading= remember {
        mutableStateOf(true)
    }

    LaunchedEffect(key1 = Unit) {
        delay(1000)
        isLoading.value=false
    }

    val dishType = listOf("All", "Salad", "Soup", "Main Dish", "Breakfast", "Launch", "Dinner")

    val dishList= remember {
        mutableStateListOf( SearchDishItem(
            name = "Burger",
            dishIcon = R.drawable.ic_burger_dish_icon,
            restaurantIcon = R.drawable.ic_diet_icon,
            restaurantName = "Mcdonald's ",
            isLiked = true
        ),
            SearchDishItem(
                name = "Pizza",
                dishIcon = R.drawable.pizza,
                restaurantIcon = R.drawable.ic_diet_icon,
                restaurantName = "Dominos",
                isLiked = false
            ))
    }
    
    fun changeLike(index:Int){
        dishList[index].isLiked=!dishList[index].isLiked
    }

    val tabSelectedIndex = 0

    if(isLoading.value){
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
            LoadingWidget()
        }
    }else{
        Scaffold { padding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 15.dp)
                    .then(Modifier.padding(padding))
            ) {

                CustomizedTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp),
                    value = "",
                    onValueChange = {
                    },
                    leadingIcon = {
                        Image(painter = painterResource(id = R.drawable.ic_search_icon), contentDescription = "", modifier = Modifier.size(25.dp))
                    },
                    hint = "Search ingredients"
                )


                Spacer(modifier = Modifier.height(20.dp))


                Text(text = "Recommended for you", style = TextStyle(fontSize = 16.sp, fontFamily = FontFamily.Serif, fontWeight = FontWeight.Bold))



                Spacer(modifier = Modifier.height(20.dp))




                FlowRow {
                    DishItemWidget(item = "Patato", itemIcon = R.drawable.potato)
                    DishItemWidget(item = "Onion", itemIcon = R.drawable.onion, isSelected = true)
                    DishItemWidget(item = "Carrot", itemIcon = R.drawable.carrot)
                    DishItemWidget(item = "Tomato", itemIcon = R.drawable.tomato)
                    DishItemWidget(item = "+10 More")
                }



                Spacer(modifier = Modifier.height(20.dp))



                Text(text = "Choose type of dish", style = TextStyle(fontSize = 16.sp, fontFamily = FontFamily.Serif, fontWeight = FontWeight.Bold))


                Spacer(modifier = Modifier.height(10.dp))



                LazyRow(modifier = Modifier.fillMaxWidth()) {
                    items(dishType.size) { index ->
                        Column {
                            Text(
                                text = dishType[index],
                                style = TextStyle(fontSize = 16.sp, fontFamily = FontFamily.SansSerif, fontWeight = FontWeight.W500),
                                modifier = Modifier.padding(5.dp),
                                color = if (tabSelectedIndex == index) Color.Black else Color.Gray
                            )
                        }
                    }
                }


                Spacer(modifier = Modifier.height(10.dp))

                LazyRow(modifier = Modifier.fillMaxWidth()) {
                    items(dishList.size) { index ->
                        DishItemWidget(model = dishList[index], onLikeClick = {
                            changeLike(index)
                        })
                    }
                }


                Spacer(modifier = Modifier.height(20.dp))


                LazyColumn(modifier = Modifier.fillMaxWidth()) {
                    items(2) {
                        TopRatedDishWidget()
                    }
                }


            }
        }
    }


}


@Composable
fun DishItemWidget(modifier: Modifier = Modifier, model: SearchDishItem,onLikeClick:()->Unit) {
    Surface(
        shape = RoundedCornerShape(10.dp), color = Color.White, modifier = modifier
            .width(300.dp)
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
                    painter = painterResource(id = model.dishIcon), contentDescription = "",
                    contentScale = ContentScale.FillBounds, modifier = Modifier.padding(10.dp)
                )
            }
            Spacer(modifier = Modifier.width(10.dp))
            Column(verticalArrangement = Arrangement.Center, modifier = Modifier.fillMaxSize()) {
                Text(text = model.name, style = TextStyle(fontSize = 20.sp, fontFamily = FontFamily.SansSerif))
                Spacer(modifier = Modifier.height(10.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Surface(modifier = Modifier.size(30.dp), shape = RoundedCornerShape(40.dp)) {
                        Image(painter = painterResource(id = model.restaurantIcon), contentDescription = "")
                    }
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(text = model.restaurantName, style = TextStyle(fontSize = 16.sp, fontFamily = FontFamily.SansSerif))
                }
                Spacer(modifier = Modifier.weight(1f))

                Image(
                    painter = painterResource(id = if (model.isLiked) R.drawable.ic_like_icon else R.drawable.ic_unlike_icon),
                    contentDescription = "",
                    modifier = Modifier.align(alignment = Alignment.End).clip(RoundedCornerShape(10.dp)).clickable {
                        onLikeClick()
                    },
                    contentScale = ContentScale.Fit
                )
            }
        }
    }
}

@Preview
@Composable
fun TopRatedDishWidget(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(270.dp)
            .padding(vertical = 10.dp)
    ) {
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.8f), shape = RoundedCornerShape(10.dp)
        ) {
            Image(painter = painterResource(id = R.drawable.ic_dish_image), contentDescription = "", contentScale = ContentScale.FillBounds)
        }
        Spacer(modifier = Modifier.height(5.dp))
        Text(text = "Veg Burger", style = TextStyle(fontSize = 18.sp, color = Color.Black, fontWeight = FontWeight.SemiBold))
        Spacer(modifier = Modifier.height(5.dp))
        Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            Image(painter = painterResource(id = R.drawable.ic_thumb_up_icon), contentDescription = "", modifier = Modifier.size(20.dp), contentScale = ContentScale.FillBounds)
            Spacer(modifier = Modifier.width(5.dp))
            Text(text = "86% positive", style = TextStyle(fontSize = 16.sp, color = Color.Black, fontWeight = FontWeight.Normal))
        }
    }
}


data class SearchDishItem(
    val name: String,
    val dishIcon: Int,
    val restaurantIcon: Int,
    val restaurantName: String,
    var isLiked: Boolean = false
)