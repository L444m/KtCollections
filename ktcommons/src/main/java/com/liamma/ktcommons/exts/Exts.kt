package com.liamma.ktcommons.exts

import android.content.Context
import android.view.View

/**
 * Extensions
 * Created by Liam on 2019/11/20.
 */

var LAST_CLICK_TIME = 0L

fun View.click(action: () -> Unit) {
    this.setOnClickListener { view ->
        val current = System.currentTimeMillis()
        if (current - LAST_CLICK_TIME >= 500) {
            LAST_CLICK_TIME = current
            action.invoke()
        }
    }
}

fun Context.toast(message: Any) {
    if (message is String) {

    }
}