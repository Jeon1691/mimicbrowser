package io.develicit.mimicbrowser.utils

import android.net.Uri
import android.webkit.URLUtil

object UrlUtils {
    fun normalize(input: String): String {
        val string = input.trim()
        val uri = Uri.parse(string)
        return when {
            uri.scheme.isNullOrEmpty() -> Uri.parse("http://$string}").toString()
            else -> uri.toString()
        }
    }

    fun isUrl(url: String): Boolean =
        url.trim().let { !it.contains(' ') && (it.contains('.') || it.contains(':')) }

    fun isValidSearchQueryUrl(url: String): Boolean {
        val handled = url.trim().let { if (!it.matches(Regex("^.+?://.+?"))) "http://$it" else it }
        val isNetworkUrl = URLUtil.isNetworkUrl(handled)
        val isContainToken = handled.contains("%s")
        return isNetworkUrl && isContainToken
    }
}