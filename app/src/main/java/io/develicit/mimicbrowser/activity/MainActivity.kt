package io.develicit.mimicbrowser.activity

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import io.develicit.mimicbrowser.R
import io.develicit.mimicbrowser.viewmodel.MainViewModel

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    private fun initViewModel() {
        ViewModelProviders.of(this).get(MainViewModel::class.java).getLiveData()
            .observe(this, Observer { isNotYetInit ->
                if (isNotYetInit == true) replace(R.id.main_container) {

                }
            })

    }
}
