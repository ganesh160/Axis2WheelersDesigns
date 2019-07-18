package com.example.axis2wheelersdesigns.Utlis

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText

class Utilities
{
    fun popuLateEditTextError( label : EditText,message : String)
    {

        label.requestFocus()
        label.setError(message)

        label.addTextChangedListener(object : TextWatcher
        {
            override fun afterTextChanged(p0: Editable?) {
                if (p0?.toString()!!.length!=0)
                {
                    label.setError(null)
                }
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }


        })
    }
}