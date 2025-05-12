package com.babulmirdha.posts_kmp_app

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import com.example.post_list_app.providers.HttpClientEngineProvider
import com.example.post_list_app.repositories.PostRepository
import com.example.post_list_app.screens.PostListScreen
import com.example.post_list_app.viewmodels.PostViewModel
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    MaterialTheme {
        val viewModel = remember { PostViewModel(PostRepository(HttpClientEngineProvider.createHttpClient())) }
        PostListScreen(viewModel)
    }
}