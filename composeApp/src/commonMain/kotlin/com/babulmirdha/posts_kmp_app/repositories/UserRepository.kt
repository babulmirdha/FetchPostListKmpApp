package com.babulmirdha.posts_kmp_app.repositories

import com.babulmirdha.posts_kmp_app.models.User

interface UserRepository {
    suspend fun fetchUsers(): List<User>
}