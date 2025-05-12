package com.example.post_list_app.repositories

import com.example.post_list_app.models.Post
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse

class PostRepository(private val client: HttpClient) {
    suspend fun fetchPosts(): List<Post> {
        val response: HttpResponse = client.get("https://jsonplaceholder.typicode.com/posts")
        return response.body()
    }


//This also works, if you uncomment it then you must also uncomment the getHttpClient function in the HttpClientEngineProvider.kt
//suspend fun fetchPosts(): List<Post> {
//        val response: HttpResponse = client.get("https://jsonplaceholder.typicode.com/posts")
//        val json = response.bodyAsText()
//        return Json.decodeFromString(json)
 //   }
}
