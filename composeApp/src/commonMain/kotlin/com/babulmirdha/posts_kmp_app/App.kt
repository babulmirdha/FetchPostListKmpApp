package com.babulmirdha.posts_kmp_app

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import com.babulmirdha.posts_kmp_app.screens.UserListScreen
import com.example.post_list_app.providers.HttpClientEngineProvider
import com.babulmirdha.posts_kmp_app.services.PostService
import com.babulmirdha.posts_kmp_app.services.UserService
import com.babulmirdha.posts_kmp_app.viewmodels.UserViewModel
import com.example.post_list_app.screens.PostListScreen
import com.example.post_list_app.viewmodels.PostViewModel
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    MaterialTheme {
        val userViewModel = remember { UserViewModel(UserService(HttpClientEngineProvider.createHttpClient())) }
        UserListScreen(userViewModel)

//        val postViewModel = remember { PostViewModel(PostService(HttpClientEngineProvider.createHttpClient())) }
//        PostListScreen(postViewModel)
    }
}