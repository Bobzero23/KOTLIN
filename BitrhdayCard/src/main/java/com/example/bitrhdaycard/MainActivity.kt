package com.example.bitrhdaycard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bitrhdaycard.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    BirthdayGreetingWithText(message = "Happy Birthday Bob", "-from TheProblem")
                }
            }
        }
    }
}

@Composable
fun BirthdayGreetingWithText(message: String, from : String) {
    Column {
        Text(text = message, fontSize = 36.sp,
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentWidth(align = Alignment.Start)
            .padding(start = 40.dp, top = 16.dp))

        Text(text = from, fontSize = 24.sp,
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentWidth(align = Alignment.Start)
            .padding(start = 90.dp, end = 16.dp))
    }
}

@Composable
fun BirthdayGreetingWithImage(message : String, from : String) {
    val image = painterResource(R.drawable.androidparty)
    Box {
        Image(painter = image, contentDescription = null,
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth(),
            contentScale = ContentScale.Crop)
        BirthdayGreetingWithText(message = "Happy Birthday Bob", "-from TheProblem")
    }

}

@Preview(showBackground = true, name = "My Preview")
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        BirthdayGreetingWithImage(message = "Happy Birthday Bob", "-from TheProblem")
    }
}