package com.example.tp3_examen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.tp3_examen.R

@Composable
fun CircularImage(
    size: Int,
    modifier: Modifier = Modifier,
    imageId: Int

) {

        /*
        Image(
            painter = painterResource(id = R.drawable.profile_picture),
            contentDescription = "Circular Image",
            modifier = Modifier
                .size(100.dp)
                .clip(CircleShape)
        )
        */
        Image(
            painter = painterResource(id = R.drawable.profile_picture),
            contentDescription = "User Photo",
            modifier = Modifier
                .size(170.dp)
                .padding(bottom = 32.dp)
        )

}