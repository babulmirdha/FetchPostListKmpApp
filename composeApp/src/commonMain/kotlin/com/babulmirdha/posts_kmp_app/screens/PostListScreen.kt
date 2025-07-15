package com.babulmirdha.posts_kmp_app.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.post_list_app.viewmodels.PostViewModel
import org.koin.compose.koinInject


@Composable
fun PostListScreen() {
    val viewModel: PostViewModel = koinInject()
    val posts = viewModel.posts

    LaunchedEffect(Unit) {
        viewModel.loadPosts()
    }

    LazyColumn {
        items(posts) { post ->
            Card(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth(),
                elevation = 4.dp
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(text = post.title, style = MaterialTheme.typography.h6)
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(text = post.body, style = MaterialTheme.typography.body2)
                }
            }
        }
    }
}
