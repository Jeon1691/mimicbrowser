package io.develicit.mimicbrowser.provider

import android.content.Context
import io.develicit.mimicbrowser.store.CustomSearchEngineStore
import mozilla.components.browser.search.SearchEngine
import mozilla.components.browser.search.provider.SearchEngineProvider

class CustomSearchEngineProvider: SearchEngineProvider {
    override suspend fun loadSearchEngines(context: Context): List<SearchEngine> {
        CustomSearchEngineStore
    }
}