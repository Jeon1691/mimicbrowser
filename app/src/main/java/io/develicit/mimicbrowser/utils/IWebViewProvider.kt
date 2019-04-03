package io.develicit.mimicbrowser.utils

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.webkit.WebSettings
import io.develicit.mimicbrowser.view.webview.SystemWebView

interface IWebViewProvider {

    fun preload(context: Context)

    fun create(context: Context, attrs: AttributeSet?): View

    fun performCleanup(context: Context)

    fun performNewBrowserSessionCleanup()

    fun requestMobileSite(context: Context, webSettings: WebSettings)

    fun requestDesktopSite(webSettings: WebSettings)

    fun applyAppSettings(context: Context, webSettings: WebSettings, systemWebView: SystemWebView)

    fun disableBloking(webSettings: WebSettings, systemWebView: SystemWebView)

    fun getUABrowserString(existingUAString: String, focusToken: String): String
}