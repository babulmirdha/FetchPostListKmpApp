package com.example.post_list_app.viewmodels

import androidx.compose.runtime.*
import com.example.post_list_app.models.Post
import com.example.post_list_app.repositories.PostRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PostViewModel(private val repository: PostRepository) {
    var posts by mutableStateOf<List<Post>>(emptyList())
        private set

    fun loadPosts() {
        CoroutineScope(Dispatchers.Default).launch {
            posts = repository.fetchPosts()
        }
    }
}
