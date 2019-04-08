package io.develicit.mimicbrowser.utils

import android.content.Context
import io.develicit.mimicbrowser.Components
import io.develicit.mimicbrowser.MimicBrowserApplication

val Context.application: MimicBrowserApplication
    get() = applicationContext as MimicBrowserApplication

val Context.components: Components
    get() = application.components