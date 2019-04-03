package io.develicit.mimicbrowser.view.webview

import android.view.View
import io.develicit.mimicbrowser.view.listener.IFindListener
import mozilla.components.browser.session.Download
import mozilla.components.browser.session.Session
import mozilla.components.concept.engine.HitResult
import java.util.*

interface IWebView {

    fun setBlockingEnabled(enabled: Boolean)

    fun setRequestDesktop(shouldRequestDesktop: Boolean)

    fun setCallback(callback: Callback)

    fun onPause()

    fun onResume()

    fun destroy()

    fun reload()

    fun stopLoading()

    fun getUrl(): String

    fun loacUrl(url: String)

    fun cleanUp()

    fun goForward()

    fun goBack()

    fun canGoForward(): Boolean

    fun canGoBack(): Boolean

    fun restoreWebViewState(session: Session)

    fun saveWebVewState(session: Session)

    fun exitFullScreen()

    fun findAllAsync(find: String)

    fun findNext(forward: Boolean)

    fun clearMatches()

    fun setFindListener(findListener: IFindListener)

    fun loadData(baseURL: String, data: String, mimeType: String, encoding: String, historyURL: String)

    fun releaseGeckoSession()

    fun updateLocale(current: Locale)

    interface Callback {
        fun onPageStarted(url: String)

        fun onPageFinished(isSecure: Boolean)

        fun onSecurityChanged(isSecure: Boolean, host: String, organization: String)

        fun onProgress(progress: Int)

        fun onURLChanged(url: String)

        fun onTitleChanged(url: String)

        fun onRequest(isTriggeredByUserGesture: Boolean)

        fun onDownloadStart(download: Download)

        fun onLongPress(hitResult: HitResult)

        fun onEnterFullScreen(callback: FullScreenCallback, view: View?)

        fun onExitFullScreen()

        fun countBlockedTracker()

        fun resetBlockedTrackers()

        fun onBlockingStateChanged(isBlockingEnabled: Boolean)

        fun onHttpAuthRequest(callback: HttpAuthCallback, host: String, realm: String)

        fun onRequestDesktopStateChanged(shouldRequestDesktop: Boolean)
    }

    interface FullScreenCallback {
        fun fullScreenExited()
    }

    interface HttpAuthCallback {
        fun proceed(username: String, password: String)

        fun cancel()
    }
}