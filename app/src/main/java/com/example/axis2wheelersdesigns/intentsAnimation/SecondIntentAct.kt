package com.example.axis2wheelersdesigns.intentsAnimation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.axis2wheelersdesigns.R
import com.example.axis2wheelersdesigns.Utlis.CustomToast
import com.example.axis2wheelersdesigns.Utlis.InsertModl
import com.example.axis2wheelersdesigns.Utlis.Utilities
import com.example.axis2wheelersdesigns.adapters.SampleRecycless
import kotlinx.android.synthetic.main.activity_second_intent.*

class SecondIntentAct : AppCompatActivity() {
    lateinit var lists:ArrayList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_intent)
        initializeDropDown()
        listeners()
    }

    fun initializeDropDown()
    {
        val list= ArrayList<InsertModl>()
        lists=ArrayList()
        lists.add("-- Select One Thing --")
        lists.add("hello")
        val adapter=ArrayAdapter(this,android.R.layout.simple_dropdown_item_1line,lists)
        spinner_one.adapter=adapter


        //static recyclerview data bindings
        list.add(InsertModl("One","Two","Three"))
        list.add(InsertModl("One1","Two1","Three1"))
        list.add(InsertModl("One2","Two2","Three2"))

        val adapterss=SampleRecycless(list,this)
        recycler_views.adapter=adapterss
        recycler_views.layoutManager=LinearLayoutManager(this)
    }

    override fun onBackPressed() {
        finish()
        overridePendingTransition(R.anim.no_animation, R.anim.slide_down)
    }

    fun listeners(){

        spinner_one.onItemSelectedListener= object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(p0: AdapterView<*>?) {
            }

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                CustomToast().showCustomToast(this@SecondIntentAct,""+p0!!.getItemAtPosition(p2).toString())
            }
        }
    }



}
