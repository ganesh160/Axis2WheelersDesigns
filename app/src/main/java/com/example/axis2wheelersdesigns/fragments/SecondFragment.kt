package com.example.axis2wheelersdesigns.fragments

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast

import com.example.axis2wheelersdesigns.R


class SecondFragment : Fragment()
{

lateinit var button1:Button
    lateinit var vv:View
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
    {
        // Inflate the layout for this fragment

        vv= inflater.inflate(R.layout.fragment_second, container, false)

        //handling to read data from first fragment
        var vvs:Bundle?=arguments

        initParams()
        if (vvs!=null){
            Toast.makeText(context,""+ vvs!!.getString("editOne"),Toast.LENGTH_SHORT).show()
        }else {
            Toast.makeText(context,""+ vvs!!.getString("editOne"),Toast.LENGTH_SHORT).show()
        }
        return  vv
    }
    fun initParams()
    {
        button1=vv.findViewById(R.id.button1)
        button1.setOnClickListener { view ->
            this.fragmentManager!!.popBackStack()
        }
    }


}
