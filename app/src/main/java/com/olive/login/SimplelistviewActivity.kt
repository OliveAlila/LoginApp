package com.olive.login

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.olive.login.ui.theme.LoginTheme

class SimplelistviewActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
//                    Greeting("Android")
                    SimpleListView()
                }
            }
        }
    }
}

private val countryList =
    mutableListOf("India", "Pakistan", "China", "United States","Germany","Spain","Portugal")

private val listModifier = Modifier
    .fillMaxSize()
    .background(Color.LightGray)
    .padding(20.dp)

private val textStyle = androidx.compose.ui.text.TextStyle(fontSize = 20.sp, color = Color.White)

@Composable
fun SimpleListView() {
    LazyColumn(modifier = listModifier) {
        items(countryList) { country ->
            Text(text = country,
                style = textStyle,
                color = Color.Black,
                fontSize = 25.sp)
        }
    }
}
@Preview(showBackground = true)
@Composable
fun SimpleListViewprev() {
    SimpleListView()
}