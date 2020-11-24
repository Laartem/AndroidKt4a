package com.esiea.androidkt4a.injection

import com.esiea.androidkt4a.MainViewModel
import org.koin.dsl.module

val presentationModule = module {
    factory { MainViewModel() }
}