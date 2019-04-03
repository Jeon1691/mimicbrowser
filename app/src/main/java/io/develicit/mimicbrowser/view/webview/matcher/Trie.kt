package io.develicit.mimicbrowser.view.webview.matcher

import android.util.SparseArray
import androidx.core.util.getOrElse
import io.develicit.mimicbrowser.view.webview.matcher.util.FocusString

internal open class Trie private constructor(char: Char, parent: Trie?) {

    val children: SparseArray<Trie> = SparseArray()
    var isTerminated = false

    fun findNode(string: FocusString): Trie? {
        when {
            isTerminated -> if (string.length() == 0 || string.charAt(0) == '.') return this
            string.length() == 0 -> return null
        }

        val next = children.getOrElse(string.charAt(0).toInt()) {
            return null
        }
        return next.findNode(string.substring(1))
    }

    fun put(string: FocusString): Trie? {
        if (string.length() == 0) {
            isTerminated = true
            return this
        }

        val child = put(string.charAt(0))
        return child.put(string.substring(1))
    }

    fun put(char: Char): Trie = children.getOrElse(char.toInt()) {
        createNode(char, this).also {
            children.put(char.toInt(), it)
        }
    }


    protected open fun createNode(char: Char, parent: Trie?): Trie = Trie(char, parent)

    class WhiteListTrie(char: Char, parent: WhiteListTrie?) : Trie(char, parent) {

        internal var whiteList: Trie? = null

        override fun createNode(char: Char, parent: Trie?): Trie = WhiteListTrie(char, parent as? WhiteListTrie)

        fun putWhiteList(string: FocusString, whiteList: Trie) {
            val node = put(string) as? WhiteListTrie
            node?.whiteList = whiteList
        }

        companion object {
            fun createRootNode(): WhiteListTrie = WhiteListTrie(Char.MIN_VALUE, null)
        }
    }

    companion object {
        fun createRootNode(): Trie = Trie(Char.MIN_VALUE, null)
    }

    init {
        @Suppress("LeakingThis")
        parent?.children?.put(char.toInt(), this)
    }
}