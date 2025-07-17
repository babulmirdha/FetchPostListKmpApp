package com.babulmirdha.posts_kmp_app.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.babulmirdha.posts_kmp_app.viewmodels.UserViewModel
import org.koin.compose.koinInject


@Composable
fun UserListScreen() {
    val viewModel: UserViewModel = koinInject()
    val users = viewModel.users

    LaunchedEffect(Unit){
        viewModel.loadUsers()
    }
    LazyColumn {
        items(users) { user ->
            Card(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth(),
                elevation = 4.dp
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(text = user.name, style = MaterialTheme.typography.h6)
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(text = "@${user.username}", style = MaterialTheme.typography.subtitle2)
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(text = "Email: ${user.email}", style = MaterialTheme.typography.body2)
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "Address: ${user.address.street}, ${user.address.suite}, ${user.address.city}, ${user.address.zipcode}",
                        style = MaterialTheme.typography.body2
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "Coordinates: (${user.address.geo.lat}, ${user.address.geo.lng})",
                        style = MaterialTheme.typography.caption
                    )
                }
            }
        }
    }

}

