package com.example.tp3_examen.componentes

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tp3_examen.R
import com.example.tp3_examen.components1.CircularImage


@Composable
fun DrawerHeader() {
    // var name = "Mariana Belén"  //Provisorio. Borrar cuando haya conexión con la API.


    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(0.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = stringResource(R.string.profile_text),
            fontSize = 19.sp,
            fontWeight = FontWeight.W700,
            color = MaterialTheme.colorScheme.onSurface,
            modifier = Modifier.padding(top = 25.dp, bottom = 38.dp)
        )



        CircularImage(
            size = 170, modifier = Modifier,
            imageId = R.drawable.profile_picture
        )


        Row(
            modifier = Modifier
                .padding(top = 0.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {


            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = stringResource(R.string.drawer_greeting, "👋", " Mariana Belén"),
                fontSize = 19.sp,
                fontWeight = FontWeight.W700,
                color = MaterialTheme.colorScheme.onSurface
                )
        }

    }
}
