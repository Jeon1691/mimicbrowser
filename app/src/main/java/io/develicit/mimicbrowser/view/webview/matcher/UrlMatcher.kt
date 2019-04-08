package io.develicit.mimicbrowser.view.webview.matcher

import android.content.Context
import android.content.SharedPreferences
import io.develicit.mimicbrowser.R
import kotlin.collections.HashSet

internal class UrlMatcher(
    context: Context,
    val categoryPrefMap: Map<String, String>,
    val categoryMap: Map<String, Trie>,
    val entityList: EntityList
) : SharedPreferences.OnSharedPreferenceChangeListener {

    private val previouslyMatched: HashSet<String> = hashSetOf()
    private val previouslyUnmatched: HashSet<String> = hashSetOf()
    private var isBlockedWebfonts = true

    override fun onSharedPreferenceChanged(pref: SharedPreferences?, name: String?) {
        pref?.getBoolean(categoryPrefMap[name], false)
    }

    fun setCategoryEanbled(category: String, enbaled: Boolean = true) {
        if (WEBFONTS == category) {

        }
    }

    fun loadPrefs(context: Context) {
        categoryPrefMap.entries.forEach {
            setCategoryEanbled(it.value, when (it.key) {
                context.getString(R.string.pref_key_performance_block_webfonts) -> Settings.getIn
                else -> true
            })
        }
    }

    companion object {
        private val WEBFONTS: String = "Webfonts"

        private val WEBFONT_EXTENSIONS: Array<String> = arrayOf(
            ".woff2",
            ".woff",
            ".eot",
            ".ttf",
            ".otf"
        )

        private fun loadDefaultPrefMap(context: Context): Map<String, String> = mapOf(
            context.getString(R.string.pref_key_privacy_block_ads) to "Advertising",
            context.getString(R.string.pref_key_privacy_block_analytics) to "Analytics",
            context.getString(R.string.pref_key_privacy_block_social) to "Social",
            context.getString(R.string.pref_key_privacy_block_other) to "Content",
            context.getString(R.string.pref_key_performance_block_webfonts) to WEBFONTS
        )

        fun loadMatcher(context: Context, blockListFile: Int, blockListOverrides: Array<Int>, entityListFile: Int) {

        }
    }
}