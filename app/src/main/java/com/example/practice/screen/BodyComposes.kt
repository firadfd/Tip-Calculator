package com.example.practice.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Slider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.practice.formatDecimal


@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun UserInputArea(
    amount: String,
    amountChange: (String) -> Unit,
    personCount: Int,
    onPersonChange: (Int) -> Unit,
    tipPercentage: Float,
    tipPercentageChange: (Float) -> Unit
) {
    val keyboardController = LocalSoftwareKeyboardController.current
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp),
        shape = RoundedCornerShape(12.dp),
        shadowElevation = 12.dp
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(5.dp))
            OutlinedTextField(value = amount, onValueChange = {
                amountChange.invoke(it)
            }, modifier = Modifier.fillMaxWidth(), placeholder = {
                Text(text = "মোট খরচের পরিমাণ")
            }, keyboardOptions = KeyboardOptions(
                autoCorrect = true,
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Done
            ), keyboardActions = KeyboardActions(onDone = {
                keyboardController?.hide()
            })
            )
            Spacer(modifier = Modifier.height(5.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "মোট ব্যক্তি",
                    style = MaterialTheme.typography.bodyMedium,
                    fontSize = 16.sp,
                    color = Color.Black
                )
                Spacer(modifier = Modifier.fillMaxWidth(.50f))
                CustomButton(imageVector = Icons.Default.KeyboardArrowDown) {
                    onPersonChange.invoke(-1)
                }
                Text(
                    text = "$personCount", style = MaterialTheme.typography.bodyMedium
                )
                CustomButton(imageVector = Icons.Default.KeyboardArrowUp) {
                    onPersonChange.invoke(1)
                }

            }
            Spacer(modifier = Modifier.height(5.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "মোট বখশিশ", style = MaterialTheme.typography.bodyMedium)
                Spacer(modifier = Modifier.fillMaxWidth(.50f))
                Text(
                    text = formatDecimal(tipPercentage.toString()),
                    style = MaterialTheme.typography.bodyMedium
                )
            }
            Spacer(modifier = Modifier.height(5.dp))
            Slider(value = tipPercentage, onValueChange = {
                tipPercentageChange.invoke(it)
            }, valueRange = 0f..500f, steps = .5f.toInt())
            Spacer(modifier = Modifier.height(5.dp))
            Text(
                text = formatDecimal(tipPercentage.toString()),
                style = MaterialTheme.typography.bodyMedium
            )


            Spacer(modifier = Modifier.height(5.dp))
        }
    }

}

@Composable
fun CustomButton(imageVector: ImageVector, onclick: () -> Unit) {
    Card(
        modifier = Modifier
            .wrapContentHeight()
            .padding(12.dp)
            .clickable {
                onclick.invoke()
            }, shape = CircleShape
    ) {
        Icon(
            imageVector = imageVector,
            contentDescription = null,
            modifier = Modifier
                .size(30.dp)
                .padding(4.dp)
        )
    }
}

