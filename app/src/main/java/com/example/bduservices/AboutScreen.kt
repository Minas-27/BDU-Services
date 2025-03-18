package com.example.bduservices

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun AboutScreen() {
    val scrollState = rememberScrollState()
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        Column(
            modifier = Modifier
                .verticalScroll(scrollState)
                .weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // App Logo
            Surface(
                shape = CircleShape,
                color = Color.LightGray.copy(alpha = 0.2f),
                modifier = Modifier.size(120.dp),
                border = BorderStroke(1.dp, Color.LightGray)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.bdulogoo),
                    contentDescription = "App Logo",
                    modifier = Modifier.padding(16.dp)
                )
            }

            Spacer(modifier = Modifier.height(14.dp))

            // Version Info
            Text(
                text = "Version 1.0",
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                modifier = Modifier.padding(bottom = 24.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            // App Description
            Text(
                text = "BDU Services is designed to provide accurate and fair pricing information for various services available to the BDU community. My goal is to prevent overcharging and ensure transparency, helping students and staff make informed decisions about services such as food, laundry, and on any other services. All prices displayed in this app are based on official university records. Users can verify these prices through the BDU Student Union channel or by checking physically posted price lists on campus.",                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.8f),
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(bottom = 16.dp)
            )


            HorizontalDivider(
                modifier = Modifier.padding(vertical = 16.dp),
                thickness = 1.dp,
                color = Color.LightGray.copy(alpha = 0.4f)
            )

            // Developer Section
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = "Developed by",
                    style = MaterialTheme.typography.labelMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant)

                Text(
                    text = "Abraham Addisu",
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.onSurface,
                    modifier = Modifier.padding(top = 4.dp)
                )

                Text(
                    text = "Software Engineering Student @ BiT",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier.padding(top = 4.dp, bottom = 16.dp)
                )
            }

            // Social Media Section
            Row(
                modifier = Modifier.padding(vertical = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                SocialMediaButton(
                    image = painterResource(id = R.drawable.tg),
                    onClick = {
                        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://t.me/brahamaddisu"))
                        context.startActivity(intent)
                    }
                )

                SocialMediaButton(
                    image = painterResource(id = R.drawable.lnk),
                    onClick = {
                        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/abraham-addisu-b39b08338"))
                        context.startActivity(intent)
                    }
                )
            }
        }

        // Copyright Footer
        Text(
            text = "All rights reserved © 2025 BDU Services",
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
                .align(Alignment.CenterHorizontally),
            textAlign = TextAlign.Center
        )
    }
}

@Composable
private fun SocialMediaButton(
    image: Painter,
    onClick: () -> Unit
) {
    Surface(
        shape = CircleShape,
        color = Color.Transparent,
        modifier = Modifier.size(48.dp),
        onClick = onClick
    ) {
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier
                .padding(8.dp)
                .size(32.dp),
            contentScale = ContentScale.Fit
        )
    }
}
@Composable
@Preview(showBackground = true)
fun AboutPreview(){
    AboutScreen()
}