package com.example.post_list_app.repositories

import com.example.post_list_app.models.Post
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse

interface PostRepository {
   suspend fun fetchPosts(): List<Post>
}
