package com.example.post_list_app.providers

import io.ktor.client.*
import io.ktor.client.engine.*
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.request.header
import io.ktor.http.HttpHeaders
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

expect fun getPlatformEngine(): HttpClientEngine


/*fun getHttpClient(): HttpClient {
    return HttpClient(getPlatformEngine()) {
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
            })
        }
    }
}*/

object HttpClientEngineProvider {
    fun createHttpClient(): HttpClient {
        return HttpClient(getPlatformEngine()) {
            install(ContentNegotiation) {
                json(Json {
                    prettyPrint = true
                    isLenient = true
                    ignoreUnknownKeys = true
                })
            }

            install(HttpTimeout) {
                requestTimeoutMillis = 60_000  // 60 seconds
                connectTimeoutMillis = 60_000
                socketTimeoutMillis = 60_000
            }

            // 🛠️ This part will fix iOS connection issues
            defaultRequest {
                header(HttpHeaders.Connection, "close")
            }

        }
    }
}


// Tbis also works, if you uncomment it then you must also uncomment the fetchPosts function in the PostRepository.kt
//fun getHttpClient(): HttpClient {
//    return HttpClient {
//        install(ContentNegotiation) {
//            json(Json {
//                ignoreUnknownKeys = true
//                prettyPrint = true
//                isLenient = true
//            })
//        }
//    }
//}
