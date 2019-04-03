package io.develicit.mimicbrowser.view.webview

import android.content.Context
import android.util.AttributeSet
import io.develicit.mimicbrowser.view.webview.IWebView
import io.develicit.mimicbrowser.view.webview.NestedWebView

class SystemWebView(context: Context, attrs: AttributeSet): NestedWebView(context, attrs),
    IWebView {
    private var callback: IWebView.Callback? = null
    private val client: FocusWebViewClient
}
