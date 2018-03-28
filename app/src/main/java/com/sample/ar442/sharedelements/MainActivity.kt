package com.sample.ar442.sharedelements

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.sample.ar442.sharedelements.ui.ListFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.main_content, ListFragment())
                    .commit()
        }
    }

}
