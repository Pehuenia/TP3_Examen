package com.example.tp3_examen.components1

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tp3_examen.R

data class Transaction(
    val date: String,
    val amount: String,
    val description: String,
    val type: String,
    val isIncoming: Boolean
)

@Composable
fun TransactionsList() {
    val borderColor = colorResource(id = R.color.gray_500)
    val transactions  = listOf(
        Transaction("19-03-20", "2000.00", "Aut. 394991", "Transferencia", true ),
        Transaction("19-03-20", "400.00", "Aut. 394991", "Pago de Servicio", false),
        Transaction("19-03-20", "1000.00", "Aut. 394991", "Transferencia", true),
        Transaction("19-03-20", "100.00", "Aut. 394991", "Recarga Sube", false),
        Transaction("19-03-20", "1000.00", "Aut. 394991", "Transferencia", true),
        Transaction("19-03-20", "1000.00", "Aut. 394991", "Transferencia", false),
    )
    LazyColumn(
        modifier = Modifier.padding(0.dp)
    ) {
        item {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(colorResource(id = R.color.black))
                    .padding(top = 8.dp, end = 12.dp, bottom = 8.dp, start = 12.dp),
                    verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = stringResource(id = R.string.transactions),
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.padding(end = 8.dp),
                    color = colorResource(id = R.color.white)
                )
            }
        }
        items(transactions) { transaction ->
            TransactionItem(transaction)
        }
    }
}

@Composable
fun TransactionItem(transaction: Transaction) {
    val borderColor = colorResource(id = R.color.gray_500)

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(colorResource(id = R.color.white))
            .drawBehind {
                val strokeWidth = 1.dp.toPx()
                val width = size.width
                val height = size.height

                drawLine(
                    color = borderColor,
                    start = Offset(0f, height),
                    end = Offset(width, height),
                    strokeWidth = strokeWidth
                )
            }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp, vertical = 8.dp),
            verticalAlignment = Alignment.Top
        ) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
            ) {
                Text(
                    text = transaction.date,
                    color = colorResource(id = R.color.black),
                    textAlign = TextAlign.Start,
                    modifier = Modifier.fillMaxWidth(),
                    style = TextStyle(
                        fontSize = 14.sp,
                        lineHeight = 19.6.sp
                    )
                )
            }

            Column(
                modifier = Modifier
                    .weight(2f)
                    .fillMaxWidth()
            ) {
                Text(
                    text = transaction.type,
                    color = colorResource(id = R.color.black),
                    textAlign = TextAlign.Start,
                    modifier = Modifier.fillMaxWidth(),
                    style = TextStyle(
                        fontSize = 14.sp,
                        lineHeight = 19.6.sp
                    )
                )
                Text(
                    text = transaction.description,
                    color = colorResource(id = R.color.black),
                    textAlign = TextAlign.Start,
                    modifier = Modifier.fillMaxWidth(),
                    style = TextStyle(
                        fontSize = 14.sp,
                        lineHeight = 19.6.sp
                    )
                )
            }

            Column(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
            ) {
                val amountText = if (transaction.isIncoming) {
                    "+ $${transaction.amount}"
                } else {
                    "- $${transaction.amount}"
                }

                val amountColor = if (transaction.isIncoming) {
                    colorResource(id = R.color.green)
                } else {
                    colorResource(id = R.color.red_900)
                }
                Text(
                    text = amountText,
                    color = amountColor,
                    textAlign = TextAlign.End,
                    modifier = Modifier.fillMaxWidth(),
                    style = TextStyle(
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp,
                        lineHeight = 19.6.sp
                    )
                )
            }
        }
    }
}

