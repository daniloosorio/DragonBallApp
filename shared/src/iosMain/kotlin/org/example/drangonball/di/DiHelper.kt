package org.example.drangonball.di

import org.example.drangonball.domain.Repository
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class DiHelper: KoinComponent {
    val repository: Repository by inject()
}