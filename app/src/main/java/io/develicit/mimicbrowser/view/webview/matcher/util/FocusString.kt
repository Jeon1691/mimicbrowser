package io.develicit.mimicbrowser.view.webview.matcher.util

import androidx.annotation.CheckResult

abstract class FocusString(val string: String, val offsetStart: Int, val offsetEnd: Int) {

    fun length(): Int = offsetEnd - offsetStart

    @CheckResult
    fun reverse(): FocusString =
        if (isReversed()) ForwardString(string, offsetStart, offsetEnd)
        else ReverseString(string, offsetStart, offsetEnd)

    abstract fun isReversed(): Boolean

    abstract fun charAt(position: Int): Char

    abstract fun substring(startIndex: Int): FocusString

    private class ForwardString(string: String, offsetStart: Int, offsetEnd: Int) :
        FocusString(string, offsetStart, offsetEnd) {
        override fun isReversed(): Boolean = false

        override fun charAt(position: Int): Char = string[position + offsetStart]

        override fun substring(startIndex: Int): FocusString =
            ForwardString(string, offsetStart + startIndex, offsetEnd)
    }

    private class ReverseString(string: String, offsetStart: Int, offsetEnd: Int) :
        FocusString(string, offsetStart, offsetEnd) {
        override fun isReversed(): Boolean = true

        override fun charAt(position: Int): Char = string[length() - 1 - position + offsetStart]

        override fun substring(startIndex: Int): FocusString =
            ReverseString(string, offsetStart, offsetEnd - startIndex)
    }

    companion object {
        fun create(string: String): FocusString = ForwardString(string, 0, string.length)
    }

}