package io.develicit.mimicbrowser.utils.preference.security

import android.content.SharedPreferences
import android.os.Build
import androidx.annotation.RequiresApi
import io.develicit.mimicbrowser.utils.preference.type.StringSetPref

internal class PrefInject(internal val preferences: EncryptedPreference) : SharedPreferences by preferences {

    override fun edit(): SharedPreferences.Editor = Editor(preferences.edit())

    internal inner class Editor(val editor: EncryptedPreference.Editor) : SharedPreferences.Editor by editor {
        private val prefSet: MutableMap<String, StringSetPref.PrefSet> by lazy { HashMap<String, StringSetPref.PrefSet>() }

        override fun apply() {
            syncTransaction()
            editor.apply()
        }

        override fun commit(): Boolean {
            syncTransaction()
            return editor.commit()
        }

        @RequiresApi(Build.VERSION_CODES.HONEYCOMB)
        internal fun putStringSet(key: String, values: MutableSet<String>?, pref: StringSetPref.PrefSet): SharedPreferences.Editor {
            prefSet[key] = pref
            return this
        }

        @RequiresApi(Build.VERSION_CODES.HONEYCOMB)
        fun syncTransaction() {
            prefSet.keys.forEach { key ->
                prefSet[key]?.let {
                    editor.putStringSet(key, it)
                    it.syncTransaction()
                }
            }
            prefSet.clear()
        }

        override fun putString(p0: String?, p1: String?): SharedPreferences.Editor = this

        override fun putStringSet(p0: String?, p1: MutableSet<String>?): SharedPreferences.Editor = this
    }

    override fun getString(p0: String?, p1: String?): String? = null

    override fun getStringSet(p0: String?, p1: MutableSet<String>?): MutableSet<String>? = null
}