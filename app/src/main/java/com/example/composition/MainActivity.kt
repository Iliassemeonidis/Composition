package com.example.composition

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.composition.presintation.WelcomeFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
         supportFragmentManager.beginTransaction()
             .replace(R.id.main_container, WelcomeFragment())
             .commitAllowingStateLoss()

    }
}