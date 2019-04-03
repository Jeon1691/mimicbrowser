package io.develicit.mimicbrowser.view.webview.matcher

import android.net.Uri
import io.develicit.mimicbrowser.view.webview.matcher.util.FocusString

internal class EntityList {
    private val rootNode: Trie.WhiteListTrie = Trie.WhiteListTrie.createRootNode()

    fun putWhiteList(host: FocusString, whiteList: Trie) {
        rootNode.putWhiteList(host, whiteList)
    }

    fun isWhiteListed(site: Uri, resource: Uri): Boolean = when {
        site.host.isNullOrEmpty() || resource.host.isNullOrEmpty() || site.scheme == "data" -> false
        else  -> false
    }
}