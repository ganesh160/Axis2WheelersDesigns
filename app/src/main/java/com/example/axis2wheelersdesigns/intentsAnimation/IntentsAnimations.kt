package com.example.axis2wheelersdesigns.intentsAnimation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.axis2wheelersdesigns.R
import kotlinx.android.synthetic.main.activity_intents_animations.*

class IntentsAnimations : AppCompatActivity(), View.OnClickListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intents_animations)

        submit_btn.setOnClickListener (this)
    }
    override fun onClick(p0: View?) {
     when(p0?.id)
     {
         R.id.submit_btn ->
         {
             startActivity(Intent(this,SecondIntentAct::class.java))
             overridePendingTransition(R.anim.slide_up,  R.anim.no_animation)
         }
     }
    }
}
