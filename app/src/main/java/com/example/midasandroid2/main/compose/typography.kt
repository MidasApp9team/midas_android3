package com.example.midasandroid2.main.compose

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.example.midasandroid2.R
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp


val font = FontFamily(
    Font(R.font.inter_black, weight = FontWeight.Black),
    Font(R.font.inter_bold, weight = FontWeight.Bold),
    Font(R.font.inter_extrabold, weight = FontWeight.ExtraBold),
    Font(R.font.inter_extralight, weight = FontWeight.ExtraLight),
    Font(R.font.inter_light, weight = FontWeight.Light),
    Font(R.font.inter_medium, weight = FontWeight.Medium),
    Font(R.font.inter_regular, weight = FontWeight .Normal),
    Font(R.font.inter_semibold, weight = FontWeight.SemiBold),
    Font(R.font.inter_thin, weight = FontWeight.Thin),
)

object Typography {
    @Stable
    val body1 = TextStyle(
        fontFamily = font,
        fontWeight = FontWeight.SemiBold,
        fontSize = 30.sp
    )

    @Stable
    val body2 = TextStyle(
        fontFamily = font,
        fontWeight = FontWeight.SemiBold,
        fontSize = 16.sp
    )

    @Stable
    val body3 = TextStyle(
        fontFamily = font,
        fontWeight = FontWeight.SemiBold,
        fontSize = 15.sp
    )

    @Stable
    val btnBody = TextStyle(
        fontFamily = font,
        fontWeight = FontWeight.SemiBold,
        fontSize = 18.sp
    )
}

@Composable
fun Body1(
    modifier: Modifier = Modifier,
    text: String,
    color: Color = BaseColor.Black
){
    Text(
        modifier = modifier,
        text = text,
        style = Typography.body1,
        color = color
    )
}

@Composable
fun Body2(
    modifier: Modifier = Modifier,
    text: String,
    color: Color = BaseColor.Black
){
    Text(
        modifier = modifier,
        text = text,
        style = Typography.body2,
        color = color
    )
}

@Composable
fun Body3(
    modifier: Modifier = Modifier,
    text: String,
    color: Color = BaseColor.Black35
){
    Text(
        modifier = modifier,
        text = text,
        style = Typography.body3,
        color = color
    )
}

@Composable
fun BtnBody(
    modifier: Modifier = Modifier,
    text: String,
    color: Color = BaseColor.White
){
    Text(
        modifier = modifier,
        text = text,
        style = Typography.btnBody,
        color = color
    )
}

