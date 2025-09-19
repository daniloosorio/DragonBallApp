package org.example.drangonball.di

import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module

fun initKoin() = initKoin(extraModules = emptyList(),config = null)

fun initKoin(extraModules: List<Module>, config: KoinAppDeclaration?){
    startKoin {
        config?.invoke(this)
        modules (
            dataModule,
            *extraModules.toTypedArray()
            )
    }
}