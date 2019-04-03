package io.develicit.mimicbrowser.view.webview.matcher

import android.content.Context

class UrlMatcher(
    context: Context,
    val categoryPrefMap: Map<String, String>,
    val entityList: EntityList) {

    companion object {
        private val WEBFONT: String = "Webfonts"

        private val WEBFONT_EXTENSIONS: Array<String> = arrayOf(
            ".woff2",
            ".woff",
            ".eot",
            ".ttf",
            ".otf"
        )

        private fun loadDefaultPrefMap(context: Context) {

        }
    }
}