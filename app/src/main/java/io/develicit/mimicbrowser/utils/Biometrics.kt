package io.develicit.mimicbrowser.utils

import android.app.KeyguardManager
import android.content.Context
import android.hardware.fingerprint.FingerprintManager
import androidx.core.hardware.fingerprint.FingerprintManagerCompat

object Biometrics {
    fun hasFingerprint(context: Context?): Boolean {
        if (context == null) return false

        val fm = FingerprintManagerCompat.from(context)
        val km = context.getSystemService(Context.KEYGUARD_SERVICE) as? KeyguardManager ?: return false

        return km.isKeyguardSecure && fm.isHardwareDetected && fm.hasEnrolledFingerprints()

    }
}