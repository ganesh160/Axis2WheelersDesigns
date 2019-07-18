package com.example.axis2wheelersdesigns.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.axis2wheelersdesigns.R
import com.example.axis2wheelersdesigns.fragments.SecondFragment

class BaseActivity : AppCompatActivity()
{

    lateinit var fragment: Fragment
    //lateinit var fragmentManager: FragmentManager
    lateinit var transaction: FragmentTransaction

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
    }


    fun displayFragment(frags :Fragment)
    {
        /*fragmentManager = supportFragmentManager
        transaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.frame_container, frags)
        transaction.addToBackStack(null)
        transaction.commitAllowingStateLoss()*/

    }
}
