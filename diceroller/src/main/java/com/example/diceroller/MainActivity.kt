package com.example.diceroller

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
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
    Column(
        modifier = modifier,
        //making the object at the center of the device screen
        horizontalAlignment = Alignment.CenterHorizontally) {
        //adding the image to our ui
        Image(painter = painterResource(R.drawable.dice_1),
            contentDescription = "1" )
        //adding a little space to our image
        Spacer(modifier = Modifier.height(16.dp))
        //adding the button to our image
        Button(onClick = { /*TODO*/ }) {
            //here we call the string we created on the xml file
            Text(text = stringResource(R.string.roll))
        }
    }
}
