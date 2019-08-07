package com.example.axis2wheelersdesigns.fragments

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

import com.example.axis2wheelersdesigns.R
import com.example.axis2wheelersdesigns.Utlis.Utilities
import com.example.axis2wheelersdesigns.activity.BaseActivity


class FirstFragment : Fragment()
{
     var  mFragmentMgr: FragmentManager? = null
    lateinit var text_hello:Button
    lateinit var vi: View
    lateinit var radio_group:RadioGroup
    lateinit var edit_label1:EditText
    lateinit var edit_label2:EditText

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle? ): View? {
        // Inflate the layout for this fragment
        vi= inflater.inflate(R.layout.fragment_first, container, false)
        findDatas()
        return vi
    }
    fun findDatas()
    {
        text_hello=vi.findViewById(R.id.text_hello)

        text_hello.setOnClickListener{ v->

            //code for displaying the fragment on button clicks
            /*mFragmentMgr = this.fragmentManager
            val mTransaction:FragmentTransaction  = mFragmentMgr!!.beginTransaction();
            mTransaction.replace(R.id.frame_container, SecondFragment())
            mTransaction.addToBackStack(null)
            mTransaction.commitAllowingStateLoss()
*/
            perfiormDataOPeration()
        }
    }
    fun perfiormDataOPeration() {

        edit_label1 = vi.findViewById(R.id.edit_label1)
        edit_label2 = vi.findViewById(R.id.edit_label2)

        val mEditTextData: String = edit_label1.text.toString().trim()
        val mEditText2: String = edit_label2.text.toString()
        if (mEditTextData.isEmpty()) {
            Utilities().popuLateEditTextError(edit_label1, "enter valid data")
        } else if (mEditText2.isEmpty()) {
            Utilities().popuLateEditTextError(edit_label2, "enter valid data")
        } else {


            //code to transfer data to secondFragment
            val b= Bundle()
            b.putString("editOne",""+edit_label1.text.toString().trim())
            val f= SecondFragment()
            f.arguments=b

            mFragmentMgr = this.fragmentManager
            val mTransaction: FragmentTransaction = mFragmentMgr!!.beginTransaction();
            mTransaction.replace(R.id.frame_container, f)
            mTransaction.addToBackStack(null)
            mTransaction.commitAllowingStateLoss()

        }
    }

}
