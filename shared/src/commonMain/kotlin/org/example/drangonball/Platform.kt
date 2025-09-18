package org.example.drangonball

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform