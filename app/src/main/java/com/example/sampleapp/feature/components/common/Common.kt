package com.example.sampleapp.feature.components.common

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sampleapp.R

@Composable
fun MenuIcon(
    modifier: Modifier = Modifier,
    menuIcon: Int,
    contentDescription: String,
    scaleType: ContentScale = ContentScale.Inside,
    menuColor: Color = Color.White,
    colorFilter: ColorFilter? = null,
    size: Dp = 50.dp,
    onClick: () -> Unit
) {
    Surface(modifier = modifier.size(size).clip(RoundedCornerShape(20.dp)).clickable {
        onClick.invoke()
    }, shape = RoundedCornerShape(50.dp), color = menuColor) {
        Image(painter = painterResource(id = menuIcon), contentDescription = contentDescription, contentScale = scaleType, colorFilter = colorFilter)
    }
}

@Composable
fun CustomizedTextField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    hint: String,
    hintStyle: TextStyle = TextStyle(color = Color.Gray),
    leadingIcon: @Composable (() -> Unit)? = null,
    imeAction: ImeAction = ImeAction.Go,
    keyboardType: KeyboardType = KeyboardType.Text,
    imeCallBack: (() -> Unit)? = null
) {

    val customShape: Shape = RoundedCornerShape(40.dp)

    OutlinedTextField(modifier = modifier.border(BorderStroke(0.8.dp, color = Color.Gray), shape = customShape),
        value = value,
        onValueChange = onValueChange,
        leadingIcon = leadingIcon,
        placeholder = {
            Text(text = hint, style = hintStyle)
        },
        shape = customShape,
        keyboardOptions = KeyboardOptions(
            keyboardType = keyboardType,
            imeAction = imeAction
        ),
        keyboardActions = KeyboardActions(
            onGo = {
                imeCallBack?.invoke()
            },
            onDone = {
                imeCallBack?.invoke()
            },
            onSearch = {
                imeCallBack?.invoke()
            },
            onNext = {
                imeCallBack?.invoke()
            },
            onSend = {
                imeCallBack?.invoke()
            },
            onPrevious = {
                imeCallBack?.invoke()
            }
        )
    )
}

@Composable
fun RoundedButton(
    onClick: () -> Unit,
    text: String,
    backgroundColor: Color = Color.Blue,
    contentColor: Color = Color.White,
    @SuppressLint("ModifierParameter") modifier: Modifier = Modifier,
    roundedValue: Int = 20
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = backgroundColor,
            contentColor = contentColor
        ),
        contentPadding = ButtonDefaults.TextButtonContentPadding,
        shape = RoundedCornerShape(roundedValue),
        modifier = modifier
            .padding(5.dp)
            .height(45.dp)
    ) {
        Text(
            text = text,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun CustomAppBar(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .statusBarsPadding()
            .padding(all = 10.dp)
    ) {
        MenuIcon(menuIcon = R.drawable.ic_menu_icon, contentDescription = "menu_icon", onClick = {

        })
        Column(modifier = Modifier.weight(0.6f), horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "Location", style = TextStyle(color = Color.Gray, fontSize = 16.sp, textAlign = TextAlign.Center))
            Spacer(modifier = Modifier.height(5.dp))
            Row(horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(id = R.drawable.ic_location_icon),
                    contentDescription = "menu_icon",
                    contentScale = ContentScale.Inside
                )
                Text(text = "Ahmedabad", style = TextStyle(color = Color.Gray, fontSize = 16.sp))
            }
        }
        MenuIcon(menuIcon = R.drawable.ic_notification_icon, contentDescription = "notification_icon", onClick = {

        })
    }
}


@Composable
fun DishRatingWidget(modifier: Modifier = Modifier) {
    Row(verticalAlignment = Alignment.CenterVertically, modifier = modifier) {
        Image(
            painter = painterResource(id = R.drawable.ic_star_icon),
            contentDescription = "start_icon",
            contentScale = ContentScale.Inside,
            modifier = Modifier
                .size(25.dp)
        )
        Spacer(modifier = Modifier.width(5.dp))
        Text(text = "4.5", style = TextStyle(color = Color.Gray), fontSize = 16.sp)
    }
}

@Composable
fun DishPriceIndicatorWidget(modifier: Modifier = Modifier, dishPrice: Double, fontSize: TextUnit = 20.sp) {

    val dishPriceString = buildAnnotatedString {
        withStyle(
            style = SpanStyle(
                fontSize = 16.sp, fontFamily = FontFamily.Monospace
            )
        ) {
            append("$")
        }
        withStyle(
            style = SpanStyle(
                fontSize = fontSize, fontWeight = FontWeight.Bold
            )
        ) {
            append(" $dishPrice")
        }
    }
    Text(text = dishPriceString, style = TextStyle(color = Color.Black), modifier = modifier, fontSize = 18.sp)
}



@Composable
fun ElevatedButtonWidget(
    modifier: Modifier = Modifier,
    buttonColor: Color,
    radius: Dp = 20.dp,
    title: String,
    textStyle: TextStyle = TextStyle(color = Color.White),
    fontSize: TextUnit = 20.sp
) {
    ElevatedCard(
        shape = RoundedCornerShape(radius), modifier = modifier, colors = CardDefaults.cardColors(containerColor = buttonColor)
    ) {
        Text(
            text = title,
            style = textStyle,
            modifier = Modifier
                .padding(horizontal = 30.dp, vertical = 15.dp)
                .fillMaxWidth(),
            textAlign = TextAlign.Center,
            fontSize = fontSize
        )
    }
}