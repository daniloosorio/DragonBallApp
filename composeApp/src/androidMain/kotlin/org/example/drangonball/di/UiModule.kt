package org.example.drangonball.di

import org.example.drangonball.ui.detail.DetailViewModel
import org.example.drangonball.ui.home.HomeViewModel
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val uiModule = module {
    factoryOf(::HomeViewModel)
    factoryOf(::DetailViewModel)

}