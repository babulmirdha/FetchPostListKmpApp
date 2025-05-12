package com.example.post_list_app.providers

import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.darwin.Darwin

actual fun getPlatformEngine(): HttpClientEngine = Darwin.create()
