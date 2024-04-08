package com.olive.login

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.olive.login.ui.theme.LoginTheme

class CalculatorActivity : ComponentActivity() {
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
                    Calc()
                }
            }
        }
    }
}

@Composable
fun Calc() {
    var firstnum by remember { mutableStateOf(TextFieldValue("")) }
    var secondnum by remember { mutableStateOf(TextFieldValue("")) }
    var answer by remember { mutableStateOf("") }
//    val context = LocalContext.current


    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(vertical = 10.dp)
    ) {
        Text(
            text = "Calculator",
            color = Color.Blue,
            fontSize = 28.sp
        )

        Spacer(modifier = Modifier.height(50.dp))
        OutlinedTextField(
            value = firstnum,
            label = {
                Text(
                    text = "Enter First Number",
                    color = Color.Black,
                    fontSize = 15.sp
                )
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            onValueChange = {
                firstnum = it

            })
        Spacer(modifier = Modifier.height(20.dp))
        OutlinedTextField(
            value = secondnum,
            label = {
                Text(
                    text = "Enter Second Number",
                    color = Color.Black,
                    fontSize = 15.sp
                )
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            onValueChange = {
                secondnum = it

            })
        Spacer(modifier = Modifier.height(20.dp))
        OutlinedButton(
            onClick = {  val myfirstnum=firstnum.text.trim()
                val mysecondnum=secondnum.text.trim()
                if (myfirstnum.isEmpty() && mysecondnum.isEmpty()){
                    answer="Please fill in all detail"
                }else{
                    val myanswer=myfirstnum.toDouble() + mysecondnum.toDouble()
                    answer=myanswer.toString()}
                      },
            colors = ButtonDefaults.buttonColors(Color.Gray),
            shape = RoundedCornerShape(6.dp),
            modifier = Modifier
                .fillMaxWidth(0.5f)
        ) {
            Text(
                text = "+",
                fontSize = 30.sp
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        OutlinedButton(
            onClick = {  val myfirstnum=firstnum.text.trim()
                val mysecondnum=secondnum.text.trim()
                 if (myfirstnum.isEmpty() &&mysecondnum.isEmpty()){
                    answer="Please fill in all detail"
                }else{
                    val myanswer=myfirstnum.toDouble() - mysecondnum.toDouble()
                    answer=myanswer.toString()} },
            colors = ButtonDefaults.buttonColors(Color.Gray),
            shape = RoundedCornerShape(6.dp),
            modifier = Modifier.fillMaxWidth(0.5f)
        ) {
            Text(
                text = "-",
                fontSize = 30.sp
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        OutlinedButton(
            onClick = { val myfirstnum=firstnum.text.trim()
                val mysecondnum=secondnum.text.trim()
                if (myfirstnum.isEmpty() && mysecondnum.isEmpty()){
                    answer="Please fill in all detail"
                }else{
                    val myanswer=myfirstnum.toDouble() * mysecondnum.toDouble()
                    answer=myanswer.toString()}},
            colors = ButtonDefaults.buttonColors(Color.Gray),
            shape = RoundedCornerShape(6.dp),
            modifier = Modifier.fillMaxWidth(0.5f)
        ) {
            Text(
                text = "*",
                fontSize = 30.sp
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        OutlinedButton(
            onClick = {  val myfirstnum=firstnum.text.trim()
                val mysecondnum=secondnum.text.trim()
                if (myfirstnum.isEmpty() && mysecondnum.isEmpty()){
                    answer="Please fill in all detail"
                }else{
                    val myanswer=myfirstnum.toDouble() / mysecondnum.toDouble()
                    answer=myanswer.toString()} },
            colors = ButtonDefaults.buttonColors(Color.Gray),
            shape = RoundedCornerShape(6.dp),
            modifier = Modifier.fillMaxWidth(0.5f)
        ) {
            Text(
                text = "/",
                fontSize = 30.sp
            )

        }

        Spacer(modifier = Modifier.height(20.dp))
        OutlinedTextField(
            value = answer,
            label = {
                Text(
                    text = "Answer",
                    color = Color.Black,
                    fontSize = 15.sp
                )
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            onValueChange = {
                answer = it
            } )
    }
}





@Preview(showBackground = true)
@Composable
fun CalcPreview() {
    Calc()
}