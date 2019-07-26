package com.example.axis2wheelersdesigns.noFindviewbyIdActivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.axis2wheelersdesigns.R
import com.example.axis2wheelersdesigns.Utlis.CustomToast
import com.example.axis2wheelersdesigns.Utlis.Utilities
import kotlinx.android.synthetic.main.activity_no_find_views_in.*

class NoFindViewsInAct : AppCompatActivity(),View.OnClickListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_no_find_views_in)
        initParameters()
    }
    fun initParameters()
    {

        Bolo_btn.setOnClickListener (this)
    }

    override fun onClick(p0: View?) {

        when (p0?.id)
        {
            R.id.Bolo_btn ->
            {
                performdataButtonClicks()
            }
            R.id.hello_btn ->
            {

            }
        }
    }
    fun performdataButtonClicks()
    {
        val oneInputDate:String=one_input.text.toString().trim()
        val secondInputDate:String=two_input.text.toString().trim()
        val thirdInputDate:String=three_input.text.toString().trim()

        if (oneInputDate.isEmpty()){
            Utilities().popuLateEditTextError(one_input,"enter valid data")
        }else if (secondInputDate.isEmpty()){
            Utilities().popuLateEditTextError(two_input,"enter valid data")
        }else{
            CustomToast().showCustomToast(this,""+oneInputDate+""+secondInputDate)
        }
    }
}
