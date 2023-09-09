package com.example.practice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.practice.screen.TotalHeader
import com.example.practice.screen.UserInputArea
import com.example.practice.ui.theme.PracticeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PracticeTheme {
                MyApp()
            }
        }
    }
}

@Composable
fun MyApp() {

    val amount = remember {
        mutableStateOf("")
    }
    val personCount = remember {
        mutableStateOf(1)
    }
    val tipPercentage = remember {
        mutableStateOf(0f)
    }
    Surface(
        modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            TotalHeader(
                formatDecimal(
                    getTotalHeaderAmount(
                        amount.value,
                        personCount.value,
                        tipPercentage.value
                    )
                )
            )
            Spacer(modifier = Modifier.height(5.dp))
            UserInputArea(amount.value, {
                amount.value = it

            }, personCount.value, {
                if (it < 0) {
                    if (personCount.value != 1) {
                        personCount.value--
                    }
                } else {
                    personCount.value++
                }

            }, tipPercentage.value, {
                tipPercentage.value = it
            })
        }
    }
}



