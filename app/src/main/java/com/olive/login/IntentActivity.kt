package com.olive.login

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.olive.login.ui.theme.LoginTheme

class IntentActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginTheme {
//                 A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
//                    Greeting("Android")
                    Intentscreen()
                }
            }
        }
    }
}

@Composable
fun Intentscreen() {
    val context = LocalContext.current

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray)
            .padding(vertical = 20.dp)
    ) {
       Text(
            text = "Intent App",
            color = Color.Blue,
            fontSize = 28.sp
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedButton(
            onClick = {
                val simToolKitLaunchIntent =
                    context.packageManager.getLaunchIntentForPackage("com.android.stk")

                simToolKitLaunchIntent?.let { context.startActivity(it) }
            },
            shape = ButtonDefaults.shape,
            border = BorderStroke(2.dp, Color.White),
            colors = ButtonDefaults.buttonColors(Color.Magenta),
            modifier = Modifier
                .fillMaxWidth()
        )
        {
            Text(
                text = "Sms",
                fontSize = 15.sp
            )

        }
        Spacer(modifier = Modifier.height(10.dp))

        OutlinedButton(
            onClick = {
                val intent =Intent(Intent.ACTION_CALL, Uri.parse("tel" + "+254758515667"))

                if (ContextCompat.checkSelfPermission(
                    context,
                    android.Manifest.permission.CALL_PHONE
                )!=PackageManager.PERMISSION_GRANTED
                    )

                ActivityCompat.requestPermissions(
                    context as Activity,
                    arrayOf(android.Manifest.permission.CALL_PHONE),
                    1
                )
            else{
                context.startActivity(intent)
            }
        },
            shape = ButtonDefaults.shape,
            border = BorderStroke(2.dp, Color.White),
            colors = ButtonDefaults.buttonColors(Color.Magenta),
            modifier = Modifier
                .fillMaxWidth()
        )
        {
            Text(
                text = "Call",
                fontSize = 15.sp
            )

        }
        Spacer(modifier = Modifier.height(10.dp))

        OutlinedButton(
            onClick = {
                val simToolKitLaunchIntent =
                    context.packageManager.getLaunchIntentForPackage("com.android.stk")

                simToolKitLaunchIntent?.let { context.startActivity(it) }
            },
            shape = ButtonDefaults.shape,
            border = BorderStroke(2.dp, Color.White),
            colors = ButtonDefaults.buttonColors(Color.Magenta),
            modifier = Modifier
                .fillMaxWidth()
        )
        {
            Text(
                text = "Dial",
                fontSize = 15.sp
            )

        }
        Spacer(modifier = Modifier.height(10.dp))

        OutlinedButton(
            onClick = {
                val simToolKitLaunchIntent =
                    context.packageManager.getLaunchIntentForPackage("com.android.stk")

                simToolKitLaunchIntent?.let { context.startActivity(it) }
            },
            shape = ButtonDefaults.shape,
            border = BorderStroke(2.dp, Color.White),
            colors = ButtonDefaults.buttonColors(Color.Magenta),
            modifier = Modifier
                .fillMaxWidth()
        )
        {
            Text(
                text = "Camera",
                fontSize = 15.sp
            )

        }
        Spacer(modifier = Modifier.height(10.dp))

        OutlinedButton(
            onClick = {
                val simToolKitLaunchIntent =
                    context.packageManager.getLaunchIntentForPackage("com.android.stk")

                simToolKitLaunchIntent?.let { context.startActivity(it) }
            },
            shape = ButtonDefaults.shape,
            border = BorderStroke(2.dp, Color.White),
            colors = ButtonDefaults.buttonColors(Color.Magenta),
            modifier = Modifier
                .fillMaxWidth()
        )
        {
            Text(
                text = "Share",
                fontSize = 15.sp
            )

        }
        Spacer(modifier = Modifier.height(10.dp))

        OutlinedButton(
            onClick = {
                val simToolKitLaunchIntent =
                    context.packageManager.getLaunchIntentForPackage("com.android.stk")

                simToolKitLaunchIntent?.let { context.startActivity(it) }
            },
            shape = ButtonDefaults.shape,
            border = BorderStroke(2.dp, Color.White),
            colors = ButtonDefaults.buttonColors(Color.Magenta),
            modifier = Modifier
                .fillMaxWidth()
        )
        {
            Text(
                text = "stk/M-pesa",
                fontSize = 15.sp
            )

        }
        val emailIntent =
            Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", "abc@gmail.com", null))

        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Subject")

        emailIntent.putExtra(Intent.EXTRA_TEXT, "Body")

        context.startActivity(Intent.createChooser(emailIntent, "Send email..."))

        Spacer(modifier = Modifier.height(10.dp))
        OutlinedButton(
            onClick = {
                val intent = Intent(context, MainActivity::class.java)
                context.startActivity(intent)
            },
            modifier = Modifier
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(Color.Magenta)
        ) {
            Text(
                text = "E-mail",
                fontSize = 15.sp
            )
        }
    }
}
@Preview
@Composable
private fun Intentprev() {
    Intentscreen()
}