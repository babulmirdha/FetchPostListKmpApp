package com.babulmirdha.posts_kmp_app.di

import com.babulmirdha.posts_kmp_app.repositories.UserRepository
import com.babulmirdha.posts_kmp_app.services.PostService
import com.babulmirdha.posts_kmp_app.services.UserService
import com.babulmirdha.posts_kmp_app.viewmodels.UserViewModel
import com.example.post_list_app.providers.HttpClientEngineProvider
import com.example.post_list_app.repositories.PostRepository
import com.example.post_list_app.viewmodels.PostViewModel
import org.koin.dsl.module


val appModule = module {
    single { HttpClientEngineProvider.createHttpClient() }

    single<PostRepository> { PostService(get()) }
    single<UserRepository> { UserService(get()) }

    factory { PostViewModel(get()) }
    factory { UserViewModel(get()) }

}