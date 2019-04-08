package io.develicit.mimicbrowser.utils.preference.type

import io.develicit.mimicbrowser.utils.preference.security.EncryptedPreference
import kotlin.reflect.KProperty

internal class BooleanPref(private val default: Boolean) : AbstractPref<Boolean>() {
    override fun getFromPref(prop: KProperty<*>, pref: EncryptedPreference): Boolean =
            pref.getBoolean(prop.name, default)

    override fun setToPref(prop: KProperty<*>, value: Boolean, pref: EncryptedPreference) {
        pref.edit().putBoolean(prop.name, value).apply()
    }

    override fun setEditor(prop: KProperty<*>, value: Boolean, editor: EncryptedPreference.Editor) {
        editor.putBoolean(prop.name, value).apply()
    }

}