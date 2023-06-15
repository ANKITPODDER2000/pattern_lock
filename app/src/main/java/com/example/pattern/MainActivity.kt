package com.example.pattern

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.andrognito.patternlockview.PatternLockView
import com.andrognito.patternlockview.listener.PatternLockViewListener
import com.andrognito.patternlockview.utils.PatternLockUtils

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val pv = findViewById<PatternLockView>(R.id.pattern_lock_view)
        pv.addPatternLockListener(object : PatternLockViewListener {
            override fun onStarted() {}
            override fun onProgress(progressPattern: MutableList<PatternLockView.Dot>?) {}
            override fun onComplete(pattern: MutableList<PatternLockView.Dot>?) {
                val patternInput = PatternLockUtils.patternToString(pv, pattern)
                Toast.makeText(this@MainActivity, "PATTERN is : $patternInput", Toast.LENGTH_SHORT)
                    .show()
            }

            override fun onCleared() {}
        })
    }
}