package com.example.colorguessinggame

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.colorguessinggame.ui.theme.ColorGuessingGameTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ColorGuessingGameTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ColorApp()
                }
            }
        }
    }
}

@Composable
fun ColorApp(){
    Column() {
        Intro()
        ColorImageAndName(modifier= Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
        )
    }
}

@Composable
fun Intro(){
    Text(
        fontSize = 27.sp,
        text = stringResource(id = R.string.Intro),
        modifier = Modifier.padding(start=10.dp, top=100.dp)
    )
}

@Composable
fun ColorImageAndName(modifier: Modifier=Modifier){
    var click by remember{ mutableStateOf(1) }
    val imageResource= when(click){
        1->R.drawable.blue
        2->R.drawable.bottom_green
        3->R.drawable.cyan_blue
        4->R.drawable.green
        5->R.drawable.red
        6->R.drawable.dark_blue
        7->R.drawable.dark_maroon
        8->R.drawable.hot_pink
        9->R.drawable.lavender
        10->R.drawable.magenta
        11->R.drawable.pale_pink
        12->R.drawable.very_dark_purple
        else->R.drawable.yellow
    }
    val textLabelResourceId= when(click){
        1->R.string.blue
        2->R.string.bottom_green
        3->R.string.cyan_blue
        4->R.string.green
        5->R.string.red
        6->R.string.dark_blue
        7->R.string.dark_maroon
        8->R.string.hot_pink
        9->R.string.lavender
        10->R.string.magenta
        11->R.string.pale_pink
        12->R.string.very_dark_purple
        else->R.string.yellow
    }
    Column(modifier = modifier,
    horizontalAlignment = Alignment.CenterHorizontally) {

        Image(
            painter = painterResource(imageResource),
            contentDescription = click.toString(),
            modifier = Modifier
                .wrapContentSize()
                .height(250.dp)
                .width(250.dp)
                .border(
                    BorderStroke(2.dp, Color.DarkGray),
                    shape = RoundedCornerShape(1.dp)
                )
                .padding(30.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = stringResource(textLabelResourceId),
            fontSize = 20.sp
        )
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = {click=(1..12).random()}) {
            Text(
                text = stringResource(id = R.string.next),
                fontSize = 20.sp
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ColorGuessingGameTheme {
        ColorApp()
    }
}