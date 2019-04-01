package io.develicit.mimicbrowser.activity

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

abstract class BaseActivity : AppCompatActivity() {

    fun replace(id: Int, fragment: () -> Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(id, fragment())
            .addToBackStack(null)
            .commitAllowingStateLoss()
    }
}