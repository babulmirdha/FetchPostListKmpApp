package com.example.post_list_app.providers

import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.okhttp.OkHttp

actual fun getPlatformEngine(): HttpClientEngine = OkHttp.create()