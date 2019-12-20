package com.liamma.ktcommons.exts

import android.content.Context
import android.os.Build
import android.text.Editable
import android.text.Html
import android.text.TextWatcher
import android.widget.EditText
import android.widget.TextView

/**
 * Extensions for views.
 * Created by Liam on 2019/11/16.
 */


/**
 * Returns string of all content for this TextView.
 */
fun TextView.getAllText(): String = this.text?.toString() ?: ""

/**
 *
 */
fun TextView.getTrimText(): String = this.text?.toString()?.trim() ?: ""

fun TextView.isEmpty(): Boolean = this.getAllText().isEmpty()

fun TextView.setClickStatus(enable: Boolean, alpha: Float? = 0.5f) {
    if (enable) {
        this.isClickable = true
        if (alpha != null) {
            this.alpha = 1f
            this.setTextColor(this.textColors?.withAlpha(255))
        }
    } else {
        this.isClickable = false
        if (alpha != null) {
            this.alpha = alpha
            this.setTextColor(this.textColors?.withAlpha((alpha * 255).toInt()))
        }
    }
}

fun TextView.loadHtml(html: String?) {
    this.text = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
        Html.fromHtml(html, Html.FROM_HTML_MODE_LEGACY)
    } else {
        Html.fromHtml(html)
    }
}


fun EditText.enableEdit() {

}

inline fun EditText.afterTextChanged(crossinline action: (Editable?) -> Unit) {
    this.addTextChangedListener(object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {
            action.invoke(s)
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        }
    })
}

inline fun EditText.beforeTextChanged(crossinline action: (CharSequence?, Int, Int, Int) -> Unit) {
    this.addTextChangedListener(object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            action.invoke(s, start, count, after)
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        }
    })
}

inline fun EditText.onTextChanged(crossinline action: (CharSequence?, Int, Int, Int) -> Unit) {
    this.addTextChangedListener(object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            action.invoke(s, start, before, count)
        }
    })
}

// ImageView

// Button

// Layout

/**
 * Returns true if the specified EditText is empty.
 */
fun Context.checkEditEmpty(editText: EditText?, showToast: Boolean = true): Boolean {

    return false
}

fun Context.checkEditsEmpty(vararg: EditText?, showToast: Boolean = true): Boolean {

    return false
}
