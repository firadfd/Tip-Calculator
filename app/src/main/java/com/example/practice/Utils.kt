package com.example.practice

import java.text.DecimalFormat

fun formatDecimal(value: String): String {
    return if (value.isEmpty()) {
        ""
    } else {
        val format = DecimalFormat("#################.##")
        format.format(value.toFloat())
    }
}


fun getTotalHeaderAmount(amount: String, personCounter: Int, tipPerPerson: Float): String {
    return when {
        amount.isEmpty() -> {
            ""
        }

        else -> {
            val userAmount = amount.toFloat()
            val totalAmount = userAmount + tipPerPerson
            val perHead = totalAmount.div(personCounter)
            perHead.toString()
        }
    }
}