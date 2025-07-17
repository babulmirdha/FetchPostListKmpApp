package com.babulmirdha.posts_kmp_app.services

import com.babulmirdha.posts_kmp_app.models.User
import com.babulmirdha.posts_kmp_app.repositories.UserRepository
import com.example.post_list_app.models.Post
import com.example.post_list_app.repositories.PostRepository
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse

class UserService(private val client: HttpClient) : UserRepository {

    override suspend fun fetchUsers(): List<User> {
        val response: HttpResponse = client.get("https://jsonplaceholder.typicode.com/users")
        return response.body()
    }
}