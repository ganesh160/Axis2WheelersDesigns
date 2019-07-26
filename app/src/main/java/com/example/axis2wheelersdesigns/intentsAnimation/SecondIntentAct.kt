package com.example.axis2wheelersdesigns.intentsAnimation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.axis2wheelersdesigns.R

class SecondIntentAct : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_intent)
    }

    override fun onBackPressed() {

        finish()
        overridePendingTransition(R.anim.no_animation, R.anim.slide_down)
    }
}
