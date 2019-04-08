package io.develicit.mimicbrowser.model.client

import android.content.Context
import android.webkit.WebViewClient
import androidx.annotation.WorkerThread
import io.develicit.mimicbrowser.view.webview.matcher.UrlMatcher

class TrackingProtectionWebViewClient(context: Context) : WebViewClient() {
    companion object {
        @Volatile
        private val MATCHER: UrlMatcher
            get(context: Context) {
                return UrlMatcher.load
            }

        @WorkerThread
        @Synchronized
        private fun getMatcher(context: Context): UrlMatcher {

        }
    }


}