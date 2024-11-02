package com.example.tp3_examen.componentes.navigationdrawer

import android.R.attr.fontFamily
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tp3_examen.R
import com.example.tp3_examen.components1.WavingHandIcon


@Composable
fun DrawerHeader() {
    var name = "Mariana Belén";  //Provisorio. Borrar cuando haya conexión con la API.




        Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = stringResource(R.string.profile_text),
            fontSize = 19.sp,
            fontWeight = FontWeight.W700
        )

            Spacer(modifier = Modifier.width(8.dp))

        Image(
            painter = painterResource(id = R.drawable.profile_picture),
            contentDescription = "User Photo",
            modifier = Modifier
                .size(200.dp)
                .clip(CircleShape)
                .padding(bottom = 8.dp)
        )

        Row(
            modifier = Modifier
                .padding(top = 4.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            WavingHandIcon()

            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = stringResource(R.string.drawer_greeting, name),
                fontSize = 19.sp,
                fontWeight = FontWeight.W700,


            )
        }
    }
}
