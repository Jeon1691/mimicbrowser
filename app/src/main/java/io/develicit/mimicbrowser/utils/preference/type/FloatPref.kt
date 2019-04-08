package io.develicit.mimicbrowser.utils.preference.type

import io.develicit.mimicbrowser.utils.preference.security.EncryptedPreference
import kotlin.reflect.KProperty

internal class FloatPref(private val default: Float) : AbstractPref<Float>() {
    override fun getFromPref(prop: KProperty<*>, pref: EncryptedPreference): Float =
            pref.getFloat(prop.name, default)

    override fun setToPref(prop: KProperty<*>, value: Float, pref: EncryptedPreference) {
        pref.edit().putFloat(prop.name, value).apply()
    }

    override fun setEditor(prop: KProperty<*>, value: Float, editor: EncryptedPreference.Editor) {
        editor.putFloat(prop.name, value).apply()
    }

}