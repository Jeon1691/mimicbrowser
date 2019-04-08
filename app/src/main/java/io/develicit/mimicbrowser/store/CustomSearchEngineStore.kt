package io.develicit.mimicbrowser.store

import android.content.Context
import android.content.SharedPreferences
import io.develicit.mimicbrowser.utils.components
import mozilla.components.browser.search.SearchEngine
import mozilla.components.browser.search.SearchEngineParser

object CustomSearchEngineStore {
    fun isSearchEngineNameUnique(context: Context, engineName: String): Boolean {
        val sharedPreferences = context.getSharedPreferences(PREF_FILE_SEARCH_ENDGINES, Context.MODE_PRIVATE)

        val defaultEngines = context.components.searchEngineManager.getSearchEngines(context)

        return !sharedPreferences.contains(engineName) && !defaultEngines.any { it.name == engineName }
    }

    fun restoreDefaultSearchEngines(context: Context) {
        pref(context).edit()
            .remove(PREF_KEY_HIDDEN_DEFAULT_ENGINES)
            .apply()
    }

    fun hasAllDefaultSearchEngines(context: Context): Boolean =
        !pref(context).contains(PREF_KEY_HIDDEN_DEFAULT_ENGINES)

    fun addSeearchEngine(context: Context, engineName: String, searchQuery: String): Boolean {

    }

    fun removeSearchEngines(context: Context, engineIdsToRemove: MutableSet<String>) {

    }

    fun getRemovedSearchEngines(context: Context): Set<String> =
        pref(context).getStringSet(PREF_KEY_HIDDEN_DEFAULT_ENGINES, emptySet()) ?: emptySet()

    fun isCustomSearchEngine(engineId: String, context: Context): Boolean {
        loadCustomSearchEngines(context).forEach { if (it.identifier == engineId) return true }
        return false
    }

    fun loadCustomSearchEngines(context: Context): List<SearchEngine> {
        val customEngines = mutableListOf<SearchEngine>()
        val parser = SearchEngineParser()

    }

    private fun pref(context: Context): SharedPreferences =
        context.getSharedPreferences(PREF_FILE_SEARCH_ENDGINES, Context.MODE_PRIVATE)

    const val ENGINE_TYPE_CUSTOM = "custom"
    const val ENGINE_TYPE_BUNDLED = "bundled"

    private const val LOG_TAG = "CustomSearchEngineStore"
    private const val PREF_KEY_CUSTOM_SEARCH_ENGINES = ""
    private const val PREF_KEY_HIDDEN_DEFAULT_ENGINES = ""
    private const val PREF_KEY_CUSTOM_SEARCH_VERSION = ""
    private const val PREF_FILE_SEARCH_ENDGINES = ""
    private const val CUSTOM_SEARCH_ENGINE_VERSION = 1
}