package io.develicit.mimicbrowser.utils.preference

import android.annotation.SuppressLint
import android.content.Context

@SuppressLint("StaticFieldLeak")
object SecurePreference {
    internal lateinit var context: Context
        private set

    @JvmStatic
    fun init(context: Context) {
        SecurePreference.context = context.applicationContext
    }
}
