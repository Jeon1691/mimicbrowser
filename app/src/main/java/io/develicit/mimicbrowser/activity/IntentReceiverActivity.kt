package io.develicit.mimicbrowser.activity

import android.content.Intent
import android.os.Bundle
import io.develicit.mimicbrowser.R

class IntentReceiverActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent_receiver)
    }

    private fun dispatchIntent() {
        startActivity(
            Intent(intent)
                .setClassName(applicationContext, MainActivity::class.java.name)
                .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP)
        )
    }
}
