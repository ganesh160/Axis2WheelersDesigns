package com.example.axis2wheelersdesigns.Utlis

import android.view.Gravity
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.axis2wheelersdesigns.R

class CustomToast
{
    fun showCustomToast(mContext: AppCompatActivity, message: String) {
        val layoutInflater = mContext.getLayoutInflater()
        val view_custom_toast = layoutInflater.inflate(R.layout.custom_toast_layt, null)
        val text = view_custom_toast.findViewById(R.id.custom_toast_txt_view) as TextView
        val customtoast = Toast(mContext)
        customtoast.setGravity(Gravity.CENTER, 0, 50)
        text.text = message
        customtoast.view = view_custom_toast
        customtoast.duration = Toast.LENGTH_LONG
        customtoast.show()
    }
}