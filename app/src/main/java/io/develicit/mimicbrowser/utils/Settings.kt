package io.develicit.mimicbrowser.utils

import android.content.Context
import android.content.SharedPreferences
import android.content.res.Resources
import android.preference.PreferenceManager
import io.develicit.mimicbrowser.R

class Settings private constructor(context: Context) {
    private val pref: SharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
    private val resources: Resources = context.resources

    val hassAddedToHomeScreen: Boolean
        get() = pref.getBoolean(keyOf(R.string.has_added_to_home_screen), false)

    val defaultSearchEngine: String
        get() = pref.getString(keyOf(R.string.pref_key_search_engine), "") ?: ""

    fun shouldBlockImages(): Boolean = pref.getBoolean(keyOf(R.string.pref_key_performance_block_images), false)

    fun shouldEnableRemoteDebugging(): Boolean = pref.getBoolean(keyOf(R.string.pref_key_remote_debugging), false)

    fun shouldDisplayHomescreenTips(): Boolean = pref.getBoolean(keyOf(R.string.pref_key_homescreen_tips), false)

    fun shouldShowSearchSuggestions(): Boolean =
        pref.getBoolean(keyOf(R.string.pref_key_show_search_suggestions), false)

    fun shouldBlockJavaScript(): Boolean = pref.getBoolean(keyOf(R.string.pref_key_performance_block_javascript), false)

    fun shouldBlockCookiesValue(): String = pref.getString(
        keyOf(R.string.pref_key_performance_enable_cookies),
        resources.getString(R.string.pref_key_should_block_cookies_no)
    ) ?: ""

    fun getCookiesPrefValue(): String = when (shouldBlockCookiesValue()) {
//        resources.getString(R.string.pref_key_privacy_block_ads)
    }

    fun shouldBlockCookies(): Boolean =
        getCookiesPrefValue() == keyOf(R.string.pref_key_should_block_cookies_yes_option)

    fun shouldBlockThirdPartyCookies(): Boolean = when (getCookiesPrefValue()) {
        keyOf(R.string.pref_key_should_block_cookies_third_party_only),
        keyOf(R.string.pref_key_should_block_cookies_yes_option) -> true
        else -> false
    }

    fun shouldSHowFirstRun(): Boolean = !pref.getBoolean("firstrun_shown", false) // TODO: 교체

    fun shouldUserBiometrics(): Boolean = pref.getBoolean(keyOf(R.string.pref_key_biometric), false)

    fun shouldUseSecureMode(): Boolean = pref.getBoolean(keyOf(R.string.pref_key_secure), false)

    fun setDefaultSearchEngine(name: String) {
        pref.edit()
            .putString(keyOf(R.string.pref_key_search_engine), name)
            .apply()
    }

    fun shouldBlockAdTrackers(): Boolean = pref.getBoolean(keyOf(R.string.pref_key_privacy_block_ads), true)

    fun shouldUseSafeBrowsing(): Boolean = pref.getBoolean(keyOf(R.string.pref_key_safe_browsing), true)

    fun shouldBlockAnalyticsTrackers(): Boolean =
        pref.getBoolean(keyOf(R.string.pref_key_privacy_block_analytics), false)

    fun shouldBlockSocialTrackers(): Boolean = pref.getBoolean(keyOf(R.string.pref_key_privacy_block_social), true)

    fun shouldBlockOtherTrackers(): Boolean = pref.getBoolean(keyOf(R.string.pref_key_privacy_block_analytics), false)

    private fun keyOf(id: Int): String = resources.getString(id)

    companion object {
        private var instance: Settings? = null

        @Synchronized
        fun getInstance(context: Context): Settings {

            if (instance == null)
                instance = Settings(context.applicationContext)

            return instance ?: throw AssertionError("Instance is not initialized.")
        }
    }
}