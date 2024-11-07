package com.example.tp3_examen.components.drawermenu

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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tp3_examen.R
import com.example.tp3_examen.components.CircularImage
import com.example.tp3_examen.viewmodels.drawerviewmodel.NavDrawerViewModel


@Composable
fun DrawerHeader(viewModel: NavDrawerViewModel) {

    val userDataState by viewModel.userDataState.observeAsState(NavDrawerViewModel.UserDataState.Loading)


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
                .padding(top = 0.dp, end = 19.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {

            Spacer(modifier = Modifier.width(8.dp))

            when (userDataState) {
                is NavDrawerViewModel.UserDataState.Loading -> {
                    Text(
                        text = stringResource(id = R.string.loading),
                        fontSize = 19.sp,
                        fontWeight = FontWeight.W700,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                }

                is NavDrawerViewModel.UserDataState.Success -> {
                    val userName =
                        (userDataState as NavDrawerViewModel.UserDataState.Success).userName
                    Text(
                        text = stringResource(R.string.drawer_greeting, "👋", "${userName.firstname} ${userName.lastname}"),
                        fontSize = 19.sp,
                        fontWeight = FontWeight.W700,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                }

                is NavDrawerViewModel.UserDataState.Error -> {
                    Text(
                        text = stringResource(id = R.string.error_name),
                        fontSize = 19.sp,
                        fontWeight = FontWeight.W700,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                }
            }
        }
    }
}