package com.example.businesscardabdul_ahadmahmood_u21co1076

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscardabdul_ahadmahmood_u21co1076.ui.theme.BusinessCardAbdulAhadMahmoodU21CO1076Theme

// Colors
val LightBlue = Color(0xFFE3F2FD)
val IconBlue = Color(0xFF1565C0)
val BorderBlue = Color(0xFF1565C0)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardAbdulAhadMahmoodU21CO1076Theme {
                Scaffold(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(LightBlue)
                ) { innerPadding ->
                    // Apply innerPadding to main Box to remove warning
                    Box(
                        modifier = Modifier
                            .padding(innerPadding) // Now used!
                            .padding(16.dp)
                            .fillMaxWidth()
                            .fillMaxHeight(0.85f)
                            .border(
                                width = 6.dp, // thicker border
                                color = BorderBlue,
                                shape = RoundedCornerShape(16.dp)
                            )
                            .background(Color.White)
                            .padding(24.dp)
                    ) {
                        BusinessCardApp()
                    }
                }
            }
        }
    }
}

@Composable
fun BusinessCardApp(modifier: Modifier = Modifier) {

    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly, // reduces space between top and bottom
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ProfileSection()
        ContactSection()
    }
}

@Composable
fun ProfileSection() {

    Column(
        modifier = Modifier.padding(top = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.pass),
            contentDescription = "Profile Image",
            modifier = Modifier
                .size(120.dp)
                .clip(RoundedCornerShape(16.dp)) // optional rounded image
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = "Abdul-Ahad Mahmood",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
        )

        // University name under the full name
        Text(
            text = "Ahmadu Bello University Zaria",
            color = IconBlue,
            fontSize = 18.sp
        )

        Text(
            text = "Aspiring Android Developer",
            color = IconBlue,
            fontSize = 18.sp
        )
    }
}

@Composable
fun ContactSection() {

    Column(
        modifier = Modifier.padding(bottom = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ContactItem(Icons.Default.Phone, "+234 906 661 6336")
        ContactItem(Icons.Default.Share, "@abdul_ahad")
        ContactItem(Icons.Default.Email, "mahmoodabdulahad@gmail.com")
    }
}

@Composable
fun ContactItem(icon: androidx.compose.ui.graphics.vector.ImageVector, text: String) {

    Row(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(0.7f),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = IconBlue
        )

        Spacer(modifier = Modifier.width(12.dp))

        Text(
            text = text,
            color = IconBlue,
            fontSize = 16.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BusinessCardPreview() {
    BusinessCardAbdulAhadMahmoodU21CO1076Theme {
        BusinessCardApp()
    }
}