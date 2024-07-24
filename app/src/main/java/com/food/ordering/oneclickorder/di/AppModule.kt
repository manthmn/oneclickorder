package com.food.ordering.oneclickorder.di

import com.google.gson.Gson
import com.food.ordering.oneclickorder.data.local.PreferencesHelper
import org.koin.dsl.module

val appModule = module {

    single {
        Gson()
    }

    single {
        PreferencesHelper(get())
    }

}