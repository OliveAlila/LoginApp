package com.olive.login

import android.content.Intent
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.olive.login.ui.theme.LoginTheme

class RegisterActivity : ComponentActivity() {
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
                    Register()
                }
            }
        }
    }
}


@Composable
fun Register(){
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var name by remember { mutableStateOf("") }
    var confirmpassword by remember { mutableStateOf("") }
    val context= LocalContext.current

    Column ( horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(vertical = 10.dp)){
        Text(text = "eMobilis SignUp",
            color = Color.Cyan,
            fontSize = 28.sp
        )

        Icon(imageVector = Icons.Default.Person, contentDescription = "per")
        OutlinedTextField(
            value = name,
            onValueChange = {name=it},
            leadingIcon = { Icon(imageVector = Icons.Default.Person, contentDescription = "person" ) },
            label = { Text(text = "Enter Full Name",
                color = Color.DarkGray,
                fontSize = 20.sp
            )},

            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.fillMaxWidth())
        OutlinedTextField(
            value = email,
            onValueChange = {email=it},
            leadingIcon = { Icon(imageVector = Icons.Default.Email, contentDescription = "icon" ) },
            label = { Text(text = "Enter Email",
                color = Color.DarkGray,
                fontSize = 20.sp
            )},

            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(15.dp))
        OutlinedTextField(
            value = password,
            onValueChange = {password=it},
            leadingIcon = { Icon(imageVector = Icons.Default.Lock, contentDescription = "lock" ) },
            label = { Text(text = "Enter Password",
                color = Color.DarkGray,
                fontSize = 20.sp
            )},

            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(15.dp))
        OutlinedTextField(
            value = confirmpassword,
            onValueChange = {confirmpassword=it},
            leadingIcon = { Icon(imageVector = Icons.Default.Lock, contentDescription = "cpass" ) },
            label = { Text(text = "Confirm Password",
                color = Color.DarkGray,
                fontSize = 20.sp
            )},

            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(15.dp))
        OutlinedButton(onClick = { /*TODO*/ },
            modifier = Modifier
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(Color.Blue)) {
            Text(text ="Register",
                fontSize = 20.sp)

        }
        Spacer(modifier = Modifier.height(15.dp))
        OutlinedButton(onClick = {
            val intent= Intent(context, MainActivity::class.java)
            context.startActivity(intent)
        },
            modifier = Modifier
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(Color.Magenta)) {
            Text(
                text = "Click to LogIn",
                fontSize = 20.sp
            )
        }
    }

}
@Preview
@Composable
private fun Registerprev() {
    Register()
}
