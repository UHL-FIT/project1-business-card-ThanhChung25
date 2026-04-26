package com.example.deadline

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.deadline.ui.theme.DeadlineTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DeadlineTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(0xFFD2E8D4)
                ) {
                    BusinessCardApp()
                }
            }
        }
    }
}

@Composable
fun BusinessCardApp() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.weight(1f))

        MainInfo(
            name = "Nguyễn Thành Chung",
            title = "Android Developer Extraordinaire"
        )


        Spacer(modifier = Modifier.weight(1f))

        ContactInfoSection(
            phone = "0123456789",
            social = "@Android_Chung",
            email = "chung@gmail.com"
        )


        Spacer(modifier = Modifier.height(50.dp))
    }
}

@Composable
fun MainInfo(name: String, title: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        val image = painterResource(id = R.drawable.android_logo)
        Box(
            modifier = Modifier
                .size(120.dp)
                .background(Color(0xFF073042))
                .padding(16.dp)
        ) {
            Image(
                painter = image,
                contentDescription = null,
                modifier = Modifier.fillMaxSize()
            )
        }

        Text(
            text = name,
            fontSize = 32.sp,
            fontWeight = FontWeight.Light,
            modifier = Modifier.padding(top = 10.dp, start = 16.dp, end = 16.dp),
            lineHeight = 40.sp,
            textAlign = androidx.compose.ui.text.style.TextAlign.Center
        )
        Text(
            text = title,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF006D3B)
        )
    }
}
@Composable
fun ContactInfoSection(phone: String, social: String, email: String) {
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        ContactRow(icon = Icons.Default.Phone, text = phone)
        ContactRow(icon = Icons.Default.Share, text = social)
        ContactRow(icon = Icons.Default.Email, text = email)
    }
}

@Composable
fun ContactRow(icon: ImageVector, text: String) {
    Row(
        modifier = Modifier
            .padding(vertical = 8.dp)
            .width(250.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = Color(0xFF006D3B),
            modifier = Modifier.size(24.dp)
        )
        Text(
            text = text,
            modifier = Modifier.padding(start = 20.dp),
            fontSize = 16.sp
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun BusinessCardPreview() {
    DeadlineTheme {
        Surface(color = Color(0xFFD2E8D4)) {
            BusinessCardApp()
        }
    }
}