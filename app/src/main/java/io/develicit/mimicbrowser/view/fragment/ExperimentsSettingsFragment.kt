package io.develicit.mimicbrowser.view.fragment

import android.content.SharedPreferences
import android.preference.PreferenceFragment
import android.preference.SwitchPreference
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext

class ExperimentsSettingsFragment : PreferenceFragment(), CoroutineScope,
    SharedPreferences.OnSharedPreferenceChangeListener {

    private var job = Job()
    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main
    private var enginePref: SwitchPreference? = null

    override fun onSharedPreferenceChanged(pref: SharedPreferences?, key: String?) {
        when (key) {

        }
    }
}