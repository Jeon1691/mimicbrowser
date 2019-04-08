package io.develicit.mimicbrowser.utils.preference.type

import io.develicit.mimicbrowser.utils.preference.security.EncryptedPreference
import kotlin.reflect.KProperty

internal class LongPref(private val default: Long) : AbstractPref<Long>() {
    override fun getFromPref(prop: KProperty<*>, pref: EncryptedPreference): Long =
            pref.getLong(prop.name, default)

    override fun setToPref(prop: KProperty<*>, value: Long, pref: EncryptedPreference) {
        pref.edit().putLong(prop.name, value).apply()
    }

    override fun setEditor(prop: KProperty<*>, value: Long, editor: EncryptedPreference.Editor) {
        editor.putLong(prop.name, value).apply()
    }

}