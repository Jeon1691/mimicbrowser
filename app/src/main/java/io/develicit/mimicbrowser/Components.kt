package io.develicit.mimicbrowser

import android.content.Context
import android.util.AttributeSet
import mozilla.components.browser.search.SearchEngine
import mozilla.components.browser.search.SearchEngineManager
import mozilla.components.browser.search.provider.AssetsSearchEngineProvider
import mozilla.components.browser.search.provider.localization.LocaleSearchLocalizationProvider
import mozilla.components.browser.session.Session
import mozilla.components.browser.session.SessionManager
import mozilla.components.concept.engine.*

class Components {
    val sessionManager by lazy {
        SessionManager(DummyEngine()).apply {
            register(SessionSetupObserver())
        }
    }

    val searchEngineManager by lazy {
        val assetsProvider = AssetsSearchEngineProvider(
            LocaleSearchLocalizationProvider(),
            filters = listOf(),
            additionalIdentifiers = listOf("ddg")
        )

        val customProvider = CustomSearch

        SearchEngineManager(listOf(assetsProvider, custom))
    }
}

private class DummyEngine: Engine {
    override val settings: Settings = DefaultSettings()

    override fun createSession(private: Boolean): EngineSession {
        throw NotImplementedError()
    }

    override fun createView(context: Context, attrs: AttributeSet?): EngineView {
        throw NotImplementedError()
    }

    override fun name(): String {
        throw NotImplementedError()
    }
}

class SessionSetupObserver: SessionManager.Observer {
    override fun onSessionAdded(session: Session) {
        session.trackerBlockingEnabled = true.
    }
}