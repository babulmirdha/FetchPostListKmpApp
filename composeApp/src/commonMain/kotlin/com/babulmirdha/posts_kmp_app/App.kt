package com.babulmirdha.posts_kmp_app

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import com.example.post_list_app.providers.HttpClientEngineProvider
import com.babulmirdha.posts_kmp_app.services.PostService
import com.example.post_list_app.screens.PostListScreen
import com.example.post_list_app.viewmodels.PostViewModel
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    MaterialTheme {
        val viewModel = remember { PostViewModel(PostService(HttpClientEngineProvider.createHttpClient())) }
        PostListScreen(viewModel)
    }
}