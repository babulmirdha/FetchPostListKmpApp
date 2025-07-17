package com.babulmirdha.posts_kmp_app.viewmodels

import androidx.compose.runtime.*
import kotlinx.coroutines.Dispatchers
import com.babulmirdha.posts_kmp_app.models.User
import com.babulmirdha.posts_kmp_app.repositories.UserRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


class UserViewModel(private val repository: UserRepository) {
    var users by mutableStateOf<List<User>>(emptyList())
        private set

    fun loadUsers() {
        CoroutineScope(Dispatchers.Default).launch{
            users = repository.fetchUsers()
        }
    }
}