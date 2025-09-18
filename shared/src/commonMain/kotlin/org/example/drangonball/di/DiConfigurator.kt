package org.example.drangonball.di

import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.dsl.module

fun initKoin() = initKoin(emptyList())

fun initKoin(extraModules: List<Module>){
    startKoin {
        modules (
            dataModule,
            *extraModules.toTypedArray()
            )
    }
}