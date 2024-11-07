package com.example.tp3_examen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tp3_examen.R
import com.example.tp3_examen.data.models.BankAccountTransaction

@Composable
fun TransactionsList(transactions: List<BankAccountTransaction>) {
    val borderColor = colorResource(id = R.color.gray_500)
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
fun TransactionItem(transaction: BankAccountTransaction) {
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
                    text = transaction.description,
                    color = colorResource(id = R.color.black),
                    textAlign = TextAlign.Start,
                    modifier = Modifier.fillMaxWidth(),
                    style = TextStyle(
                        fontSize = 14.sp,
                        lineHeight = 19.6.sp
                    )
                )
                Text(
                    text = "operacion id: ${transaction.transaction_id}",
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
                val amountText = if (transaction.type == "credit") {
                    "+ $${transaction.amount}"
                } else {
                    "- $${transaction.amount}"
                }

                val amountColor = if (transaction.type == "credit") {
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

