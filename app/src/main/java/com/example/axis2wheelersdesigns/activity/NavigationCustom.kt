package com.example.axis2wheelersdesigns.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.graphics.drawable.DrawerArrowDrawable
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.axis2wheelersdesigns.R
import com.example.axis2wheelersdesigns.fragments.FirstFragment
import com.google.android.material.navigation.NavigationView

class NavigationCustom : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener
{

    lateinit var mtoggleIcons : ActionBarDrawerToggle
    lateinit var drawer_layout : DrawerLayout
    lateinit var navigationView:NavigationView
    lateinit var fagmentManagerss :FragmentManager
    lateinit var fragTrans:FragmentTransaction

    lateinit var arrowDrawable :DrawerArrowDrawable

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation_custom)

        drawer_layout= findViewById(R.id.drawer_layout)
        navigationView= findViewById(R.id.navigationView)
        navigationView.setNavigationItemSelectedListener(this)
        //mtoggleIcons=ActionBarDrawerToggle(this,drawer_layout,R.drawable.person_profile,R.string.ss,R.string.ss1)


    }


    override fun onNavigationItemSelected(p0: MenuItem): Boolean
    {
        drawer_layout.closeDrawer(GravityCompat.START)


        when(p0.itemId)
        {
            R.id.ss ->
            {
                val ss=FirstFragment()
                fagmentManagerss=supportFragmentManager
                fragTrans=fagmentManagerss.beginTransaction()
                fragTrans.replace(R.id.frame_container,ss)
                fragTrans.addToBackStack(null)

                fragTrans.commit()
                    //.beginTransaction().replace(R.id.frame_container,ss).commit()

            }
            R.id.ss1 ->
            {

                val ss=FirstFragment()
                supportFragmentManager.beginTransaction().replace(R.id.frame_container,ss).commit()
                Toast.makeText(applicationContext,"from second frag",Toast.LENGTH_LONG).show()
            }
        }
        drawer_layout.closeDrawer(navigationView)
        return true
    }
}
