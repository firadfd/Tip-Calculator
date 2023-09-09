package com.example.practice.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HeaderText(data: String, modifier: Modifier = Modifier) {
    Text(
        text = data, style = TextStyle(
            color = Color.Black, fontFamily = FontFamily.Default, fontWeight = FontWeight.Bold
        ), modifier = modifier.padding(2.dp), fontSize = 20.sp
    )
}

@Composable
fun TotalHeader(amount: String) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        color = Color.Cyan,
        shape = RoundedCornerShape(8.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            HeaderText(data = "প্রতিজনের খরচ")
            Spacer(modifier = Modifier.height(10.dp))
            HeaderText(data = "$ $amount")
        }
    }

}

