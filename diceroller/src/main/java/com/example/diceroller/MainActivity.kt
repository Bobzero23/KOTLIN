package com.example.diceroller

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.diceroller.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
              MyApplicationTheme() {
                  DiceRoller()
              }
        }
    }
}

@Preview
@Composable
fun DiceRoller() {
    DiceWithButtonAndImage(modifier = Modifier
        .fillMaxSize() //making full screen
        .wrapContentSize(Alignment.Center)) //making the object at center
}

@Composable
fun DiceWithButtonAndImage(modifier: Modifier = Modifier) {
    //we did all of this because we have to let the composable know that our value changes
    //we will learn more about this in the next chapters
    var result by remember {
        mutableStateOf(1)
    }

    //displaying the images accordingly
    val imageResource = when(result) {
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }

    Column(
        modifier = modifier,
        //making the object at the center of the device screen
        horizontalAlignment = Alignment.CenterHorizontally) {
        //adding the image to our ui

        Image(painter = painterResource(imageResource),
            contentDescription = result.toString() )

        //adding a little space to our image
        Spacer(modifier = Modifier.height(16.dp))

        //adding the button to our image
        Button(//displaying random number from 1 to 6 when clicked
            onClick = {result = (1..6).random()}) {
            //here we call the string we created on the xml file
            Text(text = stringResource(R.string.roll))
        }
    }
}
