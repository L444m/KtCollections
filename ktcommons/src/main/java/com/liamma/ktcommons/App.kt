package com.liamma.ktcommons

import android.app.Application


/**
 *
 * Created by Liam on 2019/11/16.
 */

class App : Application() {

    companion object {
        lateinit var instance: App
            private set
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

}
