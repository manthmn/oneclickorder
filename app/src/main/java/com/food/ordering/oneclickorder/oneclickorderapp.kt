package com.food.ordering.oneclickorder

import android.app.Application
import com.food.ordering.oneclickorder.di.appModule
import com.food.ordering.oneclickorder.di.networkModule
import com.food.ordering.oneclickorder.di.viewModelModule
import com.food.ordering.oneclickorder.utils.PicassoImageLoadingService
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import ss.com.bannerslider.Slider

class oneclickorderapp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@oneclickorderapp)
            modules(listOf(appModule, networkModule, viewModelModule))
        }
        Slider.init(PicassoImageLoadingService(this))
    }

}