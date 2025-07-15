package com.babulmirdha.posts_kmp_app.services

import com.example.post_list_app.models.Post
import com.example.post_list_app.repositories.PostRepository
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse


class PostService(private val client: HttpClient) : PostRepository {

    override suspend fun fetchPosts(): List<Post> {
                val response: HttpResponse = client.get("https://jsonplaceholder.typicode.com/posts")
        return response.body()
    }
}
