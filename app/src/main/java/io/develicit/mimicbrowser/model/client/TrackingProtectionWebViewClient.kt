package io.develicit.mimicbrowser.model.client

import android.content.Context
import android.net.Uri
import android.webkit.WebViewClient
import androidx.annotation.WorkerThread
import io.develicit.mimicbrowser.view.webview.matcher.UrlMatcher

class TrackingProtectionWebViewClient(context: Context) : WebViewClient() {

    fun some(uri: Uri) {
        uri matches uri
    }



    infix fun Uri?.matches(pageURI: Uri?): Boolean {
        if (this == null || pageURI == null) return false
        return false
    }

    companion object {
        @Volatile
        private val MATCHER: UrlMatcher

        @WorkerThread
        @Synchronized
        private fun getMatcher(context: Context): UrlMatcher {
            if (MATCHER == null)
                MATCHER = UrlMatcher(context)
        }
    }
}